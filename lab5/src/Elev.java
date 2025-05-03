
public class Elev {
    String name;
    String prenume;
    double notaMedie;

    public Elev(String name, String prenume, double notaMedie) {
        this.name = name;
        this.prenume = prenume;

        if (notaMedie <= 0 || notaMedie > 10)
            throw new ArithmeticException();
        else this.notaMedie = notaMedie;
    }

    public double getNotaMedie() {
        return notaMedie;
    }

    public void setNotaMedie(double notaMedie) {
        this.notaMedie = notaMedie;
    }

    public static void main(String[] args) {
        Elev elev = null;
        try {
            elev = new Elev("Marius", "Carchilan", 9);
        } catch (ArithmeticException exception) {
            System.out.println("Nota medie nu este valida");
        }
    }
}
