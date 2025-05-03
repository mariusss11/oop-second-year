package org.example;

import java.util.Scanner;

public class Exchange {
    double suma;

    public double toEuro(double suma) {
        return suma * 19.43;
    }

    public double toDollars(double suma) {
        return suma * 18.65;
    }

    public double toLire(double suma) {
        return suma * 23.89;
    }

    public double toUHA(double suma) {
        return suma * 0.5;
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Exchange exchange = new Exchange();
        System.out.print("Introduceti suma pe care doriti sa o schimbati: ");
        exchange.suma = read.nextDouble();
        System.out.println("OPTIUNILE: ");
        System.out.println("1. Euro");
        System.out.println("2. Dolar american");
        System.out.println("3. Lira sterlina");
        System.out.println("4. Gruvna ucraineana");
        System.out.print("INTRODUCETI OPTIUNEA DORITA PENTRU SCHIMB DIN MDL: ");
        int option = read.nextInt();
        switch (option) {
            case 1:
                System.out.print(exchange.suma + " mdl vor fi " + exchange.toEuro(exchange.suma) + " euro.");
                break;
            case 2:
                System.out.print(exchange.suma + " mdl vor fi " + exchange.toDollars(exchange.suma) + " dolari americani.");
                break;
            case 3:
                System.out.print(exchange.suma + " mdl vor fi " + exchange.toLire(exchange.suma) + " lire sterline.");
                break;
            case 4:
                System.out.print(exchange.suma + " mdl vor fi " + exchange.toUHA(exchange.suma) + " grivne ucrainene.");
                break;
        }
    }
}
