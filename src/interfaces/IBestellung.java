package interfaces;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: aaz527
 * Date: 19.04.13
 * Time: 12:38
 * To change this template use File | Settings | File Templates.
 */
public interface IBestellung {

    int getBestellungsNummer();

    Date getBestelldatum();

    int getMenge();

    void setMenge(int menge);

    boolean isFreigabe();

    void setFreigabe(boolean freigabe);

    IWareneingangsmeldung getWareneingangsmeldung();

    IProdukt getProdukt();

    ILieferant getLieferant();

    void setLieferant(ILieferant lieferant);
}
