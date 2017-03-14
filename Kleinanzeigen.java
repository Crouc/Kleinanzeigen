package kleinanzeigen;

import java.beans.XMLDecoder;           // zum speichern/lesen 
import java.beans.XMLEncoder;           // aus/in XML Dokumente
import java.util.ArrayList;             // wird benötigt für ArrayList (um diese benutzen zu können)
import java.io.*;                       // beinhaltet viele Standardmethoden
import de.htw.saarland.stl.Stdin;       // zum einlesen der Benutzereingaben auf der Konsole
import java.text.ParseException;
import java.util.*; 
import java.text.SimpleDateFormat;

/*********************  Niklas Schulligen   Sascha Magard  ************************************/
/*********************  Elena Schumacher    Marcel Matschiner   *******************************/

public class Kleinanzeigen {
    private ArrayList <Benutzer> benutzerListe;		// Array Liste, die mit Benutzern gefüllt wird
    private ArrayList <Kategorie> kategorieListe;	// Array Liste, die mit Kategorien gefüllt wird
    private ArrayList <Angebot> angebotListe;		// Array Liste, die mit Angeboten gefüllt wird
    private ArrayList <Anzeige> anzeigeListe;		// Array Liste, die mit Anzeigen gefüllt wird
    private ArrayList <Gesuch> gesuchListe;		// Array Liste, die mit Gesuchen gefüllt wird
    private ArrayList <Merkliste> merkListe;
    private String rememberLoginName;                   // Speichern des Mitarbeiter der eingeloggt ist
    private String rememberLoginVorname;                // Speichern des Mitarbeiter der eingeloggt ist
    private int rememberLoginID;                        // Speichern des Mitarbeiter der eingeloggt ist
    private double umsatz;
    private boolean gastzugang;
    
    final static int FELDLAENGE = 25;

    // Konstruktor
    public Kleinanzeigen() {
        benutzerListe = new ArrayList <Benutzer>();
        kategorieListe = new ArrayList <Kategorie>();
        angebotListe = new ArrayList <Angebot>();
        anzeigeListe = new ArrayList <Anzeige>();
        gesuchListe = new ArrayList <Gesuch>();
        merkListe = new ArrayList <Merkliste>();
    }
    
    // set-Methoden
    public void set_BenutzerListe(ArrayList liste) {
        this.benutzerListe = liste;
    }
    public void set_KategorieListe(ArrayList liste) {
        this.kategorieListe = liste;
    }
    public void set_AngebotListe(ArrayList liste) {
        this.angebotListe = liste;
    }
    public void set_AnzeigeListe(ArrayList liste) {
        this.anzeigeListe = liste;
    }
    public void set_GesuchListe(ArrayList liste) {
        this.gesuchListe = liste;
    }
    public void set_MerkListe(ArrayList liste) {
        this.merkListe = liste;
    }
    
    // get-Methoden
    public ArrayList get_BenutzerListe() {
        return this.benutzerListe;
    }
    public ArrayList get_KategorieListe() {
        return this.kategorieListe;
    }
    public ArrayList get_AngebotListe() {
        return this.angebotListe;
    }
    public ArrayList get_AnzeigeListe() {
        return this.anzeigeListe;
    }
    public ArrayList get_GesuchListe() {
        return this.gesuchListe;
    }
    public ArrayList get_MerkListe() {
        return this.merkListe;
    }
   
    
    // Stammdaten
    public void erzeugeStammdaten() throws ParseException {
        Benutzer b1 = new Benutzer("Max", "Mustermann", "015140054879", Rolle.BE, 66111, "Saarbrücken", "maxm", "123456", 0);
        Benutzer b2 = new Benutzer("Thomas", "Angel", "016010026987", Rolle.BE, 56068, "Koblenz", "thomasa", "123456", 0);
        Benutzer b3 = new Benutzer("Sabine", "Klein", "015178943652", Rolle.BE, 10967, "Berlin", "sabinek", "123456", 0);
        Benutzer b4 = new Benutzer("Sarah", "Brill", "016178922445", Rolle.BE, 13505, "Berlin", "sarahb", "123456", 0);
        Benutzer b5 = new Benutzer("Susanne", "Stein", "016044556724", Rolle.GF, 66646, "Berlin", "susannes", "password123", 0);
        benutzerListe.add(b1);
        benutzerListe.add(b2);
        benutzerListe.add(b3);
        benutzerListe.add(b4);
        benutzerListe.add(b5);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date t1 = sdf.parse("01.01.2016");
        Date t2 = sdf.parse("08.03.2016");
        Date t3 = sdf.parse("01.03.2016");
        Date t4 = sdf.parse("10.03.2016");
        
        Angebot a1 = new Angebot("Dell Noteboock", "Dell Notebook zu verkaufen. Top Zustand", Kategorie.EH, b1, 899.95, "neu", t1, false, true, false);
        Angebot a2 = new Angebot("iPhone 7", "Apple iPhone 7 mit Zubehör", Kategorie.EH, b2, 599.99, "gebraucht", t2, false, false, true);
        Angebot a3 = new Angebot("Audi A3", "Audi A3 Limousine", Kategorie.FA, b3, 19.900, "gebraucht", t3, true, true, true);
        Angebot a4 = new Angebot("Lippenstift", "roter Lippenstift von Loreal", Kategorie.MB, b4, 14.99, "neu", t4, false, false, false);
        anzeigeListe.add(a1);
        anzeigeListe.add(a2);
        anzeigeListe.add(a3);
        anzeigeListe.add(a4);
        angebotListe.add(a1);
        angebotListe.add(a2);
        angebotListe.add(a3);
        angebotListe.add(a4);
        
        Gesuch g1 = new Gesuch("Dell Noteboock", "Suche Dell Notebook", Kategorie.EH, b1, 0, "gebraucht", t1, false, 500);
        Gesuch g2 = new Gesuch("Mathematik Nachhilfe", "Suche Nachhilfe im Fach Mathematik", Kategorie.DI, b1, 0, "neu", t1, true, 50);
        anzeigeListe.add(g1);
        anzeigeListe.add(g2);
        gesuchListe.add(g1);
        gesuchListe.add(g2);
        
        Merkliste m1 = new Merkliste(a1, b1);
        Merkliste m2 = new Merkliste(a1, b2);
        Merkliste m3 = new Merkliste(a2, b3);
        Merkliste m4 = new Merkliste(a4, b3);
        merkListe.add(m1);
        merkListe.add(m2);
        merkListe.add(m3);
        merkListe.add(m4);
    }
  
/***************************************************************************************************************/
/**************************************************Menüführung**************************************************/
/***************************************************************************************************************/
    public void startMenue() {
        printProgrammInfo();
        char eingabe;
        try {
            do {
                System.out.println("STARTMENUE");
                System.out.println("------------------------------------------------------------");
                System.out.println("[1] Login");
                System.out.println("[2] Registration");
                System.out.println("[3] Gastzugang");
                System.out.println("[x] Programm beenden");

                printAuswahlTreffen();
                eingabe = Stdin.readlnChar();

                switch (eingabe) {
                    case 'x': System.out.println("Vielen Dank für die Nutzung von Kleinanzeigen. Das Programm wird beendet.");
                              beenden();
                    case '1': loginMenue();
                              break;
                    case '2': registrationMenue();
                              break;
                    case '3': gastzugang = true;
                              gastMenue();
                              break;
                    default: printEingabeFehler();
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    public void loginMenue() {
        printProgrammInfo();
        boolean treffer = false;
        try {
            String user = Stdin.readlnString("Bitte geben Sie Ihren Benutzernamen ein:");
            String pw = Stdin.readlnString("Bitte geben Sie Ihr Passwort ein:");

            Iterator <Benutzer>iter = benutzerListe.iterator();
            while (iter.hasNext()) {
                Benutzer b = iter.next();
                if (b.get_User().equalsIgnoreCase(user) && b.get_Pw().equalsIgnoreCase(pw)) {
                    treffer = true;
                }
            }

            if (treffer = false) {
                System.out.println("Benutzername oder Passwort falsch!");
                startMenue();
                System.out.println("");
                System.out.println("");
                
            } else {
                Iterator <Benutzer>iter2 = benutzerListe.iterator();
                while (iter2.hasNext()) {
                    Benutzer e = iter2.next();

                    if (e.get_User().equalsIgnoreCase(user) && e.get_Pw().equalsIgnoreCase(pw)) {
                        System.out.println("Herzlich Willkommen " + e.get_Vorname() + " " + e.get_Nachname());
                        rememberLoginName = e.get_Nachname();
                        rememberLoginVorname = e.get_Vorname();
                        rememberLoginID = e.get_BenutzerID();
                        switch(e.get_Rolle()) {
                            case BE:
                                mainMenue();
                                break;
                            case GF:
                                mainMenueGF();
                                break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
        
    public void registrationMenue() {
        printProgrammInfo();
        boolean treffer = false;
        try {
            String user = Stdin.readlnString("Bitte geben Sie einen Benutzernamen ein:");
            String pw = Stdin.readlnString("Bitte geben Sie ein Passwort ein:");
            String vorname = Stdin.readlnString("Vorname:");
            String nachname = Stdin.readlnString("Nachname:");
            String tel = Stdin.readlnString("Telefonnummer:");
            int plz = Stdin.readInt("PLZ:");
            String ort = Stdin.readlnString("Ort:");

            Iterator <Benutzer>iter = benutzerListe.iterator();
            while (iter.hasNext()) {
                Benutzer b = iter.next();
                if (b.get_User().equalsIgnoreCase(user)) {
                    treffer = true;
                }
            }

            if (treffer) {
                System.out.println("Benutzername bereits vorhanden!");
                registrationMenue();
                System.out.println("");
                System.out.println("");
            } else {
                Benutzer u = new Benutzer(vorname, nachname, tel, Rolle.BE, plz, ort, user, pw, 0);
                benutzerListe.add(u);
            }
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }    
    
    public void gastMenue() {
        char eingabe;
        try {
            do {
                System.out.println("\nGASTMENUE");
                System.out.println("------------------------------------------------------------");
                System.out.println("[1] Anzeigen durchsuchen");
                System.out.println("[2] Zeige alle Anzeigen");
                System.out.println("[3] Registration");
                System.out.println("[x] Programm beenden");

                printAuswahlTreffen();
                eingabe = Stdin.readlnChar();

                switch (eingabe) {
                    case 'x': System.out.println("Vielen Dank für die Nutzung von Kleinanzeigen. Das Programm wird beendet.");
                              logout();
                    case '1': searchAdvert();
                              break;
                    case '2': showAdverts();
                              break; 
                    case '3': registrationMenue();
                              break;         
                    case '0': mainMenue();
                              break;
                    default: printEingabeFehler();
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }   
    }
    
    public void mainMenue() {
        char eingabe;
        try {
            do {
                System.out.println("\nHAUPTMENUE");
                System.out.println("------------------------------------------------------------");
                System.out.println("[1] Benutzermenue");
                System.out.println("[2] Anzeigemenue");
                System.out.println("[x] Logout");

                printAuswahlTreffen();
                eingabe = Stdin.readlnChar();

                switch (eingabe) {
                    case 'x': System.out.println("Vielen Dank für die Nutzung von Kleinanzeigen. Das Programm wird beendet.");
                              logout();
                    case '1': benutzerMenue();
                              break;
                    case '2': anzeigeMenue();
                              break;
                    default: printEingabeFehler();
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
            mainMenue();
        }  
    }
    
    public void mainMenueGF() {
        char eingabe;
        try {
            do {
                System.out.println("\nStatistik und Analyse für bestimmten Zeitraum");
                System.out.println("------------------------------------------------------------");
                System.out.println("[1] Ausgabe aktive Anzeigen");
                System.out.println("[2] Ausgabe Anzeigen, nach PLZ geordnet");
                System.out.println("[3] Ausgabe Anzeigen, mit Zusatzdiensten (Wie viel wurde verdient)");
                System.out.println("[x] Logout");

                printAuswahlTreffen();
                eingabe = Stdin.readlnChar();

                switch (eingabe) {
                    case 'x': System.out.println("Vielen Dank für die Nutzung von Kleinanzeigen. Das Programm wird beendet.");
                              logout();
                    case '1': showAdvertsOverPeriod();
                              break;
                    case '2': showAdvertsPLZ();
                              break;
                    case '3': showAdvertsAndTurnover();
                              break;
                    default: printEingabeFehler();
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }  
    }
    
    public void benutzerMenue() {
        char eingabe;
        try {
            do {
                System.out.println("\nBENUTZERMENUE - " + rememberLoginVorname);
                System.out.println("------------------------------------------------------------");
                System.out.println("[1] Profilinformationen");
                System.out.println("[2] Passwortänderung");
                System.out.println("[3] Zeige alle Benutzer an");
                System.out.println("[4] Zeige alle Anzeigen eines Benutzers an");
                System.out.println("[5] Zeige Merkliste von " + rememberLoginVorname + " an");
                System.out.println("[6] Geldkonto aufladen");
                System.out.println("[7] Ausgabe des Kassenstandes eines bestimmten Benutzers");
                System.out.println("[0] Haupmenue");
                System.out.println("[x] Logout");

                printAuswahlTreffen();
                eingabe = Stdin.readlnChar();

                switch (eingabe) {
                    case 'x': System.out.println("Vielen Dank für die Nutzung von Kleinanzeigen. Sie wurden erfolgreich abgemeldet.");
                              logout();
                    case '1': showInformation();
                              break;
                    case '2': changePw();
                              break;
                    case '3': showUsers();
                              break;
                    case '4': showAdvert();
                              break;
                    case '5': showWatchList();
                              break;
                    case '6': chargeAccount();
                              break;
                    case '7': cashInHand();
                              break;
                    case '0': mainMenue();
                              break;
                    default: printEingabeFehler();
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }    
    }
    
    public void anzeigeMenue() {
        char eingabe;
        try {
            do {
                System.out.println("\nANZEIGEMENUE");
                System.out.println("------------------------------------------------------------");
                System.out.println("[1] Neues Angebot erstellen");
                System.out.println("[2] Neues Gesuch erstellen");
                System.out.println("[3] Anzeige löschen/deaktivieren");
                System.out.println("[4] Anzeigen durchsuchen");
                System.out.println("[5] Zeige alle Anzeigen");
                System.out.println("[6] Anzeige auf Merkliste setzen");
                System.out.println("[0] Hauptmenue");
                System.out.println("[x] Logout");

                printAuswahlTreffen();
                eingabe = Stdin.readlnChar();

                switch (eingabe) {
                    case 'x': System.out.println("Vielen Dank für die Nutzung von Kleinanzeigen. Das Programm wird beendet.");
                              logout();
                    case '1': createAdvert();
                              break;
                    case '2': createPetition();
                              break;
                    case '3': deleteAdvert();
                              break;          
                    case '4': searchAdvert();
                              break;
                    case '5': showAdverts();
                              break;
                    case '6': advertToWatchlist();
                              break;
                    case '0': mainMenue();
                              break;
                    default: printEingabeFehler();
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }    
    }
    
/***************************************************************************************************************/
/**************************************Programmlogik (Hauptprogramm)********************************************/
/***************************************************************************************************************/ 
    
/*****************************************benutzerMenue - Funktionen********************************************/
    public void showInformation() {
        boolean treffer = false;
        
        // Iterator zum durchlaufen der benutzerListe
        Iterator <Benutzer>iter = benutzerListe.iterator();
        while (iter.hasNext()) {
            Benutzer u = iter.next();
            
            // Es werden alle BenutzerIDs mit der BenutzerID des aktuell eingeloggten Benutzers verglichen
            // Stimmt diese überein, werden die Daten des eingeloggten Benutzers angezeigt
            if (u.get_BenutzerID() == rememberLoginID) {
                treffer = true;
            }
        }
        
        if (!treffer) {
                System.out.println("Fehler bei der Anzeige der Profilinformationen");
        } else {
            Iterator <Benutzer>iter2 = benutzerListe.iterator();
            while(iter2.hasNext()) {
                Benutzer b  = iter2.next();

                if (b.get_BenutzerID() == rememberLoginID) {
                    System.out.print("Vorname:\t");
                    System.out.println(b.get_Vorname());
                    System.out.print("Name:\t\t");
                    System.out.println(b.get_Nachname());
                    System.out.print("Telefonnummer:\t");
                    System.out.println(b.get_TelefonNr());
                    System.out.print("PLZ:\t\t");
                    System.out.println(b.get_Plz());
                    System.out.print("Ort:\t\t");
                    System.out.println(b.get_Ort());
                    System.out.print("Benutzername:\t");
                    System.out.println(b.get_User());
                    System.out.print("Passwort:\t");
                    System.out.println(b.get_Pw());
                    System.out.print("Punktestand:\t");
                    System.out.println(b.get_Punktestand());
                    System.out.print("Benutzer-ID:\t");
                    System.out.println(b.get_BenutzerID());
                }
            }
            printLF();
        }
    }   
    
    public void changePw() {
    boolean treffer = false;

        Iterator <Benutzer>iter = benutzerListe.iterator();
        while (iter.hasNext()) {
            Benutzer u = iter.next();
            
            // Es werden alle BenutzerIDs mit der BenutzerID des aktuell eingeloggten Benutzers verglichen
            // Stimmt diese überein, werden die Daten des eingeloggten Benutzers angezeigt
            if (u.get_BenutzerID() == rememberLoginID) {
                treffer = true;
            }
        }
        
        if (!treffer) {
                System.out.println("Fehler bei der Passwortänderung");
        } else {
            Iterator <Benutzer>iter2 = benutzerListe.iterator();
            while(iter2.hasNext()) {
                Benutzer b  = iter2.next(); 
                
                if (b.get_BenutzerID() == rememberLoginID) {
                    String pwold = Stdin.readlnString("Bitte geben Sie ihr altes Passwort ein: ");
                    if(b.get_Pw().equalsIgnoreCase(pwold)) {
                        String pwnew = Stdin.readlnString("Bitte geben Sie ein neues Passwort ein: ");
                        String pwnewnew = Stdin.readlnString("Bitte geben Sie ihr neues Passwort erneut ein: ");
                        if(pwnew.equalsIgnoreCase(pwnewnew)) {
                            b.set_Pw(pwnew);
                            System.out.println("Passwort erfolgreich geändert.");
                        } else {
                            System.out.println("Passwörter stimmen nicht überein");
                            showInformation();
                        }
                    } else {
                        System.out.println("Falsches Passwort");
                        showInformation();
                    }
                }
            }
        }
    } 
    
    public void showUsers() {
        String s;
        try {
            printZentriert("Vorname");
            printZentriert("Name");
            printZentriert("Tel.");
            printZentriert("PLZ");
            printZentriert("Ort");
            printZentriert("Punktestand");
            printZentriert("Benutzer-ID");

            printLF();
            printLinieLF(7); // Trennlinie für 9 Felder anzeigen

            // Die benutzerListe wird durchlaufen und jeder Benutzer (jedes Objekt der Klasse Benutzer) ausgegeben
            Iterator <Benutzer>iter = benutzerListe.iterator();
            while(iter.hasNext()) {
                Benutzer b  =  iter.next();
                
                printLinksbuendig(b.get_Vorname());
                printLinksbuendig(b.get_Nachname());
                printLinksbuendig(b.get_TelefonNr());
                s = castInt2String(b.get_Plz());
                printZentriert(s);
                printLinksbuendig(b.get_Ort());
                s = castDouble2String(b.get_Punktestand());
                printZentriert(s);
                s = castInt2String(b.get_BenutzerID());
                printZentriert(s);

                printLF();
            }
            printLF();
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
}
    
    public void showAdvert() {
        String s;
        boolean treffer = false;
        try {
            String name = Stdin.readlnString("Bitte geben Sie den Nachnamen des Benutzers ein: ");

            Iterator <Anzeige>iter = anzeigeListe.iterator();
            while (iter.hasNext()) {
                Anzeige a = iter.next();
                if (name.equals(a.get_Benutzer().get_Nachname())) {
                    treffer = true;
                }
            }

            if (!treffer) {
                System.out.println(name + " hat noch keine Anzeigen erstellt.");
            } else {
                printZentriert("Titel");
                printZentriert("Kategorie");
                printZentriert("Vorname");
                printZentriert("Name");
                printZentriert("Preis");
                printZentriert("Art");
                printZentriert("Datum");
                printZentriert("AnzeigeID");

                printLF();
                printLinieLF(8); // Trennlinie für 8 Felder anzeigen

                Iterator <Anzeige>iter2 = anzeigeListe.iterator();
                while(iter2.hasNext()) {
                    Anzeige a  =  iter2.next();
                       if(a.get_Benutzer().get_Nachname().equalsIgnoreCase(name)) {
                            printLinksbuendig(a.get_Titel());
                            printLinksbuendig(a.get_Kategorie().get_Typ());
                            printLinksbuendig(a.get_Benutzer().get_Vorname());
                            printLinksbuendig(a.get_Benutzer().get_Nachname());
                            s = castDouble2String(a.get_Preis());
                            printZentriert(s);
                            printLinksbuendig(a.get_Art());
                            Date date = a.get_Date();
                            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); 
                            printLinksbuendig(sdf.format(date));
                            s = castInt2String(a.get_AnzeigeID());
                            printZentriert(s);

                            printLF();
                       }
                }
                printLF();
            }  
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
       }      
    }
    
    public void showWatchList() {
        String s;
        boolean treffer = false;
        try {
            Iterator <Merkliste>iter = merkListe.iterator();
            while (iter.hasNext()) {
                Merkliste m = iter.next();
                if (m.get_Benutzer().get_BenutzerID() == rememberLoginID) {
                    treffer = true;
                }
            }

            if (!treffer) {
                System.out.println(rememberLoginVorname + " " + rememberLoginName + " hat noch keine Anzeigen auf seiner Merkliste");
            } else {
                printZentriert("Titel");
                printZentriert("Kategorie");
                printZentriert("Vorname");
                printZentriert("Nachname");
                printZentriert("Preis");
                printZentriert("Art");
                printZentriert("Datum");
                printZentriert("AnzeigeID");

                printLF();
                printLinieLF(8); // Trennlinie für 8 Felder anzeigen

                Iterator <Merkliste>iter2 = merkListe.iterator();
                while(iter2.hasNext()) {
                    Merkliste m  =  iter2.next();
                       if(m.get_Benutzer().get_BenutzerID() == rememberLoginID) {
                            printLinksbuendig(m.get_Anzeige().get_Titel());
                            printLinksbuendig(m.get_Anzeige().get_Kategorie().get_Typ());
                            printLinksbuendig(m.get_Benutzer().get_Vorname());
                            printLinksbuendig(m.get_Benutzer().get_Nachname());
                            s = castDouble2String(m.get_Anzeige().get_Preis());
                            printZentriert(s);
                            printLinksbuendig(m.get_Anzeige().get_Art());
                            Date date = m.get_Anzeige().get_Date();
                            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); 
                            printLinksbuendig(sdf.format(date));
                            s = castInt2String(m.get_Anzeige().get_AnzeigeID());
                            printZentriert(s);

                            printLF();
                       }
                }
                printLF();
            }  
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
       }    
    }
    
    public void chargeAccount() {
        try {
            Benutzer b = sucheBenutzerZuBenutzerID(rememberLoginID);
            System.out.println("Ihr aktuelles Guthaben beträgt: " + b.get_Punktestand());
            double wert = Stdin.readDouble("Wie viel Geld möchten Sie auf ihr Konto laden? ");
            b.set_Punktestand(wert + b.get_Punktestand());
            
            System.out.println("Der neue Kontostand beträgt: " + b.get_Punktestand());
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    public void cashInHand() {
        String s;
        boolean treffer = false;
        try {
            String name = Stdin.readlnString("Bitte geben Sie den Nachnamen des Benutzers ein: ");

            Iterator <Benutzer>iter = benutzerListe.iterator();
            while (iter.hasNext()) {
                Benutzer u = iter.next();
                if (name.equals(u.get_Nachname())) {
                    treffer = true;
                }
            }

            if (!treffer) {
                System.out.println("Kein Benutzer mit dem Namen: " + name + " gefunden.");
            } else {
                Iterator <Benutzer>iter2 = benutzerListe.iterator();
                while(iter2.hasNext()) {
                    Benutzer u  =  iter2.next();
                       if(u.get_Nachname().equals(name)) {
                            System.out.println("Der Kassenstand von " + u.get_Vorname() + " " + u.get_Nachname() + " beträgt: " + u.get_Punktestand());
                       }
                }
                printLF();
            }  
        } catch (Exception e) { // tritt eine Ausnahmesituation auf, wird eine Fehlermeldung ausgegeben
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
       }  
    }
    
/*****************************************angebotMenue - Funktionen*********************************************/
    public void createAdvert() {
    char eingabe;
        try {
            // Daten einlesen, die der Benutzer in der Konsole eingibt
            String titel = Stdin.readlnString("Bitte geben Sie den Titel des Angebots ein:");
            String text = Stdin.readlnString("Bitte geben Sie den Beschreibungstext des Angebots ein:");
            double preis = Stdin.readDouble("Bitte geben Sie den Preis der Anzeige ein:");
            String art = Stdin.readlnString("Bitte geben Sie die Art der Anzeige ein:");
            // Neues aktuelles Datum erzeugen
            Date date = new Date();

            System.out.println("Bitte geben Sie die Kategorie der Anzeige ein:");
            System.out.println("[1] Fahrzeuge");
            System.out.println("[2] Dienstleistungen");
            System.out.println("[3] Eintrittskarten, Tickets");
            System.out.println("[4] Elektronik, Handy");
            System.out.println("[5] Familie, Baby");
            System.out.println("[6] Freizeit, Hobby");
            System.out.println("[7] Haus, Garten");
            System.out.println("[8] Haustiere");
            System.out.println("[9] Immobilien");
            System.out.println("[10] Mode, Beauty");
            System.out.println("[11] Musik, Film");
            System.out.println("[12] Unterricht, Kurse");
                
            printAuswahlTreffen();
            // eingabe erwartet eine zahl, welche der Kategorie entspricht (1-12)
            eingabe = (char) Stdin.readlnInt();
            // Das passende Objekt zum gerade eingeloggten Benutzer
            Benutzer b = sucheBenutzerZuBenutzerID(rememberLoginID);
            
            char premium = Stdin.readChar("Möchten Sie eine Premiumanzeige erstellen [J]/[N]?");
            if (premium == 'J') {
                if(b.get_Punktestand() < 5) {
                    System.out.println("Nicht genügend Guthaben auf dem Konto!");
                } else {
                    b.set_Punktestand(b.get_Punktestand() - 5);
                    switch (eingabe) {
                        // Jenachdem welche Zahl eingegeben wurde, wird ein Angebot mit der entsprechenden Kategorie erstellt  udn in der angebotListe und anzeigeListe abgespeichert
                        case 1: 
                            Angebot a1 = new Angebot(titel, text, Kategorie.FA, b, preis, art, date, true, true, false);
                            angebotListe.add(a1);
                            anzeigeListe.add(a1);
                            break;
                        case 2:
                            Angebot a2 = new Angebot(titel, text, Kategorie.DI, b, preis, art, date, true, true, false);
                            angebotListe.add(a2);
                            anzeigeListe.add(a2);
                            break;
                        case 3: 
                            Angebot a3 = new Angebot(titel, text, Kategorie.ET, b, preis, art, date, true, true, false);
                            angebotListe.add(a3);
                            anzeigeListe.add(a3);
                            break;
                        case 4: 
                            Angebot a4 = new Angebot(titel, text, Kategorie.EH, b, preis, art, date, true, true, false);
                            angebotListe.add(a4);
                            anzeigeListe.add(a4);
                            break;
                        case 5: 
                            Angebot a5 = new Angebot(titel, text, Kategorie.FB, b, preis, art, date, true, true, false);
                            angebotListe.add(a5);
                            anzeigeListe.add(a5);
                            break;
                        case 6: 
                            Angebot a6 = new Angebot(titel, text, Kategorie.FH, b, preis, art, date, true, true, false);
                            angebotListe.add(a6);
                            anzeigeListe.add(a6);
                            break;
                        case 7: 
                            Angebot a7 = new Angebot(titel, text, Kategorie.HG, b, preis, art, date, true, true, false);
                            angebotListe.add(a7);
                            anzeigeListe.add(a7);
                            break;
                        case 8: 
                            Angebot a8 = new Angebot(titel, text, Kategorie.HA, b, preis, art, date, true, true, false);
                            angebotListe.add(a8);
                            anzeigeListe.add(a8);
                            break;
                        case 9: 
                            Angebot a9 = new Angebot(titel, text, Kategorie.IM, b, preis, art, date, true, true, false);
                            angebotListe.add(a9);
                            anzeigeListe.add(a9);
                            break;
                        case 10: 
                            Angebot a10 = new Angebot(titel, text, Kategorie.MB, b, preis, art, date, true, true, false);
                            angebotListe.add(a10);
                            anzeigeListe.add(a10);
                            break;
                        case 11: 
                            Angebot a11 = new Angebot(titel, text, Kategorie.MF, b, preis, art, date, true, true, false);
                            angebotListe.add(a11);
                            anzeigeListe.add(a11);
                            break;
                        case 12: 
                            Angebot a12 = new Angebot(titel, text, Kategorie.UK, b, preis, art, date, true, true, false);
                            angebotListe.add(a12);
                            anzeigeListe.add(a12);
                            break;
                        default: printEingabeFehler();
                    } 
                    System.out.println("Premiumanzeige erfolgreich ersetllt.");
                }            
            } else {
                switch (eingabe) {
                    case 1: 
                        Angebot a1 = new Angebot(titel, text, Kategorie.FA, b, preis, art, date, false, false, false);
                        angebotListe.add(a1);
                        anzeigeListe.add(a1);
                        break;
                    case 2:
                        Angebot a2 = new Angebot(titel, text, Kategorie.DI, b, preis, art, date, false, false, false);
                        angebotListe.add(a2);
                        anzeigeListe.add(a2);
                        break;
                    case 3: 
                        Angebot a3 = new Angebot(titel, text, Kategorie.ET, b, preis, art, date, false, false, false);
                        angebotListe.add(a3);
                        anzeigeListe.add(a3);
                        break;
                    case 4: 
                        Angebot a4 = new Angebot(titel, text, Kategorie.EH, b, preis, art, date, false, false, false);
                        angebotListe.add(a4);
                        anzeigeListe.add(a4);
                        break;
                    case 5: 
                        Angebot a5 = new Angebot(titel, text, Kategorie.FB, b, preis, art, date, false, false, false);
                        angebotListe.add(a5);
                        anzeigeListe.add(a5);
                        break;
                    case 6: 
                        Angebot a6 = new Angebot(titel, text, Kategorie.FH, b, preis, art, date, false, false, false);
                        angebotListe.add(a6);
                        anzeigeListe.add(a6);
                        break;
                    case 7: 
                        Angebot a7 = new Angebot(titel, text, Kategorie.HG, b, preis, art, date, false, false, false);
                        angebotListe.add(a7);
                        anzeigeListe.add(a7);
                        break;
                    case 8: 
                        Angebot a8 = new Angebot(titel, text, Kategorie.HA, b, preis, art, date, false, false, false);
                        angebotListe.add(a8);
                        anzeigeListe.add(a8);
                        break;
                    case 9: 
                        Angebot a9 = new Angebot(titel, text, Kategorie.IM, b, preis, art, date, false, false, false);
                        angebotListe.add(a9);
                        anzeigeListe.add(a9);
                        break;
                    case 10: 
                        Angebot a10 = new Angebot(titel, text, Kategorie.MB, b, preis, art, date, false, false, false);
                        angebotListe.add(a10);
                        anzeigeListe.add(a10);
                        break;
                    case 11: 
                        Angebot a11 = new Angebot(titel, text, Kategorie.MF, b, preis, art, date, false, false, false);
                        angebotListe.add(a11);
                        anzeigeListe.add(a11);
                        break;
                    case 12: 
                        Angebot a12 = new Angebot(titel, text, Kategorie.UK, b, preis, art, date, false, false, false);
                        angebotListe.add(a12);
                        anzeigeListe.add(a12);
                        break;
                    default: printEingabeFehler();
                }
                System.out.println("Kostenlose Anzeige erfolgreich ersetllt.");
            }
        } catch (Exception e) { // tritt eine Ausnahmesituation auf, wird eine Fehlermeldung ausgegeben
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    public void createPetition() {
    char eingabe;
        try {
            // Daten einlesen, die der Benutzer in der Konsole eingibt
            String titel = Stdin.readlnString("Bitte geben Sie den Titel des Gesuchs ein:");
            String text = Stdin.readlnString("Bitte geben Sie den Beschreibungstext des Gesuchs ein:");
            double preis = Stdin.readDouble("Bitte geben Sie den Preis des Gesuchs ein:");
            String art = Stdin.readlnString("Bitte geben Sie die Art des Gesuchs ein:");
            double preisgrenze = Stdin.readDouble("Bitte geben Sie die Preisgrenze des Gesuchs ein:");
            Date date = new Date();

            System.out.println("Bitte geben Sie die Kategorie des Gesuchs ein:");
            System.out.println("[1] Fahrzeuge");
            System.out.println("[2] Dienstleistungen");
            System.out.println("[3] Eintrittskarten, Tickets");
            System.out.println("[4] Elektronik, Handy");
            System.out.println("[5] Familie, Baby");
            System.out.println("[6] Freizeit, Hobby");
            System.out.println("[7] Haus, Garten");
            System.out.println("[8] Haustiere");
            System.out.println("[9] Immobilien");
            System.out.println("[10] Mode, Beauty");
            System.out.println("[11] Musik, Film");
            System.out.println("[12] Unterricht, Kurse");
                
            printAuswahlTreffen();
            eingabe = (char) Stdin.readlnInt();
            Benutzer b = sucheBenutzerZuBenutzerID(rememberLoginID);
            
            char premium = Stdin.readChar("Möchten Sie ein Premiumgesuch erstellen [J]/[N]?");
            if (premium == 'J') {
                if(b.get_Punktestand() < 5) {
                    System.out.println("Nicht genügend Guthaben auf dem Konto!");
                } else {
                    b.set_Punktestand(b.get_Punktestand() - 5);
                    switch (eingabe) {
                        // Jenachdem welche Zahl eingegeben wurde, wird ein Gesuch mit der entsprechenden Kategorie erstellt udn in der gesuchListe und anzeigeListe abgespeichert
                        case 1: 
                            Gesuch g1 = new Gesuch(titel, text, Kategorie.FA, b, preis, art, date, true, preisgrenze);
                            gesuchListe.add(g1);
                            anzeigeListe.add(g1);
                            break;
                        case 2:
                            Gesuch g2 = new Gesuch(titel, text, Kategorie.DI, b, preis, art, date, true, preisgrenze);
                            gesuchListe.add(g2);
                            anzeigeListe.add(g2);
                            break;
                        case 3: 
                            Gesuch g3 = new Gesuch(titel, text, Kategorie.ET, b, preis, art, date, true, preisgrenze);
                            gesuchListe.add(g3);
                            anzeigeListe.add(g3);
                            break;
                        case 4: 
                            Gesuch g4 = new Gesuch(titel, text, Kategorie.EH, b, preis, art, date, true, preisgrenze);
                            gesuchListe.add(g4);
                            anzeigeListe.add(g4);
                            break;
                        case 5: 
                            Gesuch g5 = new Gesuch(titel, text, Kategorie.FB, b, preis, art, date, true, preisgrenze);
                            gesuchListe.add(g5);
                            anzeigeListe.add(g5);
                            break;
                        case 6: 
                            Gesuch g6 = new Gesuch(titel, text, Kategorie.FH, b, preis, art, date, true, preisgrenze);
                            gesuchListe.add(g6);
                            anzeigeListe.add(g6);
                            break;
                        case 7: 
                            Gesuch g7 = new Gesuch(titel, text, Kategorie.HG, b, preis, art, date, true, preisgrenze);
                            gesuchListe.add(g7);
                            anzeigeListe.add(g7);
                            break;
                        case 8: 
                            Gesuch g8 = new Gesuch(titel, text, Kategorie.HA, b, preis, art, date, true, preisgrenze);
                            gesuchListe.add(g8);
                            anzeigeListe.add(g8);
                            break;
                        case 9: 
                            Gesuch g9 = new Gesuch(titel, text, Kategorie.IM, b, preis, art, date, true, preisgrenze);
                            gesuchListe.add(g9);
                            anzeigeListe.add(g9);
                            break;
                        case 10: 
                            Gesuch g10 = new Gesuch(titel, text, Kategorie.MB, b, preis, art, date, true, preisgrenze);
                            gesuchListe.add(g10);
                            anzeigeListe.add(g10);
                            break;
                        case 11: 
                            Gesuch g11 = new Gesuch(titel, text, Kategorie.MF, b, preis, art, date, true, preisgrenze);
                            gesuchListe.add(g11);
                            anzeigeListe.add(g11);
                            break;
                        case 12: 
                            Gesuch g12 = new Gesuch(titel, text, Kategorie.UK, b, preis, art, date, true, preisgrenze);
                            gesuchListe.add(g12);
                            anzeigeListe.add(g12);
                            break;
                        default: printEingabeFehler();
                    } 
                    System.out.println("Premiumgesuch erfolgreich ersetllt.");
                }            
            } else {
                switch (eingabe) {
                    case 1: 
                        Gesuch g1 = new Gesuch(titel, text, Kategorie.FA, b, preis, art, date, false, preisgrenze);
                        gesuchListe.add(g1);
                        anzeigeListe.add(g1);
                        break;
                    case 2:
                        Gesuch g2 = new Gesuch(titel, text, Kategorie.DI, b, preis, art, date, false, preisgrenze);
                        gesuchListe.add(g2);
                        anzeigeListe.add(g2);
                        break;
                    case 3: 
                        Gesuch g3 = new Gesuch(titel, text, Kategorie.ET, b, preis, art, date, false, preisgrenze);
                        gesuchListe.add(g3);
                        anzeigeListe.add(g3);
                        break;
                    case 4: 
                        Gesuch g4 = new Gesuch(titel, text, Kategorie.EH, b, preis, art, date, false, preisgrenze);
                        gesuchListe.add(g4);
                        anzeigeListe.add(g4);
                        break;
                    case 5: 
                        Gesuch g5 = new Gesuch(titel, text, Kategorie.FB, b, preis, art, date, false, preisgrenze);
                        gesuchListe.add(g5);
                        anzeigeListe.add(g5);
                        break;
                    case 6: 
                        Gesuch g6 = new Gesuch(titel, text, Kategorie.FH, b, preis, art, date, false, preisgrenze);
                        gesuchListe.add(g6);
                        anzeigeListe.add(g6);
                        break;
                    case 7: 
                        Gesuch g7 = new Gesuch(titel, text, Kategorie.HG, b, preis, art, date, false, preisgrenze);
                        gesuchListe.add(g7);
                        anzeigeListe.add(g7);
                        break;
                    case 8: 
                        Gesuch g8 = new Gesuch(titel, text, Kategorie.HA, b, preis, art, date, false, preisgrenze);
                        gesuchListe.add(g8);
                        anzeigeListe.add(g8);
                        break;
                    case 9: 
                        Gesuch g9 = new Gesuch(titel, text, Kategorie.IM, b, preis, art, date, false, preisgrenze);
                        gesuchListe.add(g9);
                        anzeigeListe.add(g9);
                        break;
                    case 10: 
                        Gesuch g10 = new Gesuch(titel, text, Kategorie.MB, b, preis, art, date, false, preisgrenze);
                        gesuchListe.add(g10);
                        anzeigeListe.add(g10);
                        break;
                    case 11: 
                        Gesuch g11 = new Gesuch(titel, text, Kategorie.MF, b, preis, art, date, false, preisgrenze);
                        gesuchListe.add(g11);
                        anzeigeListe.add(g11);
                        break;
                    case 12: 
                        Gesuch g12 = new Gesuch(titel, text, Kategorie.UK, b, preis, art, date, false, preisgrenze);
                        gesuchListe.add(g12);
                        anzeigeListe.add(g12);
                        break;
                    default: printEingabeFehler();
                }
                System.out.println("Kostenlose Anzeige erfolgreich ersetllt.");
            }
        } catch (Exception e) { // tritt eine Ausnahmesituation auf, wird eine Fehlermeldung ausgegeben
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    private Benutzer sucheBenutzerZuBenutzerID(int benutzerID)  {
        Iterator <Benutzer>iter = benutzerListe.iterator();   //Iterator zum Durchsuchen der anzeigeListe starten
        while(iter.hasNext()) {
            Benutzer b  =  iter.next();
            if(b.get_BenutzerID() == benutzerID){
                return b;                                   //gibt ein Objekt Anzeige zurück
            }
        }
        return null; 
}
    
    public void deleteAdvert() {
        try {
            boolean treffer = false;
            int anzeigeID = Stdin.readlnInt("Bitte geben Sie die ID der Anzeige ein:");
        
            Iterator <Anzeige>iter = anzeigeListe.iterator();
            while (iter.hasNext()) {
                Anzeige a = iter.next();
                if (a.get_AnzeigeID() == anzeigeID) {
                    treffer = true;
                }
            }
        
            if (!treffer) {
                System.out.println("Keine Anzeige mit der ID " + anzeigeID + " gefunden");
            } else {
                Iterator <Anzeige>iter2 = anzeigeListe.iterator();
                while (iter2.hasNext()) {
                    Anzeige a = iter2.next();
                
                    if (a.get_AnzeigeID() == anzeigeID) {
                        String bestaetigung = Stdin.readlnString("Möchten Sie die Anzeige " + a.get_Titel() + " (" + a.get_Text() + ") wirklich löschen? [J/N]");
                        if(bestaetigung.equalsIgnoreCase("J")) {
                            iter2.remove(); // Löscht ein Objekt der Klasse Mitarbeiter
                            System.out.println("Anzeige erfolgreich gelöscht.");
                        } else {
                            anzeigeMenue();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }    
    }
    
    public void searchAdvert() {
        char eingabe;
        boolean menuewechsel = false;
        try {
            do {
                System.out.println("Wie soll nach einer Anzeige gesucht werden?"); 
                System.out.println("[1] Titel"); 
                System.out.println("[2] Kategorie"); 
                System.out.println("[3] Gesuch"); 
                System.out.println("[4] Angebot"); 
                System.out.println("[0] zurück zum Anzeigemenü");

                printAuswahlTreffen();
                eingabe = Stdin.readlnChar();

                switch (eingabe) {
                    case '0': menuewechsel = true;
                        break;
                    case '1': searchAdvertForTitle();
                        break;
                    case '2': searchAdvertForCategory();
                        break;
                    case '3': searchAdvertForPetition();
                        break;
                    case '4': searchAdvertForOffer();
                        break;
                    default: printEingabeFehler();
                }
            } while (!menuewechsel);
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        } 
    }
    
    public void searchAdvertForTitle() {
        String s;
        boolean treffer = false;
        try {
            String titel = Stdin.readlnString("Bitte geben Sie den Titel der Anzeige ein: ");

            Iterator <Anzeige>iter = anzeigeListe.iterator();
            while (iter.hasNext()) {
                Anzeige a = iter.next();
                // Vergleich von String variablen --> equalsIgnoreCase
                if (a.get_Titel().equalsIgnoreCase(titel)) {
                    treffer = true;
                }
            }

            if (!treffer) {
                System.out.println("Keine Anzeige mit dem Titel " + titel + " gefunden");
            } else {
                printZentriert("Titel");
                printZentriert("Kategorie");
                printZentriert("Vorname");
                printZentriert("Name");
                printZentriert("Preis");
                printZentriert("Art");
                printZentriert("Datum");
                printZentriert("AnzeigeID");
                printZentriert("BenutzerID");
                printZentriert("PLZ");

                printLF();
                printLinieLF(10); // Trennlinie für 10 Felder anzeigen

                Iterator <Anzeige>iter2 = anzeigeListe.iterator();
                while(iter2.hasNext()) {
                    Anzeige a  =  iter2.next();
                       if(a.get_Titel().equalsIgnoreCase(titel)) {
                            if(!a.get_Premium()) {
                                printLinksbuendig(a.get_Titel());
                                printLinksbuendig(a.get_Kategorie().get_Typ());
                                printLinksbuendig(a.get_Benutzer().get_Vorname());
                                printLinksbuendig(a.get_Benutzer().get_Nachname());
                                s = castDouble2String(a.get_Preis());
                                printZentriert(s);
                                printLinksbuendig(a.get_Art());
                                Date date = a.get_Date();
                                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); 
                                printLinksbuendig(sdf.format(date));
                                s = castInt2String(a.get_AnzeigeID());
                                printZentriert(s);
                                s = castInt2String(a.get_Benutzer().get_BenutzerID());
                                printZentriert(s);
                                s = castInt2String(a.get_Benutzer().get_Plz());
                                printZentriert(s);

                                printLF();    
                            } else {
                                printLF();  
                                printLinieLF(10); // Trennlinie für 10 Felder anzeigen
                                printLinksbuendig(a.get_Titel());
                                printLinksbuendig(a.get_Kategorie().get_Typ());
                                printLinksbuendig(a.get_Benutzer().get_Vorname());
                                printLinksbuendig(a.get_Benutzer().get_Nachname());
                                s = castDouble2String(a.get_Preis());
                                printZentriert(s);
                                printLinksbuendig(a.get_Art());
                                Date date = a.get_Date();
                                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); 
                                printLinksbuendig(sdf.format(date));
                                s = castInt2String(a.get_AnzeigeID());
                                printZentriert(s);
                                s = castInt2String(a.get_Benutzer().get_BenutzerID());
                                printZentriert(s);
                                s = castInt2String(a.get_Benutzer().get_Plz());
                                printZentriert(s);
                                printLF();  
                                printLinieLF(10); // Trennlinie für 10 Felder anzeigen
                                printLF();    
                            }
                       }
                }
                printLF();
            }  
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
       }  
    }
    
    public void searchAdvertForCategory() {
        int eingabe;
        
        boolean menuewechsel = false;
        try {
            do {
                System.out.println("Welche Kategorie möchten Sie durchsuchen?"); 
                System.out.println("[1] Fahrzeuge"); 
                System.out.println("[2] Dienstleistungen"); 
                System.out.println("[3] Eintrittskarten, Tickets"); 
                System.out.println("[4] Elektronik, Handy"); 
                System.out.println("[5] Freizeit, Hobby"); 
                System.out.println("[6] Haus, Garten"); 
                System.out.println("[7] Haustiere"); 
                System.out.println("[8] Immobilien"); 
                System.out.println("[9] Mode, Beauty"); 
                System.out.println("[10] Musik, Film"); 
                System.out.println("[11] Unterricht, Kurse"); 
                if(gastzugang) {
                    System.out.println("[0] zurück zum Gastmenü");
                } else {
                    System.out.println("[0] zurück zum Anzeigemenü");
                }

                printAuswahlTreffen();
                eingabe = Stdin.readInt();

                String s;
                printZentriert("Titel");
                printZentriert("Kategorie");
                printZentriert("Vorname");
                printZentriert("Name");
                printZentriert("Preis");
                printZentriert("Art");
                printZentriert("Datum");
                printZentriert("AnzeigeID");
                printZentriert("BenutzerID");
                printZentriert("PLZ");

                printLF();
                printLinieLF(10); // Trennlinie für 10 Felder anzeigen

                Iterator <Angebot>iter2 = angebotListe.iterator();
                while(iter2.hasNext()) {
                    Angebot a  =  iter2.next();
                    if(a.get_Kategorie().get_Zahl() == eingabe) {
                        if(!a.get_Premium()) {
                            printLinksbuendig(a.get_Titel());
                            printLinksbuendig(a.get_Kategorie().get_Typ());
                            printLinksbuendig(a.get_Benutzer().get_Vorname());
                            printLinksbuendig(a.get_Benutzer().get_Nachname());
                            s = castDouble2String(a.get_Preis());
                            printZentriert(s);
                            printLinksbuendig(a.get_Art());
                            Date date = a.get_Date();
                            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); 
                            printLinksbuendig(sdf.format(date));
                            s = castInt2String(a.get_AnzeigeID());
                            printZentriert(s);
                            s = castInt2String(a.get_Benutzer().get_BenutzerID());
                            printZentriert(s);
                            s = castInt2String(a.get_Benutzer().get_Plz());
                            printZentriert(s);

                            printLF();    
                        } else {
                            printLF();  
                            printLinieLF(10); // Trennlinie für 10 Felder anzeigen
                            printLinksbuendig(a.get_Titel());
                            printLinksbuendig(a.get_Kategorie().get_Typ());
                            printLinksbuendig(a.get_Benutzer().get_Vorname());
                            printLinksbuendig(a.get_Benutzer().get_Nachname());
                            s = castDouble2String(a.get_Preis());
                            printZentriert(s);
                            printLinksbuendig(a.get_Art());
                            Date date = a.get_Date();
                            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); 
                            printLinksbuendig(sdf.format(date));
                            s = castInt2String(a.get_AnzeigeID());
                            printZentriert(s);
                            s = castInt2String(a.get_Benutzer().get_BenutzerID());
                            printZentriert(s);
                            s = castInt2String(a.get_Benutzer().get_Plz());
                            printZentriert(s);
                            printLF();  
                            printLinieLF(10); // Trennlinie für 10 Felder anzeigen
                            printLF();    
                        }
                    }
                }
                printLF(); 
            } while (!menuewechsel);
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    public void searchAdvertForOffer() {
        String s;
        try {
            printZentriert("Titel");
            printZentriert("Kategorie");
            printZentriert("Vorname");
            printZentriert("Name");
            printZentriert("Preis");
            printZentriert("Art");
            printZentriert("Datum");
            printZentriert("AnzeigeID");
            printZentriert("BenutzerID");
            printZentriert("PLZ");

            printLF();
            printLinieLF(10);           // Trennlinie für 10 Felder anzeigen

            Iterator <Angebot>iter = angebotListe.iterator();
            while(iter.hasNext()) {
                Angebot a  =  iter.next();

                if(!a.get_Premium()) {
                    printLinksbuendig(a.get_Titel());
                    printLinksbuendig(a.get_Kategorie().get_Typ());
                    printLinksbuendig(a.get_Benutzer().get_Vorname());
                    printLinksbuendig(a.get_Benutzer().get_Nachname());
                    s = castDouble2String(a.get_Preis());
                    printZentriert(s);
                    printLinksbuendig(a.get_Art());
                    Date date = a.get_Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); 
                    printLinksbuendig(sdf.format(date));
                    s = castInt2String(a.get_AnzeigeID());
                    printZentriert(s);
                    s = castInt2String(a.get_Benutzer().get_BenutzerID());
                    printZentriert(s);
                    s = castInt2String(a.get_Benutzer().get_Plz());
                    printZentriert(s);

                    printLF();    
                } else {
                    printLF();  
                    printLinieLF(10); // Trennlinie für 10 Felder anzeigen
                    printLinksbuendig(a.get_Titel());
                    printLinksbuendig(a.get_Kategorie().get_Typ());
                    printLinksbuendig(a.get_Benutzer().get_Vorname());
                    printLinksbuendig(a.get_Benutzer().get_Nachname());
                    s = castDouble2String(a.get_Preis());
                    printZentriert(s);
                    printLinksbuendig(a.get_Art());
                    Date date = a.get_Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); 
                    printLinksbuendig(sdf.format(date));
                    s = castInt2String(a.get_AnzeigeID());
                    printZentriert(s);
                    s = castInt2String(a.get_Benutzer().get_BenutzerID());
                    printZentriert(s);
                    s = castInt2String(a.get_Benutzer().get_Plz());
                    printZentriert(s);
                    printLF();  
                    printLinieLF(10); // Trennlinie für 10 Felder anzeigen
                    printLF();    
                }
            }
            printLF();
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    public void searchAdvertForPetition() {
        String s;
        try {
            printZentriert("Titel");
            printZentriert("Kategorie");
            printZentriert("Vorname");
            printZentriert("Name");
            printZentriert("Preis");
            printZentriert("Art");
            printZentriert("Datum");
            printZentriert("AnzeigeID");
            printZentriert("BenutzerID");
            printZentriert("PLZ");

            printLF();
            printLinieLF(10);           // Trennlinie für 10 Felder anzeigen

            Iterator <Gesuch>iter = gesuchListe.iterator();
            while(iter.hasNext()) {
                Gesuch g  =  iter.next();

                if(!g.get_Premium()) {
                    printLinksbuendig(g.get_Titel());
                    printLinksbuendig(g.get_Kategorie().get_Typ());
                    printLinksbuendig(g.get_Benutzer().get_Vorname());
                    printLinksbuendig(g.get_Benutzer().get_Nachname());
                    s = castDouble2String(g.get_Preis());
                    printZentriert(s);
                    printLinksbuendig(g.get_Art());
                    Date date = g.get_Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); 
                    printLinksbuendig(sdf.format(date));
                    s = castInt2String(g.get_AnzeigeID());
                    printZentriert(s);
                    s = castInt2String(g.get_Benutzer().get_BenutzerID());
                    printZentriert(s);
                    s = castInt2String(g.get_Benutzer().get_Plz());
                    printZentriert(s);

                    printLF();    
                } else {
                    printLF();  
                    printLinieLF(10); // Trennlinie für 10 Felder anzeigen
                    printLinksbuendig(g.get_Titel());
                    printLinksbuendig(g.get_Kategorie().get_Typ());
                    printLinksbuendig(g.get_Benutzer().get_Vorname());
                    printLinksbuendig(g.get_Benutzer().get_Nachname());
                    s = castDouble2String(g.get_Preis());
                    printZentriert(s);
                    printLinksbuendig(g.get_Art());
                    Date date = g.get_Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); 
                    printLinksbuendig(sdf.format(date));
                    s = castInt2String(g.get_AnzeigeID());
                    printZentriert(s);
                    s = castInt2String(g.get_Benutzer().get_BenutzerID());
                    printZentriert(s);
                    s = castInt2String(g.get_Benutzer().get_Plz());
                    printZentriert(s);
                    printLF();  
                    printLinieLF(10); // Trennlinie für 10 Felder anzeigen
                    printLF();    
                }
            }
            printLF();
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        } 
    }
    
    public void showAdverts() {
        String s;
        try {
            printZentriert("Titel");
            printZentriert("Kategorie");
            printZentriert("Vorname");
            printZentriert("Name");
            printZentriert("Preis");
            printZentriert("Art");
            printZentriert("Datum");
            printZentriert("AnzeigeID");
            printZentriert("BenutzerID");
            printZentriert("PLZ");

            printLF();
            printLinieLF(10);           // Trennlinie für 10 Felder anzeigen

            Iterator <Anzeige>iter2 = anzeigeListe.iterator();
                while(iter2.hasNext()) {
                    Anzeige a  =  iter2.next();
                    if(!a.get_Premium()) {
                         printLinksbuendig(a.get_Titel());
                         printLinksbuendig(a.get_Kategorie().get_Typ());
                         printLinksbuendig(a.get_Benutzer().get_Vorname());
                         printLinksbuendig(a.get_Benutzer().get_Nachname());
                         s = castDouble2String(a.get_Preis());
                         printZentriert(s);
                         printLinksbuendig(a.get_Art());
                         Date date = a.get_Date();
                         SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); 
                         printLinksbuendig(sdf.format(date));
                         s = castInt2String(a.get_AnzeigeID());
                         printZentriert(s);
                         s = castInt2String(a.get_Benutzer().get_BenutzerID());
                         printZentriert(s);
                         s = castInt2String(a.get_Benutzer().get_Plz());
                         printZentriert(s);

                         printLF();  
                    } else {
                         printLF();  
                         printLinieLF(10); // Trennlinie für 10 Felder anzeigen
                         printLinksbuendig(a.get_Titel());
                         printLinksbuendig(a.get_Kategorie().get_Typ());
                         printLinksbuendig(a.get_Benutzer().get_Vorname());
                         printLinksbuendig(a.get_Benutzer().get_Nachname());
                         s = castDouble2String(a.get_Preis());
                         printZentriert(s);
                         printLinksbuendig(a.get_Art());
                         Date date = a.get_Date();
                         SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); 
                         printLinksbuendig(sdf.format(date));
                         s = castInt2String(a.get_AnzeigeID());
                         printZentriert(s);
                         s = castInt2String(a.get_Benutzer().get_BenutzerID());
                         printZentriert(s);
                         s = castInt2String(a.get_Benutzer().get_Plz());
                         printZentriert(s);
                         printLF();
                         printLinieLF(10); // Trennlinie für 10 Felder anzeigen
                         printLF();
                    }  
            }
            printLF();
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    public void advertToWatchlist() {
        try {
            boolean treffer = false;
            int anzeigeID = Stdin.readlnInt("Bitte geben Sie die ID der Anzeige ein:");
        
            Iterator <Anzeige>iter = anzeigeListe.iterator();
            while (iter.hasNext()) {
                Anzeige a = iter.next();
                if (a.get_AnzeigeID() == anzeigeID) {
                    treffer = true;
                }
            }
        
            if (!treffer) {
                System.out.println("Keine Anzeige mit der ID " + anzeigeID + " gefunden");
            } else {
                Iterator <Anzeige>iter2 = anzeigeListe.iterator();
                while (iter2.hasNext()) {
                    Anzeige a = iter2.next();
                
                    if (a.get_AnzeigeID() == anzeigeID) {
                        String bestaetigung = Stdin.readlnString("Möchten Sie die Anzeige " + a.get_Titel() + " (" + a.get_Text() + ") wirklich auf Ihre Merkliste setzen? [J/N]");
                        if(bestaetigung.equalsIgnoreCase("J")) {
                            Benutzer b = sucheBenutzerZuBenutzerID(rememberLoginID);
                            Merkliste m1 = new Merkliste(a, b);
                            merkListe.add(m1);
                            System.out.println("Anzeige wurde erfolgreich auf " + b.get_Vorname() + " " + b.get_Nachname() + "´s Merkliste gesetzt.");
                        } else {
                            anzeigeMenue();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
/*****************************************mainMenueGF - Funktionen**********************************************/
    public void showAdvertsOverPeriod() {
        try {
            String s;
            int anzahl = 0;
            boolean treffer = false;
            int dateBeginDay = Stdin.readInt("Startdatum (Tag): ");
            int dateBeginMonth = Stdin.readInt("Startdatum (Monat): ");
            int dateBeginYear = Stdin.readInt("Startdatum (Jahr): ");
            Date beginDate = new Date(dateBeginYear - 1900, dateBeginMonth, dateBeginDay);

            int dateEndDay = Stdin.readInt("Enddatum (Tag): ");
            int dateEndMonth = Stdin.readInt("Enddatum (Monat): ");
            int dateEndYear = Stdin.readInt("Enddatum (Jahr): ");
            Date endDate = new Date(dateEndYear - 1900, dateEndMonth, dateEndDay);

            Iterator <Anzeige>iter = anzeigeListe.iterator();
            while (iter.hasNext()) {
                Anzeige h = iter.next();
                Date past = h.get_Date();
                if (beginDate.before(past) && endDate.after(past)) {
                    treffer = true;
                }
            }
            if (!treffer) {
                System.out.println("In diesem Zeitraum gibt es keine Anzeigen.");
            } else {
                printZentriert("Titel");
                printZentriert("Kategorie");
                printZentriert("Vorname");
                printZentriert("Name");
                printZentriert("Preis");
                printZentriert("Art");
                printZentriert("Datum");
                printZentriert("AnzeigeID");
                printZentriert("BenutzerID");
                printZentriert("PLZ");

                printLF();
                printLinieLF(10); // Trennlinie für 10 Felder anzeigen

                Iterator <Anzeige>iter2 = anzeigeListe.iterator();
                while(iter2.hasNext()) {
                    Anzeige a  =  iter2.next();
                    Date past = a.get_Date();
                       if(beginDate.before(past) && endDate.after(past)) {
                           anzahl++;
                           if(!a.get_Premium()) {
                                printLinksbuendig(a.get_Titel());
                                printLinksbuendig(a.get_Kategorie().get_Typ());
                                printLinksbuendig(a.get_Benutzer().get_Vorname());
                                printLinksbuendig(a.get_Benutzer().get_Nachname());
                                s = castDouble2String(a.get_Preis());
                                printZentriert(s);
                                printLinksbuendig(a.get_Art());
                                Date date = a.get_Date();
                                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); 
                                printLinksbuendig(sdf.format(date));
                                s = castInt2String(a.get_AnzeigeID());
                                printZentriert(s);
                                s = castInt2String(a.get_Benutzer().get_BenutzerID());
                                printZentriert(s);
                                s = castInt2String(a.get_Benutzer().get_Plz());
                                printZentriert(s);

                                printLF();  
                           } else {
                                printLF();  
                                printLinieLF(10); // Trennlinie für 10 Felder anzeigen
                                printLinksbuendig(a.get_Titel());
                                printLinksbuendig(a.get_Kategorie().get_Typ());
                                printLinksbuendig(a.get_Benutzer().get_Vorname());
                                printLinksbuendig(a.get_Benutzer().get_Nachname());
                                s = castDouble2String(a.get_Preis());
                                printZentriert(s);
                                printLinksbuendig(a.get_Art());
                                Date date = a.get_Date();
                                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); 
                                printLinksbuendig(sdf.format(date));
                                s = castInt2String(a.get_AnzeigeID());
                                printZentriert(s);
                                s = castInt2String(a.get_Benutzer().get_BenutzerID());
                                printZentriert(s);
                                s = castInt2String(a.get_Benutzer().get_Plz());
                                printZentriert(s);
                                printLF();
                                printLinieLF(10); // Trennlinie für 10 Felder anzeigen
                                printLF();
                           }  
                       }
                }
                System.out.println("Im Zeitraum vom " + dateBeginDay + "." + dateBeginMonth + "." + dateBeginYear + " bis zum " + dateEndDay + "." + dateEndMonth + "." + dateEndYear + " wurden " + anzahl + " aktive Anzeigen gefunden.");
                printLF();
            }  
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut."); 
        }
    }
    
    public void showAdvertsPLZ() {
       try {
            String s;
            int anzahl = 0;
            boolean treffer = false;
            int dateBeginDay = Stdin.readInt("Startdatum (Tag): ");
            int dateBeginMonth = Stdin.readInt("Startdatum (Monat): ");
            int dateBeginYear = Stdin.readInt("Startdatum (Jahr): ");
            Date beginDate = new Date(dateBeginYear - 1900, dateBeginMonth, dateBeginDay);

            int dateEndDay = Stdin.readInt("Enddatum (Tag): ");
            int dateEndMonth = Stdin.readInt("Enddatum (Monat): ");
            int dateEndYear = Stdin.readInt("Enddatum (Jahr): ");
            Date endDate = new Date(dateEndYear - 1900, dateEndMonth, dateEndDay);

            Iterator <Anzeige>iter = anzeigeListe.iterator();
            while (iter.hasNext()) {
                Anzeige h = iter.next();
                Date past = h.get_Date();
                if (beginDate.before(past) && endDate.after(past)) {
                    treffer = true;
                }
            }
            if (!treffer) {
                System.out.println("In diesem Zeitraum gibt es keine Anzeigen.");
            } else {
                printZentriert("Titel");
                printZentriert("Kategorie");
                printZentriert("Vorname");
                printZentriert("Name");
                printZentriert("Preis");
                printZentriert("Art");
                printZentriert("Datum");
                printZentriert("AnzeigeID");
                printZentriert("BenutzerID");
                printZentriert("PLZ");

                printLF();
                printLinieLF(10); // Trennlinie für 10 Felder anzeigen

                Iterator <Anzeige>iter2 = anzeigeListe.iterator();
                while(iter2.hasNext()) {
                    Anzeige a  =  iter2.next();
                    Date past = a.get_Date();
                       if(beginDate.before(past) && endDate.after(past)) {
                           anzahl++;
                           if(!a.get_Premium()) {
                                printLinksbuendig(a.get_Titel());
                                printLinksbuendig(a.get_Kategorie().get_Typ());
                                printLinksbuendig(a.get_Benutzer().get_Vorname());
                                printLinksbuendig(a.get_Benutzer().get_Nachname());
                                s = castDouble2String(a.get_Preis());
                                printZentriert(s);
                                printLinksbuendig(a.get_Art());
                                Date date = a.get_Date();
                                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); 
                                printLinksbuendig(sdf.format(date));
                                s = castInt2String(a.get_AnzeigeID());
                                printZentriert(s);
                                s = castInt2String(a.get_Benutzer().get_BenutzerID());
                                printZentriert(s);
                                s = castInt2String(a.get_Benutzer().get_Plz());
                                printZentriert(s);

                                printLF();  
                           } else {
                                printLF();  
                                printLinieLF(10); // Trennlinie für 10 Felder anzeigen
                                printLinksbuendig(a.get_Titel());
                                printLinksbuendig(a.get_Kategorie().get_Typ());
                                printLinksbuendig(a.get_Benutzer().get_Vorname());
                                printLinksbuendig(a.get_Benutzer().get_Nachname());
                                s = castDouble2String(a.get_Preis());
                                printZentriert(s);
                                printLinksbuendig(a.get_Art());
                                Date date = a.get_Date();
                                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); 
                                printLinksbuendig(sdf.format(date));
                                s = castInt2String(a.get_AnzeigeID());
                                printZentriert(s);
                                s = castInt2String(a.get_Benutzer().get_BenutzerID());
                                printZentriert(s);
                                s = castInt2String(a.get_Benutzer().get_Plz());
                                printZentriert(s);
                                printLF();
                                printLinieLF(10); // Trennlinie für 10 Felder anzeigen
                                printLF();
                           }  
                       }
                }
                System.out.println("Im Zeitraum vom " + dateBeginDay + "." + dateBeginMonth + "." + dateBeginYear + " bis zum " + dateEndDay + "." + dateEndMonth + "." + dateEndYear + " wurden " + anzahl + " aktive Anzeigen gefunden.");
                printLF();
            }  
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut."); 
        } 
    }
    
    public void showAdvertsAndTurnover() {
        try {
            String s;
            int anzahl = 0;
            boolean treffer = false;
            int dateBeginDay = Stdin.readInt("Startdatum (Tag): ");
            int dateBeginMonth = Stdin.readInt("Startdatum (Monat): ");
            int dateBeginYear = Stdin.readInt("Startdatum (Jahr): ");
            Date beginDate = new Date(dateBeginYear - 1900, dateBeginMonth, dateBeginDay);

            int dateEndDay = Stdin.readInt("Enddatum (Tag): ");
            int dateEndMonth = Stdin.readInt("Enddatum (Monat): ");
            int dateEndYear = Stdin.readInt("Enddatum (Jahr): ");
            Date endDate = new Date(dateEndYear - 1900, dateEndMonth, dateEndDay);

            Iterator <Anzeige>iter = anzeigeListe.iterator();
            while (iter.hasNext()) {
                Anzeige h = iter.next();
                Date past = h.get_Date();
                if (beginDate.before(past) && endDate.after(past)) {
                    treffer = true;
                }
            }
            if (!treffer) {
                System.out.println("In diesem Zeitraum gibt es keine Anzeigen.");
            } else {
                printZentriert("Titel");
                printZentriert("Kategorie");
                printZentriert("Vorname");
                printZentriert("Name");
                printZentriert("Preis");
                printZentriert("Art");
                printZentriert("Datum");
                printZentriert("AnzeigeID");
                printZentriert("BenutzerID");
                printZentriert("PLZ");

                printLF();
                printLinieLF(10); // Trennlinie für 10 Felder anzeigen

                Iterator <Anzeige>iter2 = anzeigeListe.iterator();
                while(iter2.hasNext()) {
                    Anzeige a  =  iter2.next();
                    Date past = a.get_Date();
                       if(beginDate.before(past) && endDate.after(past)) {
                           if(a.get_Premium()) {
                                anzahl++;
                                printLF();  
                                printLinieLF(10); // Trennlinie für 10 Felder anzeigen
                                printLinksbuendig(a.get_Titel());
                                printLinksbuendig(a.get_Kategorie().get_Typ());
                                printLinksbuendig(a.get_Benutzer().get_Vorname());
                                printLinksbuendig(a.get_Benutzer().get_Nachname());
                                s = castDouble2String(a.get_Preis());
                                printZentriert(s);
                                printLinksbuendig(a.get_Art());
                                Date date = a.get_Date();
                                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); 
                                printLinksbuendig(sdf.format(date));
                                s = castInt2String(a.get_AnzeigeID());
                                printZentriert(s);
                                s = castInt2String(a.get_Benutzer().get_BenutzerID());
                                printZentriert(s);
                                s = castInt2String(a.get_Benutzer().get_Plz());
                                printZentriert(s);
                                printLF();
                                printLinieLF(10); // Trennlinie für 10 Felder anzeigen
                                printLF();
                           }  
                       }
                }
                System.out.println("Im Zeitraum vom " + dateBeginDay + "." + dateBeginMonth + "." + dateBeginYear + " bis zum " + dateEndDay + "." + dateEndMonth + "." + dateEndYear + " wurden " + anzahl + " Anzeigen mit Zusatzdiensten geschaltet.");
                System.out.println("Dabei wurden " + (5*anzahl) + " Euro eingenommen.");
                printLF();
            }  
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut."); 
        }    
    }

/***************************************************************************************************************/
/**********************************Funktionen zur Darstellung des Menüs*****************************************/
/***************************************************************************************************************/
    private String castInt2String(int meinInt) {
        return Integer.toString(meinInt);
        // die obige Zeile ist von der Funktion identisch zu
        // Integer i = new Integer(meinInt);
        // return i.toString();
    }

    private String castDouble2String(double meinDouble) {
        // hier nutzen wir die Format-Anweisung der Klasse String um die Nachkommastellen zu bestimmen etc.
        return String.format("%,8.2f", meinDouble);
    }

    private void printLF() {
        System.out.println();
    }

    private void printZentriert(String s) {
        System.out.print(baueZentriertenString(s, FELDLAENGE));
    }

    private void printLinksbuendig(String s) {
        System.out.print(baueLinksbuendigenString(s, FELDLAENGE));
    }

    private void printRechtsbuendig(String s) {
        System.out.print(baueRechtsbuendigenString(s, FELDLAENGE));
    }

    private void printLinieLF(int anzahlFelder) {
        /* Besonderheit: hier Nutzung des StringBuilders statt direkt mit String zu arbeiten.
         * Ist sparsamer im Umgang mit Speicher.
         */
        StringBuilder s = new StringBuilder();
        int laenge = anzahlFelder*(FELDLAENGE+3);
        for (int i=1;i<=laenge;i++) {
            s=s.append("-");
        }
        System.out.println(s);
    }

    private String baueZentriertenString(String s, int laenge) {
        // wir entfernen Leerzeichen am Anfang und Ende des Strings
        s.trim();
        // falls der String zu lang ist, kuerzen wir ihn
        if (s.length() > laenge) {
            s.substring(0, laenge);
        } else {
            int differenzLinks = (laenge - s.length())/2;
            for (int i=1;i<=differenzLinks;i++) s=" "+s+" ";
            if (s.length()<laenge) s=s+" ";
        }
        return s+" | ";
    }

    private String baueRechtsbuendigenString(String s, int laenge) {
        // wir entfernen Leerzeichen am Anfang und Ende des Strings
        s.trim();
        // falls der String zu lang ist, kuerzen wir ihn
        if (s.length() > laenge) {
            s.substring(0, laenge);
        } else {
            int differenzLinks = (laenge - s.length());
            for (int i=1;i<=differenzLinks;i++) s=" "+s;
        }
        return s+" | ";
    }

    private String baueLinksbuendigenString(String s, int laenge) {
        // wir entfernen Leerzeichen am Anfang und Ende des Strings
        s.trim();
        // falls der String zu lang ist, kuerzen wir ihn
        if (s.length() > laenge) {
            s.substring(0, laenge);
        } else {
            int differenz = (laenge - s.length());
            for (int i=1;i<=differenz;i++) s=s+" ";
        }
        return s+" | ";
    }

    private void printEingabeFehler() {
        System.out.print("Ihre Eingabe wurde nicht erkannt.\n");
    }

    private void printAuswahlTreffen() {
        System.out.print("Bitte treffen Sie eine Auswahl ...\n");
    }

    private void printProgrammInfo() {
        System.out.println("********************************************************************");
        System.out.println("* Kleinanzeigen by      Niklas Schulligen   Sascha Magard          *");
        System.out.println("*                       Elena Schumacher    Marcel Matschiner      *");
        System.out.println("********************************************************************");
}
    
/***************************************************************************************************************/
/**********************************Funktionen zum Speichern der Daten*******************************************/
/***************************************************************************************************************/
    private void saveDataToXML() throws IOException {
        XMLEncoder o = new XMLEncoder(new FileOutputStream("Kleinanzeigen.xml"));
        o.writeObject("Kleinanzeigen");
        o.writeObject(this);
        o.close();
    }

    public Object loadDataFromXML() throws IOException {
        XMLDecoder o = new XMLDecoder(new FileInputStream("Kleinanzeigen.xml"));
        o.readObject();
        Object obj = o.readObject();
        o.close();
        return obj;
    }

    private void save() {
        try {
            saveDataToXML();
        }
        catch(java.io.IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void load() {
        try {
            Kleinanzeigen k = (Kleinanzeigen) loadDataFromXML();
            k.startMenue();
            
        }
        catch(java.io.IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
/***************************************************************************************************************/
/*********************************************Sonstige Funktionen***********************************************/
/***************************************************************************************************************/   
    public void logout(){
        System.out.println("Sie haben sich erfolgreich ausgeloggt.");
        System.out.println("");
        save();
        beenden();
    }
    
    private void beenden() {
        save();
        System.exit(0);
    }
    
        // main-Methode
    public static void main(String[] args) throws ParseException {
        Kleinanzeigen k = new Kleinanzeigen();
        
        k.erzeugeStammdaten();
        k.load();
        k.startMenue();
    }
    
}
