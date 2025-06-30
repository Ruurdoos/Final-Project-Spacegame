package Objekte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Haendler {
    private String name;
    private List<Waffe> waffenLager;
    private List<Ruestung> ruestungLager;

    public Haendler(String name) {
        this.name = name;
        this.waffenLager = new ArrayList<>();
        this.ruestungLager = new ArrayList<>();
        initialisiereLager();
    }

    private void initialisiereLager() {
        // Waffen hinzufügen
        waffenLager.add(new Waffe("Eisenschwert", 15, 2, true, 50, 1));
        waffenLager.add(new Waffe("Stahlschwert", 25, 3, true, 120, 3));
        waffenLager.add(new Waffe("Lichtschwert", 35, 5, true, 250, 5));
        waffenLager.add(new Waffe("Plasmablaster", 30, 1, true, 200, 4));
        waffenLager.add(new Waffe("Energielanze", 45, 8, false, 400, 7));

        // Rüstungen hinzufügen
        ruestungLager.add(new Ruestung("Lederrüstung", 10, 1, 40, 1));
        ruestungLager.add(new Ruestung("Kettenhemd", 18, 2, 80, 2));
        ruestungLager.add(new Ruestung("Plattenpanzer", 25, 4, 150, 4));
        ruestungLager.add(new Ruestung("Energieschild", 35, 6, 300, 6));
        ruestungLager.add(new Ruestung("Nano-Rüstung", 45, 8, 500, 8));
    }

    public void shopOeffnen(Spaceknight spieler) {
        Scanner scanner = new Scanner(System.in);
        boolean einkaufen = true;

        while (einkaufen) {
            System.out.println("\n=== Willkommen bei " + name + "s Ausrüstungsshop! ===");
            System.out.println("Ihr Gold: " + spieler.getGold());
            System.out.println("\n1. Waffen kaufen");
            System.out.println("2. Rüstungen kaufen");
            System.out.println("3. Shop verlassen");
            System.out.print("\nWas möchten Sie tun? ");

            int auswahl = scanner.nextInt();

            switch (auswahl) {
                case 1:
                    waffenShop(spieler, scanner);
                    break;
                case 2:
                    ruestungShop(spieler, scanner);
                    break;
                case 3:
                    einkaufen = false;
                    System.out.println("Auf Wiedersehen! Möge die Macht mit Ihnen sein!");
                    break;
                default:
                    System.out.println("Ungültige Auswahl!");
            }
        }
    }

    private void waffenShop(Spaceknight spieler, Scanner scanner) {
        System.out.println("\n=== Waffen-Shop ===");
        for (int i = 0; i < waffenLager.size(); i++) {
            Waffe waffe = waffenLager.get(i);
            System.out.println((i + 1) + ". " + waffe);
        }
        System.out.println("0. Zurück zum Hauptmenü");
        System.out.print("\nWelche Waffe möchten Sie kaufen? ");

        int auswahl = scanner.nextInt();
        if (auswahl > 0 && auswahl <= waffenLager.size()) {
            Waffe gewaehlteWaffe = waffenLager.get(auswahl - 1);
            waffeKaufen(spieler, gewaehlteWaffe);
        }
    }

    private void ruestungShop(Spaceknight spieler, Scanner scanner) {
        System.out.println("\n=== Rüstungs-Shop ===");
        for (int i = 0; i < ruestungLager.size(); i++) {
            Ruestung ruestung = ruestungLager.get(i);
            System.out.println((i + 1) + ". " + ruestung);
        }
        System.out.println("0. Zurück zum Hauptmenü");
        System.out.print("\nWelche Rüstung möchten Sie kaufen? ");

        int auswahl = scanner.nextInt();
        if (auswahl > 0 && auswahl <= ruestungLager.size()) {
            Ruestung gewaehlteRuestung = ruestungLager.get(auswahl - 1);
            ruestungKaufen(spieler, gewaehlteRuestung);
        }
    }

    private void waffeKaufen(Spaceknight spieler, Waffe waffe) {
        if (spieler.getGold() >= waffe.getPreis()) {
            if (spieler.getLevel() >= waffe.getMindestLevel()) {
                spieler.setGold(spieler.getGold() - waffe.getPreis());
                spieler.getWaffenInventar().add(waffe);
                System.out.println("Sie haben " + waffe.getName() + " für " + waffe.getPreis() + " Gold gekauft!");
                
                // Fragen ob die Waffe sofort angelegt werden soll
                Scanner scanner = new Scanner(System.in);
                System.out.print("Möchten Sie die Waffe sofort anlegen? (j/n): ");
                String antwort = scanner.nextLine();
                if (antwort.toLowerCase().equals("j")) {
                    spieler.waffeAnlegen(waffe);
                }
            } else {
                System.out.println("Ihr Level (" + spieler.getLevel() + ") ist zu niedrig für diese Waffe (benötigt Level " + waffe.getMindestLevel() + ")!");
            }
        } else {
            System.out.println("Sie haben nicht genug Gold! Benötigt: " + waffe.getPreis() + ", Vorhanden: " + spieler.getGold());
        }
    }

    private void ruestungKaufen(Spaceknight spieler, Ruestung ruestung) {
        if (spieler.getGold() >= ruestung.getPreis()) {
            if (spieler.getLevel() >= ruestung.getMindestLevel()) {
                spieler.setGold(spieler.getGold() - ruestung.getPreis());
                spieler.getRuestungInventar().add(ruestung);
                System.out.println("Sie haben " + ruestung.getName() + " für " + ruestung.getPreis() + " Gold gekauft!");
                
                // Fragen ob die Rüstung sofort angelegt werden soll
                Scanner scanner = new Scanner(System.in);
                System.out.print("Möchten Sie die Rüstung sofort anlegen? (j/n): ");
                String antwort = scanner.nextLine();
                if (antwort.toLowerCase().equals("j")) {
                    spieler.ruestungAnlegen(ruestung);
                }
            } else {
                System.out.println("Ihr Level (" + spieler.getLevel() + ") ist zu niedrig für diese Rüstung (benötigt Level " + ruestung.getMindestLevel() + ")!");
            }
        } else {
            System.out.println("Sie haben nicht genug Gold! Benötigt: " + ruestung.getPreis() + ", Vorhanden: " + spieler.getGold());
        }
    }

    public String getName() {
        return name;
    }
}
