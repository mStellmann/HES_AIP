package classes;

import interfaces.IOrderbuch;
import interfaces.IOrderbuchsatz;
import interfaces.IProdukt;

import java.util.List;

/**
 *
 */
public class Orderbuch implements IOrderbuch {
    private IProdukt produkt;
    private List<IOrderbuchsatz> orderbuchsatzList;
}
