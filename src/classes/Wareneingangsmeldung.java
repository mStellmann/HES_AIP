package classes;

import interfaces.IProdukt;
import interfaces.IWareneingangsmeldung;

import java.util.Date;

/**
 *
 */
public class Wareneingangsmeldung implements IWareneingangsmeldung {
    private Date datum;
    private int menge;
    private int bestellNr;

    private IProdukt produkt;

    public Wareneingangsmeldung(int bestellNr, Date datum) {
        this.datum = datum;
        this.bestellNr = bestellNr;
    }
}
