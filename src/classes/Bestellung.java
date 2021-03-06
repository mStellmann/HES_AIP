package classes;

import interfaces.IBestellung;
import interfaces.ILieferant;
import interfaces.IProdukt;
import interfaces.IWareneingangsmeldung;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 */

@Entity
@Table(name = "BESTELLUNG")
public class Bestellung implements IBestellung, Serializable {

    @Id
    @GeneratedValue
    private int bestellungsNummer;
    @Column
    @Temporal(value = TemporalType.DATE)
    private Date bestelldatum;
    @Column
    private int menge;
    @Column(nullable = false)
    private boolean freigabe;


    @OneToOne(targetEntity = Wareneingangsmeldung.class)
    @JoinColumn(name = "WARENEINGANGSMELDUNG")
    private IWareneingangsmeldung wareneingangsmeldung;

    @ManyToOne(targetEntity = Produkt.class)
    @JoinColumn(name = "PRODUKT")
    private IProdukt produkt;

    @ManyToOne(targetEntity = Lieferant.class)
    @JoinColumn(name = "LIEFERANT")
    private ILieferant lieferant;

    public Bestellung(Date bestelldatum, int menge, boolean freigabe) {
        this.bestellungsNummer = bestellungsNummer;
        this.bestelldatum = bestelldatum;
        this.menge = menge;
        this.freigabe = freigabe;
    }

    public Bestellung() {

    }

    public int getBestellungsNummer() {
        return bestellungsNummer;
    }

    public void setBestellungsNummer(int bestellungsNummer) {
        this.bestellungsNummer = bestellungsNummer;
    }

    public Date getBestelldatum() {
        return bestelldatum;
    }

    public void setBestelldatum(Date bestelldatum) {
        this.bestelldatum = bestelldatum;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public boolean isFreigabe() {
        return freigabe;
    }

    public void setFreigabe(boolean freigabe) {
        this.freigabe = freigabe;
    }

    public IWareneingangsmeldung getWareneingangsmeldung() {
        return wareneingangsmeldung;
    }

    public void setWareneingangsmeldung(IWareneingangsmeldung wareneingangsmeldung) {
        this.wareneingangsmeldung = wareneingangsmeldung;
    }

    public IProdukt getProdukt() {
        return produkt;
    }

    public void setProdukt(IProdukt produkt) {
        this.produkt = produkt;
    }

    public ILieferant getLieferant() {
        return lieferant;
    }

    public void setLieferant(ILieferant lieferant) {
        this.lieferant = lieferant;
    }

    @Override
    public String toString() {
        return "Bestellung{" +
                "bestellungsNummer=" + bestellungsNummer +
                ", bestelldatum=" + bestelldatum +
                ", menge=" + menge +
                ", freigabe=" + freigabe +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bestellung)) return false;

        Bestellung that = (Bestellung) o;

        if (bestellungsNummer != that.bestellungsNummer) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return bestellungsNummer;
    }
}
