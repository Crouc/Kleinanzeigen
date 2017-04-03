package kleinanzeigen;

import java.util.Date;


public class Angebot extends Anzeige {
    // Attribute
    private boolean kostenlos;
    private boolean versand;
    
    // Konstruktor
    public Angebot() {
        
    }
    public Angebot(String titel, String text, Kategorie kategorie, Benutzer benutzer, double preis, String art, Date date, boolean premium, boolean kostenlos, boolean versand) {
        super(titel, text, kategorie, benutzer, preis, art, date, premium);
        this.kostenlos = kostenlos;
        this.versand = versand;
    }
    
    // set-Methoden
    public void set_Kostenlos(boolean kostenlos) {
        this.kostenlos = kostenlos;
    }
    public void set_Versand(boolean versand) {
        this.versand = versand;
    }
    
    // get-Methoden
    public boolean get_Kostenlos() {
        return this.kostenlos;
    }
    public boolean get_Versand() {
        return this.versand;
    }
}
