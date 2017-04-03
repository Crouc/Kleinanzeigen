package kleinanzeigen;

public class Benutzer {
    // Attribute
    private String vorname;
    private String nachname;
    private String telefonnr;
    private Rolle rolle;
    private int plz;
    private String ort;
    private String user;
    private String pw;
    private double punktestand;
    private int benutzerID;
    private static int idCounter= 1000;

    // Konstruktor
    public Benutzer() {
        
    }
    public Benutzer(String vname, String nname, String telefonnr, Rolle rolle, int plz, String ort, String user, String pw, double punktestand) {
        this.vorname = vname;
        this.nachname = nname;
        this.telefonnr = telefonnr;
        this.rolle = rolle;
        this.plz = plz;
        this.ort = ort;
        this.user = user;
        this.pw = pw;
        this.punktestand = punktestand;
        this.benutzerID = idCounter;
        idCounter++;
    }
    
    // set-Methoden
    public void set_Vorname(String vname) {
        this.vorname = vname;
    }
    public void set_Nachname(String nname) {
        this.nachname = nname;
    }
    public void set_TelefonNr(String telefonnr) {
        this.telefonnr = telefonnr;
    }
    public void set_Rolle(Rolle rolle) {
        this.rolle = rolle;
    }
    public void set_Plz(int plz) {
        this.plz = plz;
    }
    public void set_Ort(String ort) {
        this.ort = ort;
    }
    public void set_User(String user) {
        this.user = user;
    }
    public void set_Pw(String pw) {
        this.pw = pw;
    }
    public void set_Punktestand(double punktestand) {
        this.punktestand = punktestand;
    }
    public void set_BenutzerID(int benutzerID) {
        this.benutzerID = benutzerID;
    }
    
    // get-Methoden
    public String get_Vorname() {
        return this.vorname;
    }
    public String get_Nachname() {
        return this.nachname;
    }
    public String get_TelefonNr() {
        return this.telefonnr;
    }
    public Rolle get_Rolle() {
        return this.rolle;
    }
    public int get_Plz() {
        return this.plz;
    }
    public String get_Ort() {
        return this.ort;
    }
    public String get_User() {
        return this.user;
    }
    public String get_Pw() {
        return this.pw;
    }
    public double get_Punktestand() {
        return this.punktestand;
    }
    public int get_BenutzerID() {
        return this.benutzerID;
    }
}
