package org.example.ex1;

public class Angajat extends Manager{

    String nume, prenume;
    private int salariu, IDNP;

    public Angajat(
            String nume, String prenume, int salariu, int IDNP,
            String numeManager, String prenumeManager, int salariuManager, int varstaManager
    ) {
        super(numeManager, prenumeManager, salariuManager, varstaManager);
        this.nume = nume;
        this.prenume = prenume;
        this.salariu = salariu;
        this.IDNP = IDNP;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    public int getIDNP() {
        return IDNP;
    }

    public void setIDNP(int IDNP) {
        this.IDNP = IDNP;
    }
}
