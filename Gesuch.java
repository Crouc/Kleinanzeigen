package kleinanzeigen;

import java.util.Date;


public class Gesuch extends Anzeige {
    // Attribute
    private double preisgrenze;

    // Konstruktor
    public Gesuch() {
        
    }  
    public Gesuch(String titel, String text, Kategorie kategorie, Benutzer benutzer, double preis, String art, Date date, boolean premium, double preisgrenze) {
        super(titel, text, kategorie, benutzer, preis, art, date, premium);
        this.preisgrenze = preisgrenze;
    }
    
    // set-Methoden
    public void set_Preisgrenze(double preisgrenze) {
        this.preisgrenze = preisgrenze;
    }
    
    // get-Methoden
    public double get_Preisliste() {
        return this.preisgrenze;
    }
}
