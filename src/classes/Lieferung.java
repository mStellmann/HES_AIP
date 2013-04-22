package classes;

import interfaces.ILieferung;
import interfaces.ITransportauftrag;

/**
 *
 */
public class Lieferung implements ILieferung {
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

    public void setLieferungsNummer(int lieferungsNummer) {
        this.lieferungsNummer = lieferungsNummer;
    }
}
