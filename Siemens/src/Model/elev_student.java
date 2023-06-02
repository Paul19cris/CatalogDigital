package Model;

public class elev_student {
    private String nume;
    private String materie;
    private int nota;
    
    public elev_student(String nume, String materie, int nota) {
        this.nume = nume;
        this.materie = materie;
        this.nota = nota;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getMaterie() {
        return materie;
    }

    public void setMaterie(String materie) {
        this.materie = materie;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String display() {
        return this.nume + " " + this.materie + " " + Integer.toString(this.nota) + "\n";
    }
}
