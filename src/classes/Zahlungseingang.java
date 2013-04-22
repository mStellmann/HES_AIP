package classes;

import interfaces.IRechnung;
import interfaces.IZahlungseingang;

import java.util.Date;

/**
 *
 */
public class Zahlungseingang implements IZahlungseingang {
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
}
