package typClasses;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 12:43
 * To change this template use File | Settings | File Templates.
 */
public class LieferungTyp implements Serializable {
    private final int lieferungsNummer;

    private final TransportauftragTyp transportauftrag;

    public LieferungTyp(TransportauftragTyp transportauftrag, int lieferungsNummer) {
        this.transportauftrag = transportauftrag;
        this.lieferungsNummer = lieferungsNummer;
    }

    public int getLieferungsNummer() {
        return lieferungsNummer;
    }

    public TransportauftragTyp getTransportauftrag() {
        return transportauftrag;
    }
}
