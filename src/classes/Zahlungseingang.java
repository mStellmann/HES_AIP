package classes;

import interfaces.IRechnung;
import interfaces.IZahlungseingang;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class Zahlungseingang implements IZahlungseingang, Serializable {
    private Date eingangsdatum;
    private float betrag;

    private IRechnung rechnung;

    public Zahlungseingang(Date eingangsdatum, float betrag) {
        this.eingangsdatum = eingangsdatum;
        this.betrag = betrag;
    }

    public Zahlungseingang() {
    }

    public Date getEingangsdatum() {
        return eingangsdatum;
    }

    public void setEingangsdatum(Date eingangsdatum) {
        this.eingangsdatum = eingangsdatum;
    }

    public float getBetrag() {
        return betrag;
    }

    public void setBetrag(float betrag) {
        this.betrag = betrag;
    }

    public IRechnung getRechnung() {
        return rechnung;
    }

    public void setRechnung(IRechnung rechnung) {
        this.rechnung = rechnung;
    }

    @Override
    public String toString() {
        return "Zahlungseingang{" +
                "eingangsdatum=" + eingangsdatum +
                ", betrag=" + betrag +
                ", rechnung=" + rechnung +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zahlungseingang)) return false;

        Zahlungseingang that = (Zahlungseingang) o;

        if (Float.compare(that.betrag, betrag) != 0) return false;
        if (!eingangsdatum.equals(that.eingangsdatum)) return false;
        if (!rechnung.equals(that.rechnung)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eingangsdatum.hashCode();
        result = 31 * result + (betrag != +0.0f ? Float.floatToIntBits(betrag) : 0);
        result = 31 * result + rechnung.hashCode();
        return result;
    }
}
