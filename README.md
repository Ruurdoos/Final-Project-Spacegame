# 🚀 SPACEKNIGHT - Weltraum-Abenteuer

Ein objektorientiertes Command-Line RPG in Java, in dem Sie als Spaceknight durch die Galaxis reisen, Kreaturen bekämpfen, Items sammeln und Ihr Level steigern!

## 🎮 Features

### ⚔️ Kampfsystem
- Rundenbasierte Kämpfe gegen verschiedene Kreaturen
- Angriffs-, Verteidigungs- und Blockwerte
- Automatische Schadenberechnung basierend auf Ausrüstung

### 📈 Levelsystem
- Erfahrungspunkte sammeln durch Kämpfe
- Automatisches Level-Up mit Statusverbesserungen
- Vollständige Heilung bei jedem Level-Up

### 💰 Wirtschaftssystem
- Gold sammeln durch besiegte Gegner
- Händler auf jedem Planeten
- Kaufen von Waffen und Rüstungen

### 🎒 Inventarsystem
- Waffen und Rüstungen sammeln
- Equipment anlegen und wechseln
- Mindest-Level-Anforderungen für Items

### 🌍 Planetensystem
- 4 verschiedene Planeten mit aufsteigender Schwierigkeit
- Einzigartige Kreaturen auf jedem Planeten
- Planetenerkundung mit Erfahrungsbelohnungen

## 🏗️ Objektstruktur

### Klassen:
- **Spaceknight**: Hauptcharakter mit allen Spielereigenschaften
- **Kreatur**: Gegner mit verschiedenen Stärken
- **Waffe**: Angriffswerte und Eigenschaften
- **Ruestung**: Verteidigungswerte und Eigenschaften  
- **Haendler**: Shop-System für Items
- **Planet**: Spielwelten mit Kreaturen und Händlern
- **WeltallMain**: Hauptspielschleife und Menüsystem

## 🎯 Planeten

1. **Terra Nova** (Level 1)
   - Friedlicher Erdähnlicher Planet
   - Weltraum-Ratten, Kristall-Käfer, Energie-Slimes

2. **Crimson Desert** (Level 2)
   - Unwirtliche Wüstenwelt
   - Plasma-Wölfe, Cyber-Spinnen, Quantengeister

3. **Nebula Station** (Level 3)
   - Verlassene Raumstation
   - Titan-Wächter, Void-Jäger, Astral-Drachen

4. **Void Terminus** (Level 4)
   - Rand der Galaxis
   - Galaxien-Bestien, Schwarzloch-Dämonen, Kosmische Titanen

## 🚀 Ausführung

```bash
# Kompilieren
javac -d . src/WeltallMain.java Objekte/*.java

# Ausführen
java src.WeltallMain
```

## 🎮 Spielanleitung

1. **Charakter erstellen**: Geben Sie einen Namen für Ihren Spaceknight ein
2. **Hauptmenü navigieren**: Wählen Sie aus verschiedenen Aktionen
3. **Kämpfen**: Bekämpfen Sie Kreaturen für Erfahrung und Gold
4. **Einkaufen**: Besuchen Sie Händler für bessere Ausrüstung
5. **Erkunden**: Reisen Sie zu neuen Planeten
6. **Verwalten**: Überprüfen Sie Status und Inventar

## 🛡️ Gameplay-Tipps

- Beginnen Sie auf Terra Nova, um Erfahrung zu sammeln
- Kaufen Sie bessere Ausrüstung, bevor Sie zu schwierigeren Planeten reisen
- Nutzen Sie die kostenlose Heilung zwischen den Kämpfen
- Sammeln Sie genug Gold für High-Level Equipment
- Erkunden Sie neue Planeten für Erfahrungsbonus

## 🎲 Spielmechaniken

### Kampf
- Schaden = Angriffswert - Verteidigungswert des Ziels
- Waffen und Rüstungen addieren zu Basis-Stats
- Kreaturen greifen nach dem Spieler an

### Level-Up
- Benötigte Erfahrung = Aktuelles Level × 100
- +5 Angriff, +3 Verteidigung, +2 Block, +20 max. Leben
- Vollständige Heilung bei Level-Up

### Items
- Waffen: Erhöhen Angriffswert
- Rüstungen: Erhöhen Verteidigungswert
- Level-Anforderungen müssen erfüllt sein

Viel Spaß beim Erkunden der Galaxis! 🌌
