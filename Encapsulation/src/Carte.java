class Carte {
    private String denumire;
    private String autorPrincipal;
    private String alDoileaAutor;
    private int numarPagini;
    private double pret;

    public Carte(String denumire, String autorPrincipal, double pret) {
        this.denumire = denumire;
        this.autorPrincipal = autorPrincipal;
        this.pret = pret;
    }

    public Carte(String denumire, String autorPrincipal, String alDoileaAutor, int numarPagini, double pret) {
        this.denumire = denumire;
        this.autorPrincipal = autorPrincipal;
        this.alDoileaAutor = alDoileaAutor;
        this.numarPagini = numarPagini;
        this.pret = pret;
    }

    public void afiseaza() {
        System.out.println("Carte: " + denumire + " de " + autorPrincipal + " si " + alDoileaAutor + ", Pret: " + pret + " lei");
    }

    public double getPret() {
        return pret;
    }

    public static void main(String[] args) {
        Carte carte1 = new Carte("Java Programming", "John Doe", "Jane Smith", 500, 150);
        Carte carte2 = new Carte("Data Science", "Alice Brown", 200);
        Carte carte3 = new Carte("Machine Learning", "Bob White", "Sarah Green", 700, 250);

        carte1.afiseaza();
        carte2.afiseaza();
        carte3.afiseaza();

        Carte ceaMaiScumpa = carte1.getPret() > carte2.getPret() ? (carte1.getPret() > carte3.getPret() ? carte1 : carte3) : (carte2.getPret() > carte3.getPret() ? carte2 : carte3);

        System.out.println("Cea mai scumpa carte este:");
        ceaMaiScumpa.afiseaza();
    }
}
