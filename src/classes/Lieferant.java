package classes;

import interfaces.IBestellung;
import interfaces.IEinkaufsinfosatz;
import interfaces.ILieferant;
import interfaces.IOrderbuchsatz;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public class Lieferant implements ILieferant, Serializable {
    private int lieferantenNummer;
    private String name;
    private String adresse;
    private String kontoverbindung;

    private List<IEinkaufsinfosatz> einkaufsinfosatzList;
    private List<IBestellung> bestellungList;
    private List<IOrderbuchsatz> orderbuchsatzList;

    public Lieferant(String name, String adresse, String kontoverbindung) {
        this.lieferantenNummer = lieferantenNummer;
        this.name = name;
        this.adresse = adresse;
        this.kontoverbindung = kontoverbindung;
    }

    public Lieferant(int lieferantenNummer, String name, String adresse, String kontoverbindung, List<IEinkaufsinfosatz> einkaufsinfosatzList, List<IBestellung> bestellungList, List<IOrderbuchsatz> orderbuchsatzList) {
        this.lieferantenNummer = lieferantenNummer;
        this.name = name;
        this.adresse = adresse;
        this.kontoverbindung = kontoverbindung;
        this.einkaufsinfosatzList = einkaufsinfosatzList;
        this.bestellungList = bestellungList;
        this.orderbuchsatzList = orderbuchsatzList;
    }

    public Lieferant() {
    }

    public int getLieferantenNummer() {
        return lieferantenNummer;
    }

    public void setLieferantenNummer(int lieferantenNummer) {
        this.lieferantenNummer = lieferantenNummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getKontoverbindung() {
        return kontoverbindung;
    }

    public void setKontoverbindung(String kontoverbindung) {
        this.kontoverbindung = kontoverbindung;
    }

    public List<IEinkaufsinfosatz> getEinkaufsinfosatzList() {
        return einkaufsinfosatzList;
    }

    public void setEinkaufsinfosatzList(List<IEinkaufsinfosatz> einkaufsinfosatzList) {
        this.einkaufsinfosatzList = einkaufsinfosatzList;
    }

    public List<IBestellung> getBestellungList() {
        return bestellungList;
    }

    public void setBestellungList(List<IBestellung> bestellungList) {
        this.bestellungList = bestellungList;
    }

    public List<IOrderbuchsatz> getOrderbuchsatzList() {
        return orderbuchsatzList;
    }

    public void setOrderbuchsatzList(List<IOrderbuchsatz> orderbuchsatzList) {
        this.orderbuchsatzList = orderbuchsatzList;
    }

    @Override
    public String toString() {
        return "Lieferant{" +
                "lieferantenNummer=" + lieferantenNummer +
                ", name='" + name + '\'' +
                ", adresse='" + adresse + '\'' +
                ", kontoverbindung='" + kontoverbindung + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lieferant)) return false;

        Lieferant lieferant = (Lieferant) o;

        if (lieferantenNummer != lieferant.lieferantenNummer) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return lieferantenNummer;
    }
}
