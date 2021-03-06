package classes;

import interfaces.IAngebot;
import interfaces.IAuftrag;
import interfaces.IKunde;
import interfaces.IProdukt;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "ANGEBOT")
public class Angebot implements IAngebot, Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int angebotsNummer;
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date gueltigAb;
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date gueltigBis;
    @Column(nullable = false)
    private float gesamtPreis;

    @ManyToOne(targetEntity = Kunde.class)
    @JoinColumn(name = "KUNDE")
    private IKunde kunde;

    @OneToOne(targetEntity = Auftrag.class)
    @JoinColumn(name = "AUFTRAG")
    private IAuftrag auftrag;

    @ManyToOne(targetEntity = Produkt.class)
    @JoinColumn(name = "PRODUKTMENGEMAP")
    private Map<IProdukt, Integer> produktMengeMap;

    public Angebot(Date gueltigAb, float gesamtPreis, Date gueltigBis, IKunde kunde, IAuftrag auftrag, Map<IProdukt, Integer> produktMengeMap) {

        this.gueltigAb = gueltigAb;
        this.gesamtPreis = gesamtPreis;
        this.gueltigBis = gueltigBis;
        this.kunde = kunde;
        this.auftrag = auftrag;
        this.produktMengeMap = produktMengeMap;
    }

    public Angebot(Date gueltigAb, Date gueltigBis, float gesamtPreis, IKunde kunde) {
        this(gueltigAb, gesamtPreis, gueltigBis, kunde, null, null);
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

    @Override
    public String toString() {
        return "Angebot{" +
                "angebotsNummer=" + angebotsNummer +
                ", gueltigAb=" + gueltigAb +
                ", gueltigBis=" + gueltigBis +
                ", gesamtPreis=" + gesamtPreis +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Angebot)) return false;

        Angebot angebot = (Angebot) o;

        if (angebotsNummer != angebot.angebotsNummer) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return angebotsNummer;
    }
}
