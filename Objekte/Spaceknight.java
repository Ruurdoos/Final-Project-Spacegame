package Objekte;

import java.util.ArrayList;
import java.util.List;

public class Spaceknight {
    private String name;
    private int angriffswert;
    private int verteidigungswert;
    private int blockwert;
    private int level;
    private int erfahrungspunkte;
    private int leben;
    private int maxLeben;
    private int gold;
    private Waffe aktuelleWaffe;
    private Ruestung aktuelleRuestung;
    private List<Waffe> waffenInventar;
    private List<Ruestung> ruestungInventar;
    private int talentpunkte;
    private int bonusAngriff;
    private int bonusVerteidigung;
    private int bonusLeben;

/**
 * Konstruktor für einen neuen Spaceknight
 * @param name Name des Spaceknight
 * @param angriffswert Basis-Angriffswert
 * @param verteidigungswert Basis-Verteidigungswert
 * @param blockwert Blockwert für Verteidigung
 * @param level Startlevel
 * @param erfahrungspunkte Starterfahrung
 * @param leben Startlebenspunkte
 */
public Spaceknight (String name, int angriffswert, int verteidigungswert, int blockwert, int level, int erfahrungspunkte, int leben) {
        this.name = name;
        this.angriffswert = angriffswert;
        this.verteidigungswert = verteidigungswert;
        this.blockwert = blockwert;
        this.level = level;
        this.erfahrungspunkte = erfahrungspunkte;
        this.leben = leben;
        this.maxLeben = leben;
        this.gold = 100; // Startgold
        this.waffenInventar = new ArrayList<>();
        this.ruestungInventar = new ArrayList<>();
        this.talentpunkte = 0;
        this.bonusAngriff = 0;
        this.bonusVerteidigung = 0;
        this.bonusLeben = 0;
    }


    // Getter und Setter

    public String getName() {
        return name;
    }

    public int getVerteidigungswert() {
        return verteidigungswert;
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

    public int getMaxLeben() {
        return maxLeben;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Waffe getAktuelleWaffe() {
        return aktuelleWaffe;
    }

    public Ruestung getAktuelleRuestung() {
        return aktuelleRuestung;
    }

    public List<Waffe> getWaffenInventar() {
        return waffenInventar;
    }

    public List<Ruestung> getRuestungInventar() {
        return ruestungInventar;
    }

    // Methoden

    /**
     * Greift eine Kreatur an und berechnet den Schaden
     * @param ziel Die anzugreifende Kreatur
     */
    public void angreifen(Kreatur ziel) {
        int gesamtAngriff = this.angriffswert + (aktuelleWaffe != null ? aktuelleWaffe.getAngriffswert() : 0);
        int schaden = gesamtAngriff - ziel.getVerteidigungswert();
        if (schaden > 0) {
            ziel.setLeben(ziel.getLeben() - schaden);
            System.out.println(this.name + " greift " + ziel.getName() + " an und verursacht " + schaden + " Schaden.");
        } else {
            System.out.println(this.name + " kann " + ziel.getName() + " nicht verletzen.");
        }
    }

    /**
     * Berechnet den Gesamtangriffswert (Basis + Bonus + Waffe)
     * @return Gesamtangriffswert
     */
    public int getGesamtAngriffswert() {
        return angriffswert + bonusAngriff + (aktuelleWaffe != null ? aktuelleWaffe.getAngriffswert() : 0);
    }

    /**
     * Berechnet den Gesamtverteidigungswert (Basis + Bonus + Rüstung)
     * @return Gesamtverteidigungswert
     */
    public int getGesamtVerteidigungswert() {
        return verteidigungswert + bonusVerteidigung + (aktuelleRuestung != null ? aktuelleRuestung.getVerteidigungswert() : 0);
    }

    public int getTalentpunkte() {
        return talentpunkte;
    }

    public int getBonusAngriff() {
        return bonusAngriff;
    }

    public int getBonusVerteidigung() {
        return bonusVerteidigung;
    }

    public int getBonusLeben() {
        return bonusLeben;
    }

    /**
     * Legt eine Waffe an, wenn das Level ausreicht
     * @param waffe Die anzulegende Waffe
     */
    public void waffeAnlegen(Waffe waffe) {
        if (waffe.getMindestLevel() <= this.level) {
            this.aktuelleWaffe = waffe;
            System.out.println("Waffe " + waffe.getName() + " angelegt.");
        } else {
            System.out.println("Ihr Level ist zu niedrig für diese Waffe!");
        }
    }

    /**
     * Legt eine Rüstung an, wenn das Level ausreicht
     * @param ruestung Die anzulegende Rüstung
     */
    public void ruestungAnlegen(Ruestung ruestung) {
        if (ruestung.getMindestLevel() <= this.level) {
            this.aktuelleRuestung = ruestung;
            System.out.println("Rüstung " + ruestung.getName() + " angelegt.");
        } else {
            System.out.println("Ihr Level ist zu niedrig für diese Rüstung!");
        }
    }

    /**
     * Fügt Erfahrungspunkte hinzu und prüft Level-Up
     * @param erfahrung Die zu erhaltende Erfahrung
     */
    public void erfahrungErhalten(int erfahrung) {
        this.erfahrungspunkte += erfahrung;
        System.out.println("Sie erhalten " + erfahrung + " Erfahrungspunkte!");
        levelPruefen();
    }

    /**
     * Fügt Gold zum Inventar hinzu
     * @param goldMenge Die zu erhaltende Goldmenge
     */
    public void goldErhalten(int goldMenge) {
        this.gold += goldMenge;
        System.out.println("Sie erhalten " + goldMenge + " Gold!");
    }

    /**
     * Prüft ob ein Level-Up möglich ist und führt ihn durch
     */
    private void levelPruefen() {
        int erfahrungFuerNaechstesLevel = level * 100;
        if (erfahrungspunkte >= erfahrungFuerNaechstesLevel) {
            level++;
            erfahrungspunkte -= erfahrungFuerNaechstesLevel;
            angriffswert += 2; // Reduzierte Basis-Steigerung
            verteidigungswert += 1;
            blockwert += 1;
            maxLeben += 10;
            leben = maxLeben; // Vollständige Heilung bei Level-Up
            talentpunkte += 1; // Einen Talentpunkt pro Level
            System.out.println("\n*** LEVEL UP! ***");
            System.out.println("Sie sind jetzt Level " + level + "!");
            System.out.println("Ihre Werte wurden verbessert und Sie sind vollständig geheilt!");
            System.out.println("Sie haben 1 Talentpunkt erhalten! Verwenden Sie ihn im Skillbaum.");
        }
    }

    /**
     * Heilt den Spaceknight gegen Gold vollständig
     * @return true wenn Heilung erfolgreich, false wenn nicht genug Gold
     */
    public boolean heilen() {
        int heilungskosten = level * 20; // Kosten steigen mit Level
        if (gold >= heilungskosten) {
            gold -= heilungskosten;
            this.leben = this.maxLeben;
            System.out.println("Sie sind vollständig geheilt! Kosten: " + heilungskosten + " Gold");
            return true;
        } else {
            System.out.println("Nicht genug Gold für Heilung! Benötigt: " + heilungskosten + " Gold, Sie haben: " + gold + " Gold");
            return false;
        }
    }

    /**
     * Zeigt das Skillbaum-Menü mit verfügbaren Optionen an
     */
    public void skillbaumAnzeigen() {
        System.out.println("\n=== 🌟 SKILLBAUM 🌟 ===");
        System.out.println("Verfügbare Talentpunkte: " + talentpunkte);
        System.out.println("\n1. 🗡️  Angriff erhöhen (+3 Angriff) - Aktuelle Boni: +" + bonusAngriff);
        System.out.println("2. 🛡️  Verteidigung erhöhen (+2 Verteidigung) - Aktuelle Boni: +" + bonusVerteidigung);
        System.out.println("3. ❤️  Leben erhöhen (+15 Max-Leben) - Aktuelle Boni: +" + bonusLeben);
        System.out.println("4. 🔙 Zurück zum Hauptmenü");
    }

    /**
     * Verwendet einen Talentpunkt für eine gewählte Verbesserung
     * @param auswahl Die gewählte Verbesserung (1=Angriff, 2=Verteidigung, 3=Leben)
     * @return true wenn erfolgreich, false wenn keine Punkte oder ungültige Auswahl
     */
    public boolean talentpunktVerwenden(int auswahl) {
        if (talentpunkte <= 0) {
            System.out.println("Sie haben keine Talentpunkte!");
            return false;
        }

        switch (auswahl) {
            case 1: // Angriff
                bonusAngriff += 3;
                talentpunkte--;
                System.out.println("Angriff um 3 erhöht! Neuer Bonus-Angriff: +" + bonusAngriff);
                return true;
            case 2: // Verteidigung
                bonusVerteidigung += 2;
                talentpunkte--;
                System.out.println("Verteidigung um 2 erhöht! Neue Bonus-Verteidigung: +" + bonusVerteidigung);
                return true;
            case 3: // Leben
                bonusLeben += 15;
                maxLeben += 15;
                leben += 15; // Aktuelles Leben auch erhöhen
                talentpunkte--;
                System.out.println("Max-Leben um 15 erhöht! Neues Bonus-Leben: +" + bonusLeben);
                return true;
            default:
                System.out.println("Ungültige Auswahl!");
                return false;
        }
    }

    /**
     * Prüft ob der Spaceknight tot ist
     * @return true wenn Leben <= 0, sonst false
     */
    public boolean istTot() {
        return leben <= 0;
    }

    /**
     * Zeigt den aktuellen Status des Spaceknight an
     */
    public void statusAnzeigen() {
        System.out.println("\n=== " + name + " - Status ===");
        System.out.println("Level: " + level);
        System.out.println("Leben: " + leben + "/" + maxLeben);
        System.out.println("Erfahrung: " + erfahrungspunkte + "/" + (level * 100));
        System.out.println("Gold: " + gold);
        System.out.println("Angriff: " + getGesamtAngriffswert() + " (" + angriffswert + " + " + (aktuelleWaffe != null ? aktuelleWaffe.getAngriffswert() : 0) + ")");
        System.out.println("Verteidigung: " + getGesamtVerteidigungswert() + " (" + verteidigungswert + " + " + (aktuelleRuestung != null ? aktuelleRuestung.getVerteidigungswert() : 0) + ")");
        System.out.println("Block: " + blockwert);
        System.out.println("Waffe: " + (aktuelleWaffe != null ? aktuelleWaffe.getName() : "Keine"));
        System.out.println("Rüstung: " + (aktuelleRuestung != null ? aktuelleRuestung.getName() : "Keine"));
        System.out.println();
    }

}
