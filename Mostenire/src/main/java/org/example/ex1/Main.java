package org.example.ex1;

public class Main {

    public static void main(String[] args) {

        Angajat angajat = new Angajat(
                "Stanislav", "Suhari", 13000, 17,
                "Adrian", "George", 21000, 34
        );

        System.out.println("Numele managerului: " + angajat.getNumeManager() + " " + angajat.getPrenumeManager());
        System.out.println("Salariul managerului: " + angajat.getSalariuManager());
        System.out.println("Varsta managerului: " + angajat.getVarstaManager());

    }
}
