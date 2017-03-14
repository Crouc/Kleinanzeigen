package kleinanzeigen;

/*********************  Niklas Schulligen   Sascha Magard  ************************************/
/*********************  Elena Schumacher    Marcel Matschiner   *******************************/

public enum Kategorie {
    FA("Fahrzeuge", 1),
    DI("Dienstleistungen", 2),
    ET("Eintrittskarten, Tickets", 3),
    EH("Elektronik, Handy", 4),
    FB("Familie, Baby", 5),
    FH("Freizeit, Hobby", 6),
    HG("Haus, Garten", 7),
    HA("Haustiere", 8),
    IM("Immobilien", 9),
    MB("Mode, Beauty", 10),
    MF("Musik, Film", 11),
    UK("Unterricht, Kurse", 12);
    
    // Attribute
    private String typ;
    private int zahl;
    
    // Konstruktor
    Kategorie(String typ, int zahl) {
        this.typ = typ;
        this.zahl = zahl;
    }
    
    // set-Methoden
    public void set_Typ(String typ) {
        this.typ = typ;
    }
    public void set_Zahl(int zahl) {
        this.zahl = zahl;
    }
    
    // get-Methoden
    public String get_Typ() {
        return this.typ;
    }
    public int get_Zahl() {
        return this.zahl;
    }
}
