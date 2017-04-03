package kleinanzeigen;

public enum Rolle {
    BE("Benutzer", 1),
    GF("Geschaeftsfuehrer", 2);
    
    // Attribute
    private String typ;
    private int zahl;
    
    // Konstruktor
    Rolle(String test, int zahl) {
        this.typ = test;
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
    public int get_Zahl( ) {
        return this.zahl;
    }
    public String get_Typ() {
        return this.typ;
    } 
}
