package classes;

import interfaces.IAuftrag;
import interfaces.IRechnung;
import interfaces.IZahlungseingang;

import java.util.Date;
import java.util.List;

/**
 *
 */
public class Rechnung implements IRechnung {
    private int rechnungsNummer;
    private Date rechnungsDatum;
    private boolean istBezahlt;

    private List<IZahlungseingang> zahlungseingangList;
    private IAuftrag auftrag;
}
