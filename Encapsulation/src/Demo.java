class Caine {
    private String nume;
    private double greutate;
    static int nrPicioare = 4;

    public Caine(String nume, double greutate) {
        this.nume = nume;
        this.greutate = greutate;
    }

    public void lucreaza(String actiune) {
        System.out.println(nume + " " + actiune);
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getGreutate() {
        return greutate;
    }

    public void setGreutate(double greutate) {
        this.greutate = greutate;
    }
}

class Cal {
    private String nume;
    private double inaltime;
    static int nrPicioare = 4;

    public Cal(String nume, double inaltime) {
        this.nume = nume;
        this.inaltime = inaltime;
    }

    public void lucreaza(String actiune) {
        System.out.println(nume + " " + actiune);
    }

    public String getNume() {
        return nume;
    }

    public double getInaltime() {
        return inaltime;
    }
}

public class Demo {
    public static void main(String[] args) {
        Caine gerry = new Caine("Gerry", 25.5);
        Cal black = new Cal("Black", 1.75);

        gerry.lucreaza("sare în sus");
        black.lucreaza("aleargă pe câmp");

        System.out.println("Câinele are " + Caine.nrPicioare + " picioare.");
        System.out.println("Calul are " + Cal.nrPicioare + " picioare.");
        System.out.println("Greutatea lui Gerry este: " + gerry.getGreutate());
        System.out.println("Înălțimea lui Black este: " + black.getInaltime());
    }
}
