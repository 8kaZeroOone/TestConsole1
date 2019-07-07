package com.ezo;

import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ContactListActions {
    private static final File inputFile = new File("contact_list.txt");
    private static final File tempFile = new File("temp_list.txt");

    private Scanner in = new Scanner(System.in);
    private CheckData checkData = new CheckData();

    void addNew() {
        Contact contact = new Contact();

        System.out.println("Enter contact name: ");
        String name = in.nextLine();
        name = checkData.checkLine(name);
        contact.setName(name);

        System.out.println("Enter contact phone number: ");
        String phone = in.nextLine();
        phone = checkData.checkLine(phone);
        contact.setPhone(phone);

        System.out.println("Enter contact address: ");
        String address = in.nextLine();
        address = checkData.checkLine(address);
        contact.setAddress(address);

        System.out.println(contact);

        save(contact);
    }

    void find() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));

            System.out.print("Enter the name search for: ");
            String searchName = in.nextLine();
            searchName = checkData.checkLine(searchName);

            System.out.println("Searching for " + searchName + " in file...");

            String line;
            boolean noMatches = true;
            while ((line = br.readLine()) != null) {
                int indexFound = line.indexOf(searchName.toLowerCase());

                if (indexFound > -1) {
                    System.out.println("\nContact was FOUND\n" + line + "\n");
                    noMatches = false;
                }
            }
            br.close(); // Закрываем доступ к файлу после того, как отработали с ним
            if (noMatches) {
                System.out.println("\nNO MATCH FOUND.\n");
            }
        } catch (Exception e) {
            System.out.println("Error! Contact list is empty.  At first you need to add contact in list. Try again.");
        }
    }

    void delete() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

            System.out.println("Enter the name to delete: ");
            String deleteName = in.nextLine();
            deleteName = checkData.checkLine(deleteName);

            String currentLine;
            boolean noMatches = true;
            while ((currentLine = br.readLine()) != null) {
                if (currentLine.indexOf(deleteName.toLowerCase()) > -1) {
                    noMatches = false;
                    continue;
                }
                bw.write(currentLine + System.getProperty("line.separator"));
            }
            br.close();
            bw.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
            if (!noMatches) System.out.println("\nContact " + deleteName + " has been deleted.");
            else System.out.println("\nNO MATCH FOUND.");

        } catch (Exception e) {
            System.out.println("Error! Contact list is empty. At first you need to add contact in list. Try again.");
        }
    }

    void read() {
        int counter = 0;
        String line;

        try {
            Scanner out = new Scanner(inputFile);
            //сортировка данных
            Set<String> lines = new TreeSet<>();
            while (out.hasNextLine()) {
                line = out.nextLine();
                lines.add(line);
                counter++;
            }
            // вывод отсортированной информации в консоль
            for (String fileLine : lines) {
                String outlook = fileLine.substring(0, 1).toUpperCase()
                        + fileLine.substring(1).toUpperCase();
                System.out.println(outlook);
            }
            out.close();

        } catch (FileNotFoundException e) {
        }
        System.out.println("\n" + counter + " contacts in records.");
    }

    void save(Contact contact) {
        try {
            if (!inputFile.exists())
                inputFile.createNewFile();

            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(inputFile, true));
                bw.write(contact + "\n");
                bw.flush();
                bw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Contact has been saved");
        } catch (Exception e) {
        }
    }
}
