package org.example;

import java.util.Scanner;

public class Ex4 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String word = scanner.nextLine().toLowerCase();
        System.out.println("You entered: " + word);

       String searchedChar = "i";
       String vocalsWithoutI = "aeou";


        if (word.contains(searchedChar) && (!vocalsWithoutI.contains(word)) ) {
            System.out.println("DA");
        } else
            System.out.println("NU");

    }
}
