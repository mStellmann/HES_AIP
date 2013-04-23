package classes;

import interfaces.IBestellung;
import interfaces.IProdukt;
import interfaces.IWarenausgangsmeldung;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class Warenausgangsmeldung implements IWarenausgangsmeldung, Serializable {
    // private int lieferschein; // idnummer vom lieferschein (bar-code)
    private Date datum;
    private int menge;

    private IProdukt produkt;

    public Warenausgangsmeldung(int menge, Date datum, IProdukt produkt) {
        this.produkt = produkt;
        this.datum = datum;
        this.menge = menge;
    }

    public Warenausgangsmeldung() {

    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public IProdukt getProdukt() {
        return produkt;
    }

    public void setProdukt(IProdukt produkt) {
        this.produkt = produkt;
    }

    @Override
    public String toString() {
        return "Warenausgangsmeldung{" +
                "datum=" + datum +
                ", menge=" + menge +
                ", produkt=" + produkt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Warenausgangsmeldung)) return false;

        Warenausgangsmeldung that = (Warenausgangsmeldung) o;

        if (menge != that.menge) return false;
        if (!datum.equals(that.datum)) return false;
        if (!produkt.equals(that.produkt)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = datum.hashCode();
        result = 31 * result + menge;
        result = 31 * result + produkt.hashCode();
        return result;
    }
}
