package org.example;

import java.util.Scanner;

abstract class Figura {
    abstract double Arie();
    abstract double Perimetrul();
}

class Cerc extends Figura {
    int raza;
    public double Arie(){
        return Math.PI * Math.pow(raza, 2);
    }

    public double Perimetrul() {
        return 2*Math.PI*raza;
    }

    public Cerc (int raza) {
        this.raza = raza;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.print("Introduceti raza cercului: ");
        int r = read.nextInt();

        Cerc cerc = new Cerc(r);

        System.out.println("Aria cercului este: " + cerc.Arie());
        System.out.println("Perimetrul cercului este: " + cerc.Perimetrul());
    }
}