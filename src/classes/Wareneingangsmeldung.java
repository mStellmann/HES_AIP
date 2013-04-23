package classes;

import interfaces.IBestellung;
import interfaces.IProdukt;
import interfaces.IWareneingangsmeldung;

import java.util.Date;

/**
 *
 */
public class Wareneingangsmeldung implements IWareneingangsmeldung {
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
}
