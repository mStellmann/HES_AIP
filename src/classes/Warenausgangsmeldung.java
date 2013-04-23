package classes;

import interfaces.IBestellung;
import interfaces.IProdukt;
import interfaces.IWarenausgangsmeldung;

import java.util.Date;

/**
 *
 */
public class Warenausgangsmeldung implements IWarenausgangsmeldung {
   // private int lieferschein; // idnummer vom lieferschein (bar-code)
    private Date datum;
    private  int menge;

    private IProdukt produkt;

    public Warenausgangsmeldung(int menge, Date datum, IProdukt produkt){
        this.produkt = produkt;
        this.datum = datum;
        this.menge = menge;
    }

    public Warenausgangsmeldung(){

    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public IProdukt getProdukt() {
        return produkt;
    }

    public void setProdukt(IProdukt produkt) {
        this.produkt = produkt;
    }
}
