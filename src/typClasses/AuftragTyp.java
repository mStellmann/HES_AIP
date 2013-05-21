package typClasses;

import interfaces.IAuftrag;

import java.util.Date;

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

    public AuftragTyp(int auftragsNummer, Date beauftragtAm, AngebotTyp angebot) {
        this(auftragsNummer, false, beauftragtAm, angebot, null, null);
    }

    public AuftragTyp(IAuftrag auftrag) {
        this(auftrag.getAuftragsNummer(), false, auftrag.getBeauftragtAm(), new AngebotTyp(auftrag.getAngebot()), null, null);
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

