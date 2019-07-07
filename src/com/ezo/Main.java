package com.ezo;

import java.util.Scanner;

public class Main {
    private static final String welcomeMessage = "Hello! This is contact list manager! Choice action number from 1 to 5.";
    private static final String actionMenu = "1. Add new contact" + "\n"
            + "2. Show all contacts from the list" + "\n"
            + "3. Find contact using name" + "\n"
            + "4. Delete contact using name" + "\n"
            + "5. Exit" + "\n";

    public static void main(String[] args) {
        byte action = 0;

        System.out.println(welcomeMessage);
        while (action != 5) {
            System.out.println(actionMenu);
            CheckData checkIn = new CheckData();
            Scanner in = new Scanner(System.in);
            try {
                action = (byte) checkIn.checkAction(in.nextByte()); //получаем номер дейтсвия от пользователя
            }                                                       //и передаём его на проверку, где в случае,
            catch (Exception e){                                    //если это число не соответствует номеру задания
                action=-1;                                          //то пользователь видит ошибку и повторяет ввод
            }

            switch (action) {
                case -1:
                    System.out.println("Invalid action, choice again.");
                    break;
                case 1:
                    ContactListActions newContact = new ContactListActions();
                    newContact.addNew();
                    break;
                case 2:
                    ContactListActions read = new ContactListActions();
                    read.read();
                    break;
                case 3:
                    ContactListActions findContact = new ContactListActions();
                    findContact.find();
                    break;
                case 4:
                    ContactListActions deleteContact = new ContactListActions();
                    deleteContact.delete();
                    break;
                case 5:
                    System.out.println("Program closing...");
                    break;
            }
        }
    }
}
