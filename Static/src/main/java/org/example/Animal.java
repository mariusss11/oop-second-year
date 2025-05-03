package org.example;

class Animal {
    private String nume;
    private String specie;

    private static int numarAnimale = 0;

    // Constructor
    public Animal(String nume, String specie) {
        this.nume = nume;
        this.specie = specie;
        numarAnimale++;
    }

    public static void afiseazaNumarAnimale() {
        System.out.println("Numărul total de animale din adăpost: " + numarAnimale);
    }

    public String getNume() {
        return nume;
    }

    public String getSpecie() {
        return specie;
    }

    public static void main(String[] args) {
        // Crearea de obiecte
        Animal animal1 = new Animal("Mia", "Pisică");



        Animal animal2 = new Animal("Max", "Câine");
        Animal animal3 = new Animal("Rex", "Câine");


        // Afișarea numărului total de animale
        Animal.afiseazaNumarAnimale(); // Apelarea metodei statice
    }
}
