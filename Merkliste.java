package kleinanzeigen;


public class Merkliste {
    private Anzeige anzeige;
    private Benutzer benutzer;
    
    // Konstruktor
    public Merkliste() {
        
    }
    public Merkliste(Anzeige anzeige, Benutzer benutzer) {
        this.anzeige = anzeige;
        this.benutzer = benutzer;
    }
    
    // set-Methoden
    public void set_Anzeige(Anzeige anzeige) {
        this.anzeige = anzeige;
    }
    public void set_Benutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
    }
    
    // get-Methoden
    public Anzeige get_Anzeige() {
        return this.anzeige;
    }
    public Benutzer get_Benutzer() {
        return this.benutzer;
    }
}
