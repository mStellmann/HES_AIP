package classes;

import interfaces.ILieferant;
import interfaces.IOrderbuch;
import interfaces.IOrderbuchsatz;

import java.util.Date;

/**
 *
 */
public class Orderbuchsatz implements IOrderbuchsatz {
    private Date gueltigAb;
    private Date gueltigBis;

    private ILieferant lieferant;
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
}
