package typClasses;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 12:40
 * To change this template use File | Settings | File Templates.
 */
public class AuftragTyp {
    private final int auftragsNummer;
    private final boolean istAbgeschlossen;
    private final Date beauftragtAm;

    private final AngebotTyp angebot;
    private final LieferungTyp lieferung;
    private final RechnungTyp rechnung;

    public AuftragTyp(int auftragsNummer, boolean istAbgeschlossen, Date beauftragtAm, AngebotTyp angebot, LieferungTyp lieferung, RechnungTyp rechnung) {
        this.auftragsNummer = auftragsNummer;
        this.istAbgeschlossen = istAbgeschlossen;
        this.beauftragtAm = beauftragtAm;
        this.angebot = angebot;
        this.lieferung = lieferung;
        this.rechnung = rechnung;
    }

    public int getAuftragsNummer() {
        return auftragsNummer;
    }

    public boolean isIstAbgeschlossen() {
        return istAbgeschlossen;
    }

    public Date getBeauftragtAm() {
        return beauftragtAm;
    }

    public AngebotTyp getAngebot() {
        return angebot;
    }

    public LieferungTyp getLieferung() {
        return lieferung;
    }

    public RechnungTyp getRechnung() {
        return rechnung;
    }
}

