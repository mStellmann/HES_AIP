package classes;

import interfaces.IEinkaufsinfosatz;
import interfaces.ILieferant;
import interfaces.IProdukt;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 */
@Entity
@Table(name = "Einkaufsinfosatz")
public class Einkaufsinfosatz implements IEinkaufsinfosatz, Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date gueltigAb;
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date gueltigBis;
    @Column(nullable = false)
    private int planlieferzeit; // in int => anzahl tage
    @Column(nullable = false)
    private int normalmenge;
    @Column(nullable = false)
    private float preis;
    @ManyToOne
    @JoinColumn(name = "Lieferant")
    private ILieferant lieferant;
    @ManyToOne
    @JoinColumn(name = "Produkt")
    private IProdukt produkt;

    public Einkaufsinfosatz(Date gueltigAb, Date gueltigBis, int planlieferzeit, int normalmenge, float preis) {
        this.gueltigAb = gueltigAb;
        this.gueltigBis = gueltigBis;
        this.planlieferzeit = planlieferzeit;
        this.normalmenge = normalmenge;
        this.preis = preis;
    }

    public Einkaufsinfosatz() {

    }

    public Date getGueltigAb() {
        return gueltigAb;
    }

    public void setGueltigAb(Date gueltigAb) {
        this.gueltigAb = gueltigAb;
    }

    public Date getGueltigBis() {
        return gueltigBis;
    }

    public void setGueltigBis(Date gueltigBis) {
        this.gueltigBis = gueltigBis;
    }

    public int getPlanlieferzeit() {
        return planlieferzeit;
    }

    public void setPlanlieferzeit(int planlieferzeit) {
        this.planlieferzeit = planlieferzeit;
    }

    public int getNormalmenge() {
        return normalmenge;
    }

    public void setNormalmenge(int normalmenge) {
        this.normalmenge = normalmenge;
    }

    public float getPreis() {
        return preis;
    }

    public void setPreis(float preis) {
        this.preis = preis;
    }

    public IProdukt getProdukt() {
        return produkt;
    }

    public void setProdukt(IProdukt produkt) {
        this.produkt = produkt;
    }

    @Override
    public String toString() {
        return "Einkaufsinfosatz{" +
                "gueltigAb=" + gueltigAb +
                ", gueltigBis=" + gueltigBis +
                ", planlieferzeit=" + planlieferzeit +
                ", normalmenge=" + normalmenge +
                ", preis=" + preis +
                ", produkt=" + produkt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Einkaufsinfosatz)) return false;

        Einkaufsinfosatz that = (Einkaufsinfosatz) o;

        if (!gueltigAb.equals(that.gueltigAb)) return false;
        if (!gueltigBis.equals(that.gueltigBis)) return false;
        if (!produkt.equals(that.produkt)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gueltigAb.hashCode();
        result = 31 * result + gueltigBis.hashCode();
        result = 31 * result + produkt.hashCode();
        return result;
    }
}
