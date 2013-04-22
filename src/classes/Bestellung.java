package classes;

import interfaces.IBestellung;
import interfaces.ILieferant;
import interfaces.IProdukt;
import interfaces.IWareneingangsmeldung;

import java.util.Date;

/**
 *
 */
public class Bestellung implements IBestellung {
    private int bestellungsNummer;
    private Date bestelldatum;
    private int menge;
    private boolean freigabe;

    private IWareneingangsmeldung wareneingangsmeldung;
    private IProdukt produkt;
    private ILieferant lieferant;
}
