package org.example;

import java.util.Scanner;

public class Ex3 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String word = scanner.nextLine();
        System.out.println("You entered: " + word);
        StringBuffer stringBuffer = new StringBuffer(word);

        stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
        stringBuffer.append(5);

        System.out.println("The changed string is: " + stringBuffer.toString());

//        System.out.println(stringBuffer.length());
//        m a r i u s
//        0 1 2 3 4 5
    }
}
