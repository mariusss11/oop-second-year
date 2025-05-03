package org.example;

import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String word = scanner.nextLine();
        System.out.println("You entered: " + word);
        StringBuffer stringBuffer = new StringBuffer(word);

        String vocals = "aeiou";

        for (int i = 0; i < stringBuffer.length(); i++) {
            String vocalChar = String.valueOf(word.charAt(i));
            if (vocals.contains(vocalChar)) {
                stringBuffer.delete(i,i + 1);
                stringBuffer.insert(i, vocalChar.toUpperCase());
            }
        }

        System.out.println("The new string is: " + stringBuffer.toString());

    }
}
