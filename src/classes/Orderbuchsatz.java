package classes;

import interfaces.ILieferant;
import interfaces.IOrderbuch;
import interfaces.IOrderbuchsatz;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 */

@Entity
@Table(name = "ORDERBUCHSATZ")
public class Orderbuchsatz implements IOrderbuchsatz, Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date gueltigAb;
    @Column(nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date gueltigBis;


    @ManyToOne(targetEntity = Lieferant.class)
    @JoinColumn(name = "LIEFERANT")
    private ILieferant lieferant;

    @ManyToOne(targetEntity = Orderbuch.class)
    @JoinColumn(name = "ORDERBUCH")
    private IOrderbuch orderbuch;


    public Orderbuchsatz(Date gueltigAb, Date gueltigBis, ILieferant lieferant, IOrderbuch orderbuch) {
        this.gueltigAb = gueltigAb;
        this.gueltigBis = gueltigBis;
        this.lieferant = lieferant;
        this.orderbuch = orderbuch;
    }

    public Orderbuchsatz() {

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

    public ILieferant getLieferant() {
        return lieferant;
    }

    public void setLieferant(ILieferant lieferant) {
        this.lieferant = lieferant;
    }

    public IOrderbuch getOrderbuch() {
        return orderbuch;
    }

    public void setOrderbuch(IOrderbuch orderbuch) {
        this.orderbuch = orderbuch;
    }

    @Override
    public String toString() {
        return "Orderbuchsatz{" +
                "gueltigAb=" + gueltigAb +
                ", gueltigBis=" + gueltigBis +
                ", lieferant=" + lieferant +
                ", orderbuch=" + orderbuch +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orderbuchsatz)) return false;

        Orderbuchsatz that = (Orderbuchsatz) o;

        if (!gueltigAb.equals(that.gueltigAb)) return false;
        if (!gueltigBis.equals(that.gueltigBis)) return false;
        if (!lieferant.equals(that.lieferant)) return false;
        if (!orderbuch.equals(that.orderbuch)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gueltigAb.hashCode();
        result = 31 * result + gueltigBis.hashCode();
        result = 31 * result + lieferant.hashCode();
        result = 31 * result + orderbuch.hashCode();
        return result;
    }
}
