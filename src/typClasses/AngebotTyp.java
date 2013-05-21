package typClasses;

import interfaces.IAngebot;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 12:40
 * To change this template use File | Settings | File Templates.
 */
public class AngebotTyp implements Serializable {
    private final int angebotsNummer;
    private final Date gueltigAb;
    private final Date gueltigBis;
    private final float gesamtPreis;

    private final KundeTyp kunde;
    private final AuftragTyp auftrag;
    private final Map<ProduktTyp, Integer> produktMengeMap;

    public AngebotTyp(int angebotsNummer, Date gueltigAb, Date gueltigBis, float gesamtPreis, KundeTyp kunde, AuftragTyp auftrag, Map<ProduktTyp, Integer> produktMengeMap) {
        this.angebotsNummer = angebotsNummer;
        this.gueltigAb = gueltigAb;
        this.gueltigBis = gueltigBis;
        this.gesamtPreis = gesamtPreis;
        this.kunde = kunde;
        this.auftrag = auftrag;
        this.produktMengeMap = produktMengeMap;
    }

    public AngebotTyp(int angebotsNummer, Date gueltigAb, Date gueltigBis, float gesamtPreis, KundeTyp kunde) {
        this(angebotsNummer, gueltigAb, gueltigBis, gesamtPreis, kunde, null, null);
    }

    public AngebotTyp(IAngebot angebot) {
        this(angebot.getAngebotsNummer(), angebot.getGueltigAb(), angebot.getGueltigBis(), angebot.getGesamtPreis(), new KundeTyp(angebot.getKunde()));
    }

    public int getAngebotsNummer() {
        return angebotsNummer;
    }

    public Date getGueltigAb() {
        return gueltigAb;
    }

    public Date getGueltigBis() {
        return gueltigBis;
    }

    public float getGesamtPreis() {
        return gesamtPreis;
    }

    public KundeTyp getKunde() {
        return kunde;
    }

    public AuftragTyp getAuftrag() {
        return auftrag;
    }

    public Map<ProduktTyp, Integer> getProduktMengeMap() {
        return produktMengeMap;
    }
}
