package classes;

import interfaces.IEinkaufsinfosatz;
import interfaces.IProdukt;

import java.util.Date;

/**
 *
 */
public class Einkaufsinfosatz implements IEinkaufsinfosatz {
    private Date gueltigAb;
    private Date gueltigBis;
    private int planlieferzeit; // in int => anzahl tage
    private int normalmenge;
    private float preis;

    private IProdukt produkt;

    public Einkaufsinfosatz(Date gueltigAb, Date gueltigBis, int planlieferzeit, int normalmenge, float preis){
        this.gueltigAb = gueltigAb;
        this.gueltigBis = gueltigBis;
        this.planlieferzeit = planlieferzeit;
        this.normalmenge = normalmenge;
        this.preis = preis;
    }

    public Einkaufsinfosatz(){

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
}
