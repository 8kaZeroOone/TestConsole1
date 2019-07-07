package com.ezo;

import java.util.Scanner;

public class CheckData {
    Scanner in = new Scanner(System.in);

    short checkAction(byte action) {
        if (action > 5 || action <= 0)
            action = -1;
        return action;
    }

    String checkLine (String line){
        while (line.length()==0){
            line = in.nextLine();
        }return line;
    }
}
