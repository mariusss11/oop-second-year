
interface Cub {
    public void afisare();
    public void diagonala();
    public void volum();
}

class CubImplementat implements Cub {
    private int lungimeaLaturii;

    public CubImplementat(int lungimeaLaturii) {
        this.lungimeaLaturii = lungimeaLaturii;
    }

    @Override
    public void afisare() {
        System.out.println("Cub cu lungimea de " + lungimeaLaturii);
    }

    @Override
    public void diagonala() {
        double diagonala = lungimeaLaturii * Math.sqrt(3);
        System.out.println("Diagonala: " + diagonala);
    }

    @Override
    public void volum() {
        double volumul = Math.pow(lungimeaLaturii,3);
        System.out.println("Volumul: " + volumul);
    }
}


public class Main {
    public static void main(String[] args) {

        CubImplementat cub1 = new CubImplementat(5);
        cub1.afisare();
        cub1.diagonala();
        cub1.volum();



    }
}