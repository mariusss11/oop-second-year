package org.example;

import java.util.Scanner;

public class Calc {
    double raza;
    final double PI = 3.14;

    public double circlePerimeter(double raza){
        return 2 * PI * raza;
    }

    public double circleArea(double raza){
        return PI * Math.pow(raza, 2);
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Calc cerc = new Calc();
        System.out.print("Introduceti raza cercului: ");
        cerc.raza = read.nextDouble();
        System.out.println("Perimetrul cercului este: " + cerc.circlePerimeter(cerc.raza));
        System.out.println("Aria cercului este: " + cerc.circleArea(cerc.raza));

    }
}