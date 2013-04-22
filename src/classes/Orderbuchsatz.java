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
}
