package classes;

import interfaces.IOrderbuch;
import interfaces.IOrderbuchsatz;
import interfaces.IProdukt;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Entity
@Table(name = "Orderbuch")
public class Orderbuch implements IOrderbuch, Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    @OneToOne
    @JoinColumn(name = "produkt")
    private IProdukt produkt;
    @OneToMany(mappedBy = "Orderbuch")
    private List<IOrderbuchsatz> orderbuchsatzList;

    public Orderbuch(IProdukt produkt) {
        this.produkt = produkt;
        this.orderbuchsatzList = new ArrayList<IOrderbuchsatz>();

    }

    //  this.orderbuchsatzList = new ArrayList<IOrderbuchsatz>(); ??? hier auch noch rein  ???
    public Orderbuch() {

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

    @Override
    public String toString() {
        return "Orderbuch{" +
                "produkt=" + produkt +
                ", orderbuchsatzList=" + orderbuchsatzList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orderbuch)) return false;

        Orderbuch orderbuch = (Orderbuch) o;

        if (!produkt.equals(orderbuch.produkt)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return produkt.hashCode();
    }
}
