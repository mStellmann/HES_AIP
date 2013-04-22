package classes;

import interfaces.ILieferung;
import interfaces.ITransportauftrag;

import java.io.Serializable;

/**
 *
 */
public class Lieferung implements ILieferung, Serializable {
    private int lieferungsNummer;

    private ITransportauftrag transportauftrag;

    public Lieferung(int lieferungsNummer, ITransportauftrag transportauftrag) {
        this.lieferungsNummer = lieferungsNummer;
        this.transportauftrag = transportauftrag;
    }

    public Lieferung(int lieferungsNummer) {
        this.lieferungsNummer = lieferungsNummer;
    }

    public Lieferung() {
    }

    public int getLieferungsNummer() {
        return lieferungsNummer;
    }

    public ITransportauftrag getTransportauftrag() {
        return transportauftrag;
    }

    public void setTransportauftrag(ITransportauftrag transportauftrag) {
        this.transportauftrag = transportauftrag;
    }

    public void setLieferungsNummer(int lieferungsNummer) {
        this.lieferungsNummer = lieferungsNummer;
    }
}
