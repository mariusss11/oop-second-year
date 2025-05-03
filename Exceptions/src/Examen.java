class Examen {
    private String numeStudent;
    private double nota;
    private String materie;

    public Examen(String numeStudent, double nota, String materie) {
        this.numeStudent = numeStudent;
        this.materie = materie;
        setNota(nota);
    }

    public void setNota(double nouaNota) {
        if (nouaNota < 1 || nouaNota > 10) {
            throw new IllegalArgumentException("Nota trebuie sa fie intre 1 si 10.");
        }
        this.nota = nouaNota;
    }
}