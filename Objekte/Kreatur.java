package Objekte;

public class Kreatur {
    private String name;
    private int angriffswert;
    private int verteidigungswert;
    private int blockwert;
    private int level;
    private int leben;

    /**
     * Konstruktor für eine neue Kreatur
     * @param name Name der Kreatur
     * @param angriffswert Angriffswert der Kreatur
     * @param verteidigungswert Verteidigungswert der Kreatur
     * @param blockwert Blockwert der Kreatur
     * @param level Level der Kreatur
     * @param leben Lebenspunkte der Kreatur
     */
    public Kreatur(String name, int angriffswert, int verteidigungswert, int blockwert, int level, int leben) {
        this.name = name;
        this.angriffswert = angriffswert;
        this.verteidigungswert = verteidigungswert;
        this.blockwert = blockwert;
        this.level = level;
        this.leben = leben;
    }

    // Getter und Setter

    public String getName() {
        return name;
    }

    public int getAngriffswert() {
        return angriffswert;
    }

    public int getVerteidigungswert() {
        return verteidigungswert;
    }

    public int getBlockwert() {
        return blockwert;
    }

    public int getLevel() {
        return level;
    }

    public int getLeben() {
        return leben;
    }

    public void setLeben(int leben) {
        this.leben = leben;
    }

    // Methoden

    /**
     * Greift einen Spaceknight an und berechnet den Schaden
     * @param ziel Der anzugreifende Spaceknight
     */
    public void angreifen(Spaceknight ziel) {
        int schaden = this.angriffswert - ziel.getVerteidigungswert();
        if (schaden > 0) {
            ziel.setLeben(ziel.getLeben() - schaden);
            System.out.println(this.name + " greift " + ziel.getName() + " an und verursacht " + schaden + " Schaden.");
        } else {
            System.out.println(this.name + " kann " + ziel.getName() + " nicht verletzen.");
        }
    }

}
