class Fructe {
    private double pret;
    private String producator;

    // Constructor cu un parametru
    public Fructe(String producator) {
        this.pret = 10.0; // Pret prestabilit
        this.producator = producator;
    }

    // Constructor cu doi parametri
    public Fructe(double pret, String producator) {
        this.pret = pret;
        this.producator = producator;
    }

    @Override
    public String toString() {
        return "Fruct produs de " + producator + ", pret: " + pret + " lei";
    }

    public static void main(String[] args) {
        Fructe fruct1 = new Fructe("ProFruit");
        Fructe fruct2 = new Fructe(15.0, "MoldFruit");

        System.out.println(fruct1);
        System.out.println(fruct2);
    }

}
