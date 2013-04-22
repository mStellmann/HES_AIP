package interfaces;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: aaz527
 * Date: 19.04.13
 * Time: 12:45
 * To change this template use File | Settings | File Templates.
 */
public interface ITransportauftrag {
    int getTransportauftragsNummer();

    Date getAusgangsdatum();

    boolean isLieferungErfolgt();

    void setLieferungErfolgt(boolean lieferungErfolgt);

    Date getLieferdatum();

    void setLieferdatum(Date lieferdatum);

    String getTransportdienstleister();

    ILieferung getLieferung();

    void setLieferung(ILieferung lieferung);
}
