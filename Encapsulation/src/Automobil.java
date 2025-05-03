class Automobil {
    private String denumire;
    private String compProd;
    private int nrPasageri;
    private int anProducere;
    private String culoare;
    private int nrUsi;
    private double rezervor;
    private double viteza;
    private String cutieDeViteza;
    private boolean aerConditionat;
    private double pret;

    // Constructor cu parametri minimi
    public Automobil(String denumire, String compProd, double pret) {
        this.denumire = denumire;
        this.compProd = compProd;
        this.pret = pret;
    }

    // Constructor complet
    public Automobil(String denumire, String compProd, int nrPasageri, int anProducere, String culoare, int nrUsi, double rezervor, double viteza, String cutieDeViteza, boolean aerConditionat, double pret) {
        this.denumire = denumire;
        this.compProd = compProd;
        this.nrPasageri = nrPasageri;
        this.anProducere = anProducere;
        this.culoare = culoare;
        this.nrUsi = nrUsi;
        this.rezervor = rezervor;
        this.viteza = viteza;
        this.cutieDeViteza = cutieDeViteza;
        this.aerConditionat = aerConditionat;
        this.pret = pret;
    }

    public void afiseaza() {
        System.out.println("Automobil: " + denumire + ", Companie: " + compProd + ", Pret: " + pret + " lei");
    }

    public static void main(String[] args) {
        Automobil auto1 = new Automobil("Dacia Logan", "Dacia", 5000);
        Automobil auto2 = new Automobil("BMW X5", "BMW", 5, 2022, "Negru", 4, 60, 250, "Automata", true, 60000);
        Automobil auto3 = new Automobil("Audi A4", "Audi", 4, 2020, "Alb", 4, 55, 230, "Automata", true, 40000);
        Automobil auto4 = new Automobil("Mercedes E-Class", "Mercedes", 5, 2023, "Gri", 4, 70, 260, "Automata", true, 80000);

        auto1.afiseaza();
        auto2.afiseaza();
        auto3.afiseaza();
        auto4.afiseaza();
    }
}