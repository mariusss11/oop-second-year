package org.example;

import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        System.out.println("You entered: " + word);

        String vocals = "aeiouAEIOU";
        int numOfVocals = 0;

        for (int i = 1; i < word.length() - 1; i++) {

            String left = String.valueOf(word.charAt(i - 1));
            String current = String.valueOf(word.charAt(i));
            String right = String.valueOf(word.charAt(i + 1));

            System.out.println(vocals.contains(left));
            System.out.println(vocals.contains(current));
            System.out.println(vocals.contains(right));

            if (!vocals.contains(left) && !vocals.contains(right) && vocals.contains(current)) {
                numOfVocals++;
            }
        }

        System.out.println("There are: " + numOfVocals);


    }
}
