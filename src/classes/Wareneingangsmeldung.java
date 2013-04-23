package classes;

import interfaces.IBestellung;
import interfaces.IProdukt;
import interfaces.IWareneingangsmeldung;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class Wareneingangsmeldung implements IWareneingangsmeldung, Serializable {
    private Date datum;
    //private int menge;
    private int bestellNr;

    private IBestellung bestellung;

    public Wareneingangsmeldung(int bestellNr, Date datum, IBestellung bestellung) {
        this.bestellung = bestellung;
        this.datum = datum;
        this.bestellNr = bestellNr;
    }

    public Wareneingangsmeldung() {

    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getBestellNr() {
        return bestellNr;
    }

    public void setBestellNr(int bestellNr) {
        this.bestellNr = bestellNr;
    }

    public IBestellung getBestellung() {
        return bestellung;
    }

    public void setBestellung(IBestellung bestellung) {
        this.bestellung = bestellung;
    }

    @Override
    public String toString() {
        return "Wareneingangsmeldung{" +
                "datum=" + datum +
                ", bestellNr=" + bestellNr +
                ", bestellung=" + bestellung +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wareneingangsmeldung)) return false;

        Wareneingangsmeldung that = (Wareneingangsmeldung) o;

        if (bestellNr != that.bestellNr) return false;
        if (!bestellung.equals(that.bestellung)) return false;
        if (!datum.equals(that.datum)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = datum.hashCode();
        result = 31 * result + bestellNr;
        result = 31 * result + bestellung.hashCode();
        return result;
    }
}
