package Objekte;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Planet {
    private String name;
    private String beschreibung;
    private int schwierigkeitsgrad;
    private List<Kreatur> kreaturen;
    private Haendler haendler;
    private boolean entdeckt;

/**
 * Konstruktor für einen neuen Planeten
 * @param name Name des Planeten
 * @param beschreibung Beschreibung des Planeten
 * @param schwierigkeitsgrad Schwierigkeitsgrad von 1-4
 */
public Planet(String name, String beschreibung, int schwierigkeitsgrad) {
        this.name = name;
        this.beschreibung = beschreibung;
        this.schwierigkeitsgrad = schwierigkeitsgrad;
        this.kreaturen = new ArrayList<>();
        this.entdeckt = false;
        initialisiereKreaturen();
        initialisiereHaendler();
    }

    /**
     * Initialisiert die Kreaturen basierend auf dem Schwierigkeitsgrad
     */
    private void initialisiereKreaturen() {
        Random random = new Random();
        
        // Basierend auf Schwierigkeitsgrad verschiedene Kreaturen hinzufügen
        switch (schwierigkeitsgrad) {
            case 1: // Einfacher Planet
                kreaturen.add(new Kreatur("Weltraum-Ratte", 8, 3, 1, 1, 25));
                kreaturen.add(new Kreatur("Kristall-Käfer", 12, 5, 2, 1, 35));
                kreaturen.add(new Kreatur("Energie-Slime", 10, 4, 1, 1, 30));
                break;
            case 2: // Mittlerer Planet
                kreaturen.add(new Kreatur("Plasma-Wolf", 18, 8, 3, 2, 50));
                kreaturen.add(new Kreatur("Cyber-Spinne", 15, 10, 4, 2, 45));
                kreaturen.add(new Kreatur("Quantengeist", 20, 6, 2, 2, 40));
                break;
            case 3: // Schwerer Planet
                kreaturen.add(new Kreatur("Titan-Wächter", 25, 15, 5, 3, 80));
                kreaturen.add(new Kreatur("Void-Jäger", 30, 12, 6, 3, 70));
                kreaturen.add(new Kreatur("Astral-Drache", 35, 18, 8, 3, 100));
                break;
            case 4: // Sehr schwerer Planet
                kreaturen.add(new Kreatur("Galaxien-Bestie", 40, 20, 10, 4, 120));
                kreaturen.add(new Kreatur("Schwarzloch-Dämon", 45, 25, 12, 4, 150));
                kreaturen.add(new Kreatur("Kosmischer Titan", 50, 30, 15, 4, 180));
                break;
            default:
                kreaturen.add(new Kreatur("Unbekannte Kreatur", 20, 10, 5, 2, 60));
        }
    }

    /**
     * Initialisiert einen zufälligen Händler für diesen Planeten
     */
    private void initialisiereHaendler() {
        String[] haendlerNamen = {"Zephyr", "Quantum-Joe", "Stella", "Cosmic-Carl", "Nova-Nora"};
        Random random = new Random();
        String haendlerName = haendlerNamen[random.nextInt(haendlerNamen.length)];
        this.haendler = new Haendler(haendlerName);
    }

    /**
     * Wählt eine zufällige Kreatur für den Kampf aus
     * @return Eine Kopie einer zufälligen Kreatur oder null wenn keine vorhanden
     */
    public Kreatur zufaelligeKreatur() {
        if (kreaturen.isEmpty()) {
            return null;
        }
        Random random = new Random();
        Kreatur originalKreatur = kreaturen.get(random.nextInt(kreaturen.size()));
        
        // Erstelle eine Kopie der Kreatur für den Kampf
        return new Kreatur(
            originalKreatur.getName(),
            originalKreatur.getAngriffswert(),
            originalKreatur.getVerteidigungswert(),
            originalKreatur.getBlockwert(),
            originalKreatur.getLevel(),
            originalKreatur.getLeben()
        );
    }

    /**
     * Erkundet den Planeten und markiert ihn als entdeckt
     * @param spieler Der Spaceknight der den Planeten erkundet
     */
    public void planetErkunden(Spaceknight spieler) {
        if (!entdeckt) {
            entdeckt = true;
            System.out.println("\n*** NEUER PLANET ENTDECKT! ***");
            System.out.println("Sie haben " + name + " entdeckt!");
            spieler.erfahrungErhalten(50);
        }
        
        System.out.println("\n=== " + name + " ===");
        System.out.println(beschreibung);
        System.out.println("Schwierigkeitsgrad: " + schwierigkeitsgrad + "/4");
        System.out.println();
    }

    // Getter und Setter
    public String getName() {
        return name;
    }

    public int getSchwierigkeitsgrad() {
        return schwierigkeitsgrad;
    }

    public Haendler getHaendler() {
        return haendler;
    }

    public boolean isEntdeckt() {
        return entdeckt;
    }

}
