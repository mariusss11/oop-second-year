import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Clasa de bază pentru vagoane
abstract class Vagon {
    protected int capacitateColete;

    public Vagon(int capacitateColete) {
        this.capacitateColete = capacitateColete;
    }

    public int getCapacitateColete() {
        return capacitateColete;
    }

    public abstract void descriere();
}

// Vagon de tip CalatoriA
class VagonCalatoriA extends Vagon {
    private int capacitatePasageri;

    public VagonCalatoriA() {
        super(300);
        this.capacitatePasageri = 40;
    }

    public void deschidereUsi() {
        System.out.println("Vagon CalatoriA - Ușile se deschid automat.");
    }

    public void inchidereUsi() {
        System.out.println("Vagon CalatoriA - Ușile se închid automat.");
    }

    @Override
    public void descriere() {
        System.out.println("Vagon CalatoriA cu " + capacitatePasageri + " pasageri și " + capacitateColete + " colete.");
    }
}

// Vagon de tip CalatoriB
class VagonCalatoriB extends VagonCalatoriA {
    public VagonCalatoriB() {
        super();
    }

    public void blocareGeamuri() {
        System.out.println("Vagon CalatoriB - Geamurile sunt blocate automat.");
    }

    @Override
    public void descriere() {
        System.out.println("Vagon CalatoriB cu capacitate îmbunătățită.");
    }
}

// Vagon de tip Marfa
class VagonMarfa extends Vagon {
    public VagonMarfa() {
        super(400);
    }

    @Override
    public void descriere() {
        System.out.println("Vagon Marfa cu " + capacitateColete + " colete.");
    }
}

// Clasa Tren
class Tren {
    private List<Vagon> vagoane;
    private static final int MAX_VAGOANE = 15;

    public Tren() {
        vagoane = new ArrayList<>();
    }

    public void adaugaVagon(Vagon vagon) {
        if (vagoane.size() < MAX_VAGOANE) {
            vagoane.add(vagon);
            System.out.println("Vagon adăugat.");
        } else {
            System.out.println("Trenul nu poate avea mai mult de " + MAX_VAGOANE + " vagoane.");
        }
    }

    public int getTotalColete() {
        return vagoane.stream().mapToInt(Vagon::getCapacitateColete).sum();
    }

    public void descriereTren() {
        System.out.println("Trenul conține următoarele vagoane:");
        for (Vagon v : vagoane) {
            v.descriere();
        }
    }

    // Comparare trenuri pe baza numarului de colete
    public boolean esteEgal(Tren altTren) {
        return this.getTotalColete() == altTren.getTotalColete();
    }
}

public class Main {
    public static void main(String[] args) {
        Tren tren1 = new Tren();
        tren1.adaugaVagon(new VagonCalatoriA());
        tren1.adaugaVagon(new VagonCalatoriB());
        tren1.adaugaVagon(new VagonMarfa());

        Tren tren2 = new Tren();
        tren2.adaugaVagon(new VagonMarfa());
        tren2.adaugaVagon(new VagonMarfa());

        tren1.descriereTren();
        tren2.descriereTren();

        if (tren1.esteEgal(tren2)) {
            System.out.println("Trenurile sunt egale ca număr de colete.");
        } else {
            System.out.println("Trenurile NU sunt egale ca număr de colete.");
        }
    }
}
