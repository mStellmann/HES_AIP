package interfaces;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: aaz527
 * Date: 19.04.13
 * Time: 12:38
 * To change this template use File | Settings | File Templates.
 */
public interface IAuftrag {
    int getAuftragsNummer();

    boolean isIstAbgeschlossen();

    void setIstAbgeschlossen(boolean istAbgeschlossen);

    Date getBeauftragtAm();

    IAngebot getAngebot();

    void setAngebot(IAngebot angebot);

    ILieferung getLieferung();

    void setLieferung(ILieferung lieferung);

    IRechnung getRechnung();

    void setRechnung(IRechnung rechnung);
}
