package typClasses;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 12:46
 * To change this template use File | Settings | File Templates.
 */
public class ZahlungseingangTyp implements Serializable {
    private final Date eingangsdatum;
    private final float betrag;

    private final RechnungTyp rechnung;

    public ZahlungseingangTyp(Date eingangsdatum, float betrag, RechnungTyp rechnung) {
        this.eingangsdatum = eingangsdatum;
        this.betrag = betrag;
        this.rechnung = rechnung;
    }

    public Date getEingangsdatum() {
        return eingangsdatum;
    }

    public float getBetrag() {
        return betrag;
    }

    public RechnungTyp getRechnung() {
        return rechnung;
    }
}
