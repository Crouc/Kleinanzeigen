package kleinanzeigen;

import java.util.Date;


public class Anzeige {
    // Attribute
    private String titel;
    private String text;
    private Kategorie kategorie;
    private Benutzer benutzer;
    private double preis;
    private String art;
    Date date = new Date();
    private boolean premium;
    private int anzeigeID;
    private static int idCounter = 2000;
    
    // Konstruktor
    public Anzeige() {
        
    }
    public Anzeige(String titel, String text, Kategorie kategorie, Benutzer benutzer, double preis, String art, Date date, boolean premium) {
        this.titel = titel;
        this.text = text;
        this.kategorie = kategorie;
        this.benutzer = benutzer;
        this.preis = preis;
        this.art = art;
        this.date = date;
        this.premium = premium;
        this.anzeigeID = idCounter;
        idCounter++;
    }
    
    // set-Methoden
    public void set_Titel(String titel) {
        this.titel = titel;
    }
    public void set_Text(String text) {
        this.text = text;
    }
    public void set_Kategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }
    public void set_Benutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
    }
    public void set_AnzeigeID(int anzeigeID) {
        this.anzeigeID = anzeigeID;
    }
    public void set_Preis(double preis) {
        this.preis = preis;
    }
    public void set_Art(String art) {
        this.art = art;
    }
    public void set_Date(Date date) {
        this.date = date;
    }
    public void set_Premium(boolean premium) {
        this.premium = premium;
    }
    
    // get-Methoden
    public String get_Titel() {
        return this.titel;
    }
    public String get_Text() {
        return this.text;
    }
    public Kategorie get_Kategorie() {
        return this.kategorie;
    }
    public Benutzer get_Benutzer() {
        return this.benutzer;
    }
    public int get_AnzeigeID() {
        return this.anzeigeID;
    }
    public double get_Preis() {
        return this.preis;
    }
    public String get_Art() {
        return this.art;
    }
    public Date get_Date() {
        return this.date;
    }
    public boolean get_Premium() {
        return this.premium;
    }
}
