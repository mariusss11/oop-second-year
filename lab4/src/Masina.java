class Masina {
    private double kmLaPlecare;
    private double kmLaSosire;
    private double litri;

    public Masina(double kmStart, double kmStop, double litri) {
        this.kmLaPlecare = kmStart;
        this.kmLaSosire = kmStop;
        this.litri = litri;
    }

    public double consum() {
        return (kmLaSosire - kmLaPlecare) / litri;
    }

    public static void main(String[] args) {
        // Creăm un obiect de tip Masina
        Masina masina = new Masina(10000, 10200, 10);

        // Calculăm și afișăm consumul
        System.out.println("Consumul este: " + masina.consum() + " km/l");
    }
}
