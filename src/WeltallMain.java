package src;

import Objekte.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WeltallMain {
    private static Spaceknight spieler;
    private static List<Planet> planeten;
    private static Planet aktuellerPlanet;
    private static Scanner scanner;
    private static Random random;

    /**
     * Hauptmethode - Startet das Spiel
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args) {
        System.out.println("\n" +
                "███████╗██████╗  █████╗  ██████╗███████╗██╗  ██╗███╗   ██╗██╗ ██████╗ ██╗  ██╗████████╗\n" +
                "██╔════╝██╔══██╗██╔══██╗██╔════╝██╔════╝██║ ██╔╝████╗  ██║██║██╔════╝ ██║  ██║╚══██╔══╝\n" +
                "███████╗██████╔╝███████║██║     █████╗  █████╔╝ ██╔██╗ ██║██║██║  ███╗███████║   ██║   \n" +
                "╚════██║██╔═══╝ ██╔══██║██║     ██╔══╝  ██╔═██╗ ██║╚██╗██║██║██║   ██║██╔══██║   ██║   \n" +
                "███████║██║     ██║  ██║╚██████╗███████╗██║  ██╗██║ ╚████║██║╚██████╔╝██║  ██║   ██║   \n" +
                "╚══════╝╚═╝     ╚═╝  ╚═╝ ╚═════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝ ╚═════╝ ╚═╝  ╚═╝   ╚═╝   \n");
        
        System.out.println("Es war einmal vor langer Zeit in einer weit, weit entfernten Galaxis...");
        System.out.println("\nWillkommen im Weltraum-Abenteuer!");
        
        spielInitialisieren();
        spielSchleife();
    }

    private static void spielInitialisieren() {
        scanner = new Scanner(System.in);
        random = new Random();
        
        // Spieler erstellen
        System.out.print("\nGeben Sie den Namen Ihres Spaceknight ein: ");
        String name = scanner.nextLine();
        spieler = new Spaceknight(name, 15, 10, 5, 1, 0, 100);
        
        // Planeten initialisieren
        planetenInitialisieren();
        
        // Startet auf dem ersten Planeten
        aktuellerPlanet = planeten.get(0);
        aktuellerPlanet.planetErkunden(spieler);
        
        System.out.println("\nIhr Abenteuer beginnt auf dem Planeten " + aktuellerPlanet.getName() + "!");
    }

    private static void planetenInitialisieren() {
        planeten = new ArrayList<>();
        
        planeten.add(new Planet("Terra Nova", 
            "Ein friedlicher Erdähnlicher Planet mit grünen Wiesen und kristallklaren Seen. " +
            "Perfekt für Anfänger, um ihre ersten Kämpfe zu bestreiten.", 1));
        
        planeten.add(new Planet("Crimson Desert", 
            "Eine unwirtliche Wüstenwelt mit rotem Sand und glühenden Kristallformationen. " +
            "Die Hitze ist unerträglich und gefährliche Kreaturen lauern überall.", 2));
        
        planeten.add(new Planet("Nebula Station", 
            "Eine verlassene Raumstation in einem Nebel. Dunkle Gänge und mysteriöse " +
            "Energien machen diesen Ort zu einem wahren Alptraum.", 3));
        
        planeten.add(new Planet("Void Terminus", 
            "Der Rand der bekannten Galaxis. Hier herrschen die mächtigsten Kreaturen " +
            "des Universums. Nur die stärksten Krieger wagen sich hierher.", 4));
    }

    private static void spielSchleife() {
        boolean spielLaeuft = true;
        
        while (spielLaeuft && !spieler.istTot()) {
            hauptmenuAnzeigen();
            int auswahl = scanner.nextInt();
            
            switch (auswahl) {
                case 1:
                    kampfStarten();
                    break;
                case 2:
                    shopBesuchen();
                    break;
                case 3:
                    planetWechseln();
                    break;
                case 4:
                    spieler.statusAnzeigen();
                    break;
                case 5:
                    inventarAnzeigen();
                    break;
                case 6:
                    spieler.heilen();
                    break;
                case 7:
                    skillbaumOeffnen();
                    break;
                case 8:
                    spielLaeuft = false;
                    System.out.println("\nDanke fürs Spielen! Möge die Macht mit Ihnen sein!");
                    break;
                default:
                    System.out.println("Ungültige Auswahl!");
            }
        }
        
        if (spieler.istTot()) {
            System.out.println("\n💀 GAME OVER! 💀");
            System.out.println("Ihr tapferer Spaceknight " + spieler.getName() + " ist gefallen...");
            System.out.println("Aber Legenden sterben nie!");
        }
    }

    private static void hauptmenuAnzeigen() {
        System.out.println("\n==================================================\n");
        System.out.println("🌟 " + spieler.getName() + " auf " + aktuellerPlanet.getName() + " 🌟");
        System.out.println("💚 Leben: " + spieler.getLeben() + "/" + spieler.getMaxLeben() + 
                          " | 🎯 Level: " + spieler.getLevel() + 
                          " | 💰 Gold: " + spieler.getGold());
        System.out.println("\n==================================================");
        System.out.println("\n1. 🗡️  Kreatur bekämpfen");
        System.out.println("2. 🛒 Händler besuchen");
        System.out.println("3. 🚀 Planet wechseln");
        System.out.println("4. 📊 Status anzeigen");
        System.out.println("5. 🎒 Inventar anzeigen");
        System.out.println("6. ❤️  Heilen (" + (spieler.getLevel() * 20) + " Gold)");
        System.out.println("7. 🌟 Skillbaum öffnen" + (spieler.getTalentpunkte() > 0 ? " (" + spieler.getTalentpunkte() + " Punkte)" : ""));
        System.out.println("8. 🚪 Spiel beenden");
        System.out.print("\nWas möchten Sie tun? ");
    }

    private static void kampfStarten() {
        Kreatur gegner = aktuellerPlanet.zufaelligeKreatur();
        if (gegner == null) {
            System.out.println("Auf diesem Planeten gibt es keine Kreaturen mehr!");
            return;
        }
        
        System.out.println("\n⚔️ Ein wildes " + gegner.getName() + " erscheint!");
        System.out.println("Gegner: " + gegner.getName() + " (Level " + gegner.getLevel() + ", Leben: " + gegner.getLeben() + ")");
        
        // Kampfschleife
        while (!spieler.istTot() && gegner.getLeben() > 0) {
            System.out.println("\n--- Kampfrunde ---");
            System.out.println("Ihre Leben: " + spieler.getLeben() + "/" + spieler.getMaxLeben());
            System.out.println("Gegner Leben: " + gegner.getLeben());
            System.out.println("\n1. Angreifen");
            System.out.println("2. Fliehen");
            System.out.print("Was möchten Sie tun? ");
            
            int kampfAuswahl = scanner.nextInt();
            
            if (kampfAuswahl == 1) {
                // Spieler greift an
                spieler.angreifen(gegner);
                
                // Gegner greift zurück (falls noch am Leben)
                if (gegner.getLeben() > 0) {
                    gegner.angreifen(spieler);
                }
            } else if (kampfAuswahl == 2) {
                if (random.nextInt(100) < 50) { // 50% Chance zu entkommen
                    System.out.println("🏃 Flucht erfolgreich! Sie sind entkommen!");
                    return;
                } else {
                    System.out.println("💨 Flucht fehlgeschlagen! Das Monster verfolgt Sie!");
                    // Gegner greift an, wenn Flucht fehlschlägt
                    gegner.angreifen(spieler);
                }
            } else {
                System.out.println("Ungültige Auswahl!");
                continue;
            }
        }
        
        if (gegner.getLeben() <= 0) {
            kampfGewonnen(gegner);
        }
    }

    private static void kampfGewonnen(Kreatur besiegterGegner) {
        System.out.println("\n🎉 Sieg! Sie haben " + besiegterGegner.getName() + " besiegt!");
        
        // Belohnungen berechnen
        int erfahrung = besiegterGegner.getLevel() * 25 + random.nextInt(20);
        int gold = besiegterGegner.getLevel() * 15 + random.nextInt(30);
        
        spieler.erfahrungErhalten(erfahrung);
        spieler.goldErhalten(gold);
        
        // Chance auf seltene Belohnung
        if (random.nextInt(100) < 10) { // 10% Chance
            System.out.println("\n✨ Seltener Fund! Sie erhalten Bonus-Gold!");
            spieler.goldErhalten(50);
        }
    }

    private static void shopBesuchen() {
        System.out.println("\nSie besuchen den lokalen Händler...");
        aktuellerPlanet.getHaendler().shopOeffnen(spieler);
    }

    private static void planetWechseln() {
        System.out.println("\n🚀 Verfügbare Planeten:");
        for (int i = 0; i < planeten.size(); i++) {
            Planet planet = planeten.get(i);
            String status = planet.isEntdeckt() ? "[Entdeckt]" : "[Unentdeckt]";
            String aktuell = planet == aktuellerPlanet ? " <- Sie sind hier" : "";
            System.out.println((i + 1) + ". " + planet.getName() + " " + status + " (Schwierigkeit: " + 
                             planet.getSchwierigkeitsgrad() + "/4)" + aktuell);
        }
        
        System.out.print("\nZu welchem Planeten möchten Sie reisen? (0 für Abbruch): ");
        int auswahl = scanner.nextInt();
        
        if (auswahl > 0 && auswahl <= planeten.size()) {
            Planet neuerPlanet = planeten.get(auswahl - 1);
            if (neuerPlanet != aktuellerPlanet) {
                aktuellerPlanet = neuerPlanet;
                aktuellerPlanet.planetErkunden(spieler);
                System.out.println("Sie sind erfolgreich zu " + aktuellerPlanet.getName() + " gereist!");
            } else {
                System.out.println("Sie befinden sich bereits auf diesem Planeten!");
            }
        }
    }

    private static void inventarAnzeigen() {
        System.out.println("\n🎒 === INVENTAR ===");
        
        System.out.println("\n⚔️ Waffen:");
        if (spieler.getWaffenInventar().isEmpty()) {
            System.out.println("  Keine Waffen im Inventar");
        } else {
            for (int i = 0; i < spieler.getWaffenInventar().size(); i++) {
                Waffe waffe = spieler.getWaffenInventar().get(i);
                String angelegt = waffe == spieler.getAktuelleWaffe() ? " [ANGELEGT]" : "";
                System.out.println("  " + (i + 1) + ". " + waffe + angelegt);
            }
        }
        
        System.out.println("\n🛡️ Rüstungen:");
        if (spieler.getRuestungInventar().isEmpty()) {
            System.out.println("  Keine Rüstungen im Inventar");
        } else {
            for (int i = 0; i < spieler.getRuestungInventar().size(); i++) {
                Ruestung ruestung = spieler.getRuestungInventar().get(i);
                String angelegt = ruestung == spieler.getAktuelleRuestung() ? " [ANGELEGT]" : "";
                System.out.println("  " + (i + 1) + ". " + ruestung + angelegt);
            }
        }
        
        System.out.println("\n1. Waffe anlegen");
        System.out.println("2. Rüstung anlegen");
        System.out.println("3. Zurück zum Hauptmenü");
        System.out.print("\nWas möchten Sie tun? ");
        
        int auswahl = scanner.nextInt();
        
        switch (auswahl) {
            case 1:
                waffeAnlegen();
                break;
            case 2:
                ruestungAnlegen();
                break;
            case 3:
                return;
        }
    }

    private static void waffeAnlegen() {
        if (spieler.getWaffenInventar().isEmpty()) {
            System.out.println("Sie haben keine Waffen im Inventar!");
            return;
        }
        
        System.out.println("\nWelche Waffe möchten Sie anlegen?");
        for (int i = 0; i < spieler.getWaffenInventar().size(); i++) {
            System.out.println((i + 1) + ". " + spieler.getWaffenInventar().get(i));
        }
        System.out.print("\nAuswahl: ");
        
        int auswahl = scanner.nextInt();
        if (auswahl > 0 && auswahl <= spieler.getWaffenInventar().size()) {
            Waffe gewaehlteWaffe = spieler.getWaffenInventar().get(auswahl - 1);
            spieler.waffeAnlegen(gewaehlteWaffe);
        }
    }

    private static void ruestungAnlegen() {
        if (spieler.getRuestungInventar().isEmpty()) {
            System.out.println("Sie haben keine Rüstungen im Inventar!");
            return;
        }
        
        System.out.println("\nWelche Rüstung möchten Sie anlegen?");
        for (int i = 0; i < spieler.getRuestungInventar().size(); i++) {
            System.out.println((i + 1) + ". " + spieler.getRuestungInventar().get(i));
        }
        System.out.print("\nAuswahl: ");
        
        int auswahl = scanner.nextInt();
        if (auswahl > 0 && auswahl <= spieler.getRuestungInventar().size()) {
            Ruestung gewaehlteRuestung = spieler.getRuestungInventar().get(auswahl - 1);
            spieler.ruestungAnlegen(gewaehlteRuestung);
        }
    }

    private static void skillbaumOeffnen() {
        boolean imSkillbaum = true;
        
        while (imSkillbaum) {
            spieler.skillbaumAnzeigen();
            System.out.print("\nWas möchten Sie tun? ");
            
            int auswahl = scanner.nextInt();
            
            if (auswahl >= 1 && auswahl <= 3) {
                spieler.talentpunktVerwenden(auswahl);
            } else if (auswahl == 4) {
                imSkillbaum = false;
            } else {
                System.out.println("Ungültige Auswahl!");
            }
        }
    }
}
