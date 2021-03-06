package interfaces;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: aaz527
 * Date: 19.04.13
 * Time: 12:45
 * To change this template use File | Settings | File Templates.
 */
public interface IRechnung {
    int getRechnungsNummer();

    Date getRechnungsDatum();

    boolean isIstBezahlt();

    void setIstBezahlt(boolean istBezahlt);

    List<IZahlungseingang> getZahlungseingangList();

    void setZahlungseingangList(List<IZahlungseingang> zahlungseingangList);

    IAuftrag getAuftrag();

    void setAuftrag(IAuftrag auftrag);
}
