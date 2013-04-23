package classes;

import interfaces.IAuftrag;
import interfaces.IRechnung;
import interfaces.IZahlungseingang;
import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Entity
@Table(name = "Rechnung")
public class Rechnung implements IRechnung, Serializable {
    @Id
    @GeneratedValue
    private int rechnungsNummer;
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date rechnungsDatum;
    @Column(nullable = false)
    private boolean istBezahlt = false;
    @OneToMany(mappedBy = "Rechnung")
    private List<IZahlungseingang> zahlungseingangList;
    @OneToOne
    @JoinColumn(name = "auftrag")
    private IAuftrag auftrag;

    public Rechnung(Date rechnungsDatum, List<IZahlungseingang> zahlungseingangList, IAuftrag auftrag) {
        this.rechnungsDatum = rechnungsDatum;
        this.zahlungseingangList = zahlungseingangList;
        this.auftrag = auftrag;
    }

    public Rechnung(Date rechnungsDatum) {
        this(rechnungsDatum, new ArrayList<IZahlungseingang>(), null);
    }

    public Rechnung() {
    }

    public int getRechnungsNummer() {
        return rechnungsNummer;
    }

    public void setRechnungsNummer(int rechnungsNummer) {
        this.rechnungsNummer = rechnungsNummer;
    }

    public Date getRechnungsDatum() {
        return rechnungsDatum;
    }

    public void setRechnungsDatum(Date rechnungsDatum) {
        this.rechnungsDatum = rechnungsDatum;
    }

    public boolean isIstBezahlt() {
        return istBezahlt;
    }

    public void setIstBezahlt(boolean istBezahlt) {
        this.istBezahlt = istBezahlt;
    }

    public List<IZahlungseingang> getZahlungseingangList() {
        return zahlungseingangList;
    }

    public void setZahlungseingangList(List<IZahlungseingang> zahlungseingangList) {
        this.zahlungseingangList = zahlungseingangList;
    }

    public IAuftrag getAuftrag() {
        return auftrag;
    }

    public void setAuftrag(IAuftrag auftrag) {
        this.auftrag = auftrag;
    }

    @Override
    public String toString() {
        return "Rechnung{" +
                "rechnungsNummer=" + rechnungsNummer +
                ", rechnungsDatum=" + rechnungsDatum +
                ", istBezahlt=" + istBezahlt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rechnung)) return false;

        Rechnung rechnung = (Rechnung) o;

        if (rechnungsNummer != rechnung.rechnungsNummer) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return rechnungsNummer;
    }
}
