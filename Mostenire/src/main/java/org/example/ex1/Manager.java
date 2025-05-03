package org.example.ex1;

public class Manager {

    String nume, prenume;
    int salariu, varsta;

    public Manager(String nume, String prenume, int salariu, int varsta) {
        this.nume = nume;
        this.prenume = prenume;
        this.salariu = salariu;
        this.varsta = varsta;
    }

    public String getNumeManager() {
        return nume;
    }

    public void setNumeManager(String nume) {
        this.nume = nume;
    }

    public String getPrenumeManager() {
        return prenume;
    }

    public void setPrenumeManager(String prenume) {
        this.prenume = prenume;
    }

    public int getSalariuManager() {
        return salariu;
    }

    public void setSalariuManager(int salariu) {
        this.salariu = salariu;
    }

    public int getVarstaManager() {
        return varsta;
    }

    public void setVarstaManager(int varsta) {
        this.varsta = varsta;
    }
}
