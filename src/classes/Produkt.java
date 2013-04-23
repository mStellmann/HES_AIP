package classes;

import interfaces.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Entity
@Table(name = "Produkt")
public class Produkt implements IProdukt, Serializable {
    @Id
    @GeneratedValue
    private int produktNummer;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int lagerbestand;
    @OneToOne //(mappedBy = "Produkt")
    private Orderbuch orderbuch;
    @OneToMany(mappedBy = "Produkt")
    private List<IWarenausgangsmeldung> warenausgangsmeldungList;
    @OneToMany(mappedBy = "Produkt")
    private List<IEinkaufsinfosatz> einkaufsinfosatzList;
    @OneToMany(mappedBy = "Produkt")
    private List<IBestellung> bestellungList;
    @ManyToMany //(mappedBy = "Produkt")
    private List<IAngebot> angebotList;


    public Produkt(String name, int lagerbestand, Orderbuch orderbuch, List<IWarenausgangsmeldung> warenausgangsmeldungList, List<IAngebot> angebotList, List<IEinkaufsinfosatz> einkaufsinfosatzList, List<IBestellung> bestellungList) {
        this.produktNummer = produktNummer;
        this.name = name;
        this.lagerbestand = lagerbestand;
        this.orderbuch = orderbuch;
        this.warenausgangsmeldungList = warenausgangsmeldungList;
        this.angebotList = angebotList;
        this.einkaufsinfosatzList = einkaufsinfosatzList;
        this.bestellungList = bestellungList;
    }

    public Produkt(String name, int lagerbestand, Orderbuch orderbuch, List<IAngebot> angebotList, List<IEinkaufsinfosatz> einkaufsinfosatzList, List<IBestellung> bestellungList) {
        this.produktNummer = produktNummer;
        this.name = name;
        this.lagerbestand = lagerbestand;
        this.orderbuch = orderbuch;
        this.warenausgangsmeldungList = null;
        this.angebotList = angebotList;    // SICHER!?
        this.einkaufsinfosatzList = einkaufsinfosatzList;
        this.bestellungList = bestellungList;
    }

    public Produkt( String name, int lagerbestand) {
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

    @Override
    public String toString() {
        return "Produkt{" +
                "produktNummer=" + produktNummer +
                ", name='" + name + '\'' +
                ", lagerbestand=" + lagerbestand +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produkt)) return false;

        Produkt produkt = (Produkt) o;

        if (produktNummer != produkt.produktNummer) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return produktNummer;
    }
}
