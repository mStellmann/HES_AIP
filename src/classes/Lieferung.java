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
        this(lieferungsNummer, null);
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

    @Override
    public String toString() {
        return "Lieferung{" +
                "lieferungsNummer=" + lieferungsNummer +
                ", transportauftrag=" + transportauftrag +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lieferung)) return false;

        Lieferung lieferung = (Lieferung) o;

        if (lieferungsNummer != lieferung.lieferungsNummer) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return lieferungsNummer;
    }
}
