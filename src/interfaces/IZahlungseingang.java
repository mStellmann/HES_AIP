package interfaces;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: aaz527
 * Date: 19.04.13
 * Time: 12:47
 * To change this template use File | Settings | File Templates.
 */
public interface IZahlungseingang {
    Date getEingangsdatum();

    float getBetrag();

    IRechnung getRechnung();

    void setRechnung(IRechnung rechnung);
}
