package classes;

import interfaces.IAngebot;
import interfaces.IAuftrag;
import interfaces.IKunde;
import interfaces.IProdukt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Angebot implements IAngebot {
    private int angebotsNummer;
    private Date gueltigAb;
    private Date gueltigBis;
    private float gesamtPreis;

    private IKunde kunde;
    private IAuftrag auftrag;
    private Map<IProdukt, Integer> produktMengeMap;

    public Angebot(int angebotsNummer, Date gueltigAb, float gesamtPreis, Date gueltigBis, IKunde kunde, IAuftrag auftrag, Map<IProdukt, Integer> produktMengeMap) {
        this.angebotsNummer = angebotsNummer;
        this.gueltigAb = gueltigAb;
        this.gesamtPreis = gesamtPreis;
        this.gueltigBis = gueltigBis;
        this.kunde = kunde;
        this.auftrag = auftrag;
        this.produktMengeMap = produktMengeMap;
    }

    public Angebot(int angebotsNummer, Date gueltigAb, Date gueltigBis, IKunde kunde) {
        this(angebotsNummer, gueltigAb, 0f, gueltigBis, kunde, null, new HashMap<IProdukt, Integer>());
    }

    public Angebot() {
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

    public void setGesamtPreis(float gesamtPreis) {
        this.gesamtPreis = gesamtPreis;
    }

    public IKunde getKunde() {
        return kunde;
    }

    public void setKunde(IKunde kunde) {
        this.kunde = kunde;
    }

    public IAuftrag getAuftrag() {
        return auftrag;
    }

    public void setAuftrag(IAuftrag auftrag) {
        this.auftrag = auftrag;
    }

    public Map<IProdukt, Integer> getProduktMengeMap() {
        return produktMengeMap;
    }

    public void setProduktMengeMap(Map<IProdukt, Integer> produktMengeMap) {
        this.produktMengeMap = produktMengeMap;
    }

    @Override
    public int getAngebotsNummer() {
        return angebotsNummer;
    }

    @Override
    public void addProduktMenge(IProdukt produkt, int menge) {
        produktMengeMap.put(produkt, menge);
//        gesamtPreis += produkt.      todo preisberechnung
    }

    public void setAngebotsNummer(int angebotsNummer) {
        this.angebotsNummer = angebotsNummer;
    }

    public void setGueltigAb(Date gueltigAb) {
        this.gueltigAb = gueltigAb;
    }

    public void setGueltigBis(Date gueltigBis) {
        this.gueltigBis = gueltigBis;
    }


}
