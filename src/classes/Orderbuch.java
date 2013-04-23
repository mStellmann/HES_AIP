package classes;

import interfaces.IOrderbuch;
import interfaces.IOrderbuchsatz;
import interfaces.IProdukt;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Orderbuch implements IOrderbuch {
    private IProdukt produkt;
    private List<IOrderbuchsatz> orderbuchsatzList;

    public Orderbuch(IProdukt produkt){
        this.produkt = produkt;
        this.orderbuchsatzList = new ArrayList<IOrderbuchsatz>();

    }
                      //  this.orderbuchsatzList = new ArrayList<IOrderbuchsatz>(); ??? hier auch noch rein  ???
    public Orderbuch(){

    }

    public IProdukt getProdukt() {
        return produkt;
    }

    public void setProdukt(IProdukt produkt) {
        this.produkt = produkt;
    }

    public List<IOrderbuchsatz> getOrderbuchsatzList() {
        return orderbuchsatzList;
    }

    public void setOrderbuchsatzList(List<IOrderbuchsatz> orderbuchsatzList) {
        this.orderbuchsatzList = orderbuchsatzList;
    }
}
