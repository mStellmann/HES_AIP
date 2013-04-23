package classes;

import interfaces.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Produkt implements IProdukt {
    private int produktNummer;
    private String name;
    private int lagerbestand;
    private Orderbuch orderbuch;
    private List<IWarenausgangsmeldung> warenausgangsmeldungList = new ArrayList<IWarenausgangsmeldung>();
    private List<IAngebot> angebotList = new ArrayList<IAngebot>();
    private List<IEinkaufsinfosatz> einkaufsinfosatzList = new ArrayList<IEinkaufsinfosatz>();
    private List<IBestellung> bestellungList = new ArrayList<IBestellung>();


    public Produkt(int produktNummer, String name, int lagerbestand, Orderbuch orderbuch, List<IWarenausgangsmeldung> warenausgangsmeldungList, List<IAngebot> angebotList, List<IEinkaufsinfosatz> einkaufsinfosatzList, List<IBestellung> bestellungList) {
        this.produktNummer = produktNummer;
        this.name = name;
        this.lagerbestand = lagerbestand;
        this.orderbuch = orderbuch;
        this.warenausgangsmeldungList = warenausgangsmeldungList;
        this.angebotList = angebotList;
        this.einkaufsinfosatzList = einkaufsinfosatzList;
        this.bestellungList = bestellungList;
    }

    public Produkt(int produktNummer, String name, int lagerbestand, Orderbuch orderbuch, List<IAngebot> angebotList, List<IEinkaufsinfosatz> einkaufsinfosatzList, List<IBestellung> bestellungList) {
        this.produktNummer = produktNummer;
        this.name = name;
        this.lagerbestand = lagerbestand;
        this.orderbuch = orderbuch;
        this.warenausgangsmeldungList = null;
        this.angebotList = angebotList;    // SICHER!?
        this.einkaufsinfosatzList = einkaufsinfosatzList;
        this.bestellungList = bestellungList;
    }

    public Produkt(int produktNummer, String name, int lagerbestand) {
        this.produktNummer = produktNummer;
        this.name = name;
        this.lagerbestand = lagerbestand;
        this.orderbuch = null;
        this.warenausgangsmeldungList = null;
        this.angebotList = null;
        this.einkaufsinfosatzList = null;
        this.bestellungList = null;
    }

    public Produkt() {
    }

    @Override
    public int getProduktNummer() {
        return produktNummer;
    }

    @Override
    public String getProduktName() {
        return name;
    }

    @Override
    public int getLagerbestand() {
        return lagerbestand;
    }

    @Override
    public Orderbuch getOrderbuch() {
        return orderbuch;
    }

    @Override
    public List<IWarenausgangsmeldung> getWarenausgangsmeldungList() {
        return warenausgangsmeldungList;
    }

    @Override
    public List<IAngebot> getAngebotList() {
        return angebotList;
    }

    @Override
    public List<IEinkaufsinfosatz> getEinkaufsinfosatzList() {
        return einkaufsinfosatzList;
    }

    @Override
    public List<IBestellung> getBestellungList() {
        return bestellungList;
    }

    @Override
    public void putWarenausgangsmeldungToList(IWarenausgangsmeldung warenausgangsmeldung) {
        warenausgangsmeldungList.add(warenausgangsmeldung);
    }

    @Override
    public void putAngebotToList(IAngebot angebot) {
        angebotList.add(angebot);
    }

    @Override
    public void putEinkaufsinfosatzToList(IEinkaufsinfosatz einkaufsinfosatz) {
        einkaufsinfosatzList.add(einkaufsinfosatz);
    }

    @Override
    public void putBestellung(IBestellung bestellung) {
        bestellungList.add(bestellung);
    }


}
