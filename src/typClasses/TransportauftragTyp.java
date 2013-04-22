package typClasses;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 12:45
 * To change this template use File | Settings | File Templates.
 */
public class TransportauftragTyp {
    private final int transportauftragsNummer;
    private final Date ausgangsdatum;
    private final boolean lieferungErfolgt;
    private final Date lieferdatum;
    private final String transportdienstleister;

    private LieferungTyp lieferung;

    public TransportauftragTyp(int transportauftragsNummer, Date ausgangsdatum, boolean lieferungErfolgt, Date lieferdatum, String transportdienstleister, LieferungTyp lieferung) {
        this.transportauftragsNummer = transportauftragsNummer;
        this.ausgangsdatum = ausgangsdatum;
        this.lieferungErfolgt = lieferungErfolgt;
        this.lieferdatum = lieferdatum;
        this.transportdienstleister = transportdienstleister;
        this.lieferung = lieferung;
    }

    public int getTransportauftragsNummer() {
        return transportauftragsNummer;
    }

    public Date getAusgangsdatum() {
        return ausgangsdatum;
    }

    public boolean isLieferungErfolgt() {
        return lieferungErfolgt;
    }

    public Date getLieferdatum() {
        return lieferdatum;
    }

    public String getTransportdienstleister() {
        return transportdienstleister;
    }

    public LieferungTyp getLieferung() {
        return lieferung;
    }
}
