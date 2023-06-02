package Model;

public class materii {
    private String nume;
    private int credite;

    public materii(String nume, int credite) {
        this.nume = nume;
        this.credite = credite;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getCredite() {
        return credite;
    }

    public void setCredite(int credite) {
        this.credite = credite;
    }

    public String display() {
        return this.nume + " " + Integer.toString(this.credite) + "\n";
    }
}
