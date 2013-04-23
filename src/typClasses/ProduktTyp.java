package typClasses;

import classes.Orderbuch;
import interfaces.IAngebot;
import interfaces.IBestellung;
import interfaces.IEinkaufsinfosatz;
import interfaces.IWarenausgangsmeldung;

import java.util.ArrayList;
import java.util.List;

public class ProduktTyp {

    private int produktNummer;
    private String name;
    private int lagerbestand;
    private Orderbuch orderbuch;
    private List<IWarenausgangsmeldung> warenausgangsmeldungList = new ArrayList<IWarenausgangsmeldung>();
    private List<IAngebot> angebotList = new ArrayList<IAngebot>();
    private List<IEinkaufsinfosatz> einkaufsinfosatzList = new ArrayList<IEinkaufsinfosatz>();
    private List<IBestellung> bestellungList = new ArrayList<IBestellung>();


    public ProduktTyp(int produktNummer, String name, int lagerbestand, Orderbuch orderbuch, List<IWarenausgangsmeldung> warenausgangsmeldungList, List<IAngebot> angebotList, List<IEinkaufsinfosatz> einkaufsinfosatzList, List<IBestellung> bestellungList) {
        this.produktNummer = produktNummer;
        this.name = name;
        this.lagerbestand = lagerbestand;
        this.orderbuch = orderbuch;
        this.warenausgangsmeldungList = warenausgangsmeldungList;
        this.angebotList = angebotList;
        this.einkaufsinfosatzList = einkaufsinfosatzList;
        this.bestellungList = bestellungList;
    }

    public int getProduktNummer() {
        return produktNummer;
    }

    public String getProduktName() {
        return name;
    }

    public int getLagerbestand() {
        return lagerbestand;
    }

    public Orderbuch getOrderbuch() {
        return orderbuch;
    }

    public List<IWarenausgangsmeldung> getWarenausgangsmeldungList() {
        return warenausgangsmeldungList;
    }

    public List<IAngebot> getAngebotList() {
        return angebotList;
    }

    public List<IEinkaufsinfosatz> getEinkaufsinfosatzList() {
        return einkaufsinfosatzList;
    }

    public List<IBestellung> getBestellungList() {
        return bestellungList;
    }
}
