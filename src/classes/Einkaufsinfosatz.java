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
}
