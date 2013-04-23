package classes;

import interfaces.ILieferung;
import interfaces.ITransportauftrag;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 */
public class Transportauftrag implements ITransportauftrag, Serializable {
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

    public Date getAusgangsdatum() {
        return ausgangsdatum;
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

    public ILieferung getLieferung() {
        return lieferung;
    }

    public void setLieferung(ILieferung lieferung) {
        this.lieferung = lieferung;
    }

    public void setTransportauftragsNummer(int transportauftragsNummer) {
        this.transportauftragsNummer = transportauftragsNummer;
    }

    public void setAusgangsdatum(Date ausgangsdatum) {
        this.ausgangsdatum = ausgangsdatum;
    }

    public void setTransportdienstleister(String transportdienstleister) {
        this.transportdienstleister = transportdienstleister;
    }

    @Override
    public String toString() {
        return "Transportauftrag{" +
                "transportauftragsNummer=" + transportauftragsNummer +
                ", ausgangsdatum=" + ausgangsdatum +
                ", lieferungErfolgt=" + lieferungErfolgt +
                ", lieferdatum=" + lieferdatum +
                ", transportdienstleister='" + transportdienstleister + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transportauftrag)) return false;

        Transportauftrag that = (Transportauftrag) o;

        if (transportauftragsNummer != that.transportauftragsNummer) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return transportauftragsNummer;
    }
}
