package classes;

import interfaces.IAuftrag;
import interfaces.ILieferung;
import interfaces.ITransportauftrag;

import javax.persistence.*;

import java.io.Serializable;

/**
 *
 */
@Entity
@Table(name = "LIEFERUNG")
public class Lieferung implements ILieferung, Serializable {
    @Id
    @GeneratedValue
    private int lieferungsNummer;

    @OneToOne(targetEntity = Transportauftrag.class)
    @JoinColumn(name = "TRANSPORTAUFTRAG")
    private ITransportauftrag transportauftrag;

    @OneToOne(targetEntity = Auftrag.class)
    @JoinColumn(name = "AUFTRAG")
    private IAuftrag auftrag;


    public Lieferung(ITransportauftrag transportauftrag) {
        this.transportauftrag = transportauftrag;
    }


    public Lieferung() {
    }

    public IAuftrag getAuftrag() {
        return auftrag;
    }

    public void setAuftrag(IAuftrag auftrag) {
        this.auftrag = auftrag;
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
