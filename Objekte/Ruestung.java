package Objekte;

public class Ruestung {
    private String name;
    private int verteidigungswert;
    private int blockwert;
    private int preis;
    private int mindestLevel;

    public Ruestung(String name, int verteidigungswert, int blockwert, int preis, int mindestLevel) {
        this.name = name;
        this.verteidigungswert = verteidigungswert;
        this.blockwert = blockwert;
        this.preis = preis;
        this.mindestLevel = mindestLevel;
    }

    // Getter und Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVerteidigungswert() {
        return verteidigungswert;
    }

    public void setVerteidigungswert(int verteidigungswert) {
        this.verteidigungswert = verteidigungswert;
    }

    public int getBlockwert() {
        return blockwert;
    }

    public void setBlockwert(int blockwert) {
        this.blockwert = blockwert;
    }

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public int getMindestLevel() {
        return mindestLevel;
    }

    public void setMindestLevel(int mindestLevel) {
        this.mindestLevel = mindestLevel;
    }

    @Override
    public String toString() {
        return name + " (Verteidigung: " + verteidigungswert + ", Block: " + blockwert + ", Preis: " + preis + " Gold, Min-Level: " + mindestLevel + ")";
    }
}
