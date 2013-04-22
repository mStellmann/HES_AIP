package typClasses;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 12:44
 * To change this template use File | Settings | File Templates.
 */
public class RechnungTyp {
    private final int rechnungsNummer;
    private final Date rechnungsDatum;
    private final boolean istBezahlt;

    private final List<ZahlungseingangTyp> zahlungseingangList;
    private final AuftragTyp auftrag;

    public RechnungTyp(int rechnungsNummer, Date rechnungsDatum, boolean istBezahlt, List<ZahlungseingangTyp> zahlungseingangList, AuftragTyp auftrag) {
        this.rechnungsNummer = rechnungsNummer;
        this.rechnungsDatum = rechnungsDatum;
        this.istBezahlt = istBezahlt;
        this.zahlungseingangList = zahlungseingangList;
        this.auftrag = auftrag;
    }

    public int getRechnungsNummer() {
        return rechnungsNummer;
    }

    public Date getRechnungsDatum() {
        return rechnungsDatum;
    }

    public boolean isIstBezahlt() {
        return istBezahlt;
    }

    public List<ZahlungseingangTyp> getZahlungseingangList() {
        return zahlungseingangList;
    }

    public AuftragTyp getAuftrag() {
        return auftrag;
    }
}
