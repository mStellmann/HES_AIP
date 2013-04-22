package classes;

import interfaces.ILieferung;
import interfaces.ITransportauftrag;

import java.util.Date;
import java.util.Objects;

/**
 *
 */
public class Transportauftrag implements ITransportauftrag {
    private int transportauftragsNummer;
    private Date ausgangsdatum;
    private boolean lieferungErfolgt = false;
    private Date lieferdatum;
    private String transportdienstleister;

    private ILieferung lieferung;

    public Transportauftrag(int transportauftragsNummer, Date ausgangsdatum, String transportdienstleister) {
        this.transportauftragsNummer = transportauftragsNummer;
        this.ausgangsdatum = ausgangsdatum;
        this.transportdienstleister = transportdienstleister;
    }

    public Transportauftrag() {
    }

    public int getTransportauftragsNummer() {
        return transportauftragsNummer;
    }

    public void setTransportauftragsNummer(int transportauftragsNummer) {
        this.transportauftragsNummer = transportauftragsNummer;
    }

    public Date getAusgangsdatum() {
        return ausgangsdatum;
    }

    public void setAusgangsdatum(Date ausgangsdatum) {
        this.ausgangsdatum = ausgangsdatum;
    }

    public boolean isLieferungErfolgt() {
        return lieferungErfolgt;
    }

    public void setLieferungErfolgt(boolean lieferungErfolgt) {
        this.lieferungErfolgt = lieferungErfolgt;
    }

    public Date getLieferdatum() {
        return lieferdatum;
    }

    public void setLieferdatum(Date lieferdatum) {
        this.lieferdatum = lieferdatum;
    }

    public String getTransportdienstleister() {
        return transportdienstleister;
    }

    public void setTransportdienstleister(String transportdienstleister) {
        this.transportdienstleister = transportdienstleister;
    }

    public ILieferung getLieferung() {
        return lieferung;
    }

    public void setLieferung(ILieferung lieferung) {
        this.lieferung = lieferung;
    }
}
