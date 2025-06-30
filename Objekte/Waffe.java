package Objekte;

public class Waffe {
    private String name;
    private int angriffswert;
    private int blockwert;
    private boolean einhandig;
    private int preis;
    private int mindestLevel;

    public Waffe(String name, int angriffswert, int blockwert, boolean einhandig, int preis, int mindestLevel) {
        this.name = name;
        this.angriffswert = angriffswert;
        this.blockwert = blockwert;
        this.einhandig = einhandig;
        this.preis = preis;
        this.mindestLevel = mindestLevel;
    }

    // Getter und Setter
    public String getName() {
        return name;
    }


    public int getAngriffswert() {
        return angriffswert;
    }

    public int getPreis() {
        return preis;
    }

    public int getMindestLevel() {
        return mindestLevel;
    }

    @Override
    public String toString() {
        return name + " (Angriff: " + angriffswert + ", Block: " + blockwert + ", Preis: " + preis + " Gold, Min-Level: " + mindestLevel + ")";
    }
}
