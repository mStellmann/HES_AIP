package classes;

import interfaces.IAuftrag;
import interfaces.IRechnung;
import interfaces.IZahlungseingang;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class Rechnung implements IRechnung {
    private int rechnungsNummer;
    private Date rechnungsDatum;
    private boolean istBezahlt = false;

    private List<IZahlungseingang> zahlungseingangList;
    private IAuftrag auftrag;

    public Rechnung(int rechnungsNummer, Date rechnungsDatum, List<IZahlungseingang> zahlungseingangList, IAuftrag auftrag) {
        this.rechnungsNummer = rechnungsNummer;
        this.rechnungsDatum = rechnungsDatum;
        this.zahlungseingangList = zahlungseingangList;
        this.auftrag = auftrag;
    }

    public Rechnung(int rechnungsNummer, Date rechnungsDatum) {
        this(rechnungsNummer, rechnungsDatum, new ArrayList<IZahlungseingang>(), null);
    }

    public Rechnung() {
    }

    public int getRechnungsNummer() {
        return rechnungsNummer;
    }

    public void setRechnungsNummer(int rechnungsNummer) {
        this.rechnungsNummer = rechnungsNummer;
    }

    public Date getRechnungsDatum() {
        return rechnungsDatum;
    }

    public void setRechnungsDatum(Date rechnungsDatum) {
        this.rechnungsDatum = rechnungsDatum;
    }

    public boolean isIstBezahlt() {
        return istBezahlt;
    }

    public void setIstBezahlt(boolean istBezahlt) {
        this.istBezahlt = istBezahlt;
    }

    public List<IZahlungseingang> getZahlungseingangList() {
        return zahlungseingangList;
    }

    public void setZahlungseingangList(List<IZahlungseingang> zahlungseingangList) {
        this.zahlungseingangList = zahlungseingangList;
    }

    public IAuftrag getAuftrag() {
        return auftrag;
    }

    public void setAuftrag(IAuftrag auftrag) {
        this.auftrag = auftrag;
    }
}
