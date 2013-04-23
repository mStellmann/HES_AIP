package classes;

import interfaces.IAngebot;
import interfaces.IAuftrag;
import interfaces.ILieferung;
import interfaces.IRechnung;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 *
 */

@Entity
@Table(name = "Auftrag")
public class Auftrag implements IAuftrag, Serializable {

    @Id
    @GeneratedValue
    private int auftragsNummer;
    @Column //(nullable = false)
    private boolean istAbgeschlossen = false;
    @Column
    @Temporal(value = TemporalType.DATE)
    private Date beauftragtAm;


    @OneToOne
    @JoinColumn(name = "angebot")
    private IAngebot angebot;
    @OneToOne
    @JoinColumn(name = "lieferung")
    private ILieferung lieferung;
    @OneToOne
    @JoinColumn(name = "rechnung")
    private IRechnung rechnung;

    public Auftrag(Date beauftragtAm, IAngebot angebot, IRechnung rechnung, ILieferung lieferung) {
        this.beauftragtAm = beauftragtAm;
        this.angebot = angebot;
        this.rechnung = rechnung;
        this.lieferung = lieferung;
    }

    public Auftrag(Date beauftragtAm) {
        this(beauftragtAm, null, null, null);
    }

    public Auftrag(Date beauftragtAm, IAngebot angebot) {
        this(beauftragtAm, angebot, null, null);
    }

    public Auftrag() {
    }

    public int getAuftragsNummer() {
        return auftragsNummer;
    }

    public boolean isIstAbgeschlossen() {
        return istAbgeschlossen;
    }

    public void setIstAbgeschlossen(boolean istAbgeschlossen) {
        this.istAbgeschlossen = istAbgeschlossen;
    }

    public Date getBeauftragtAm() {
        return beauftragtAm;
    }

    public IAngebot getAngebot() {
        return angebot;
    }

    public void setAngebot(IAngebot angebot) {
        this.angebot = angebot;
    }

    public ILieferung getLieferung() {
        return lieferung;
    }

    public void setLieferung(ILieferung lieferung) {
        this.lieferung = lieferung;
    }

    public IRechnung getRechnung() {
        return rechnung;
    }

    public void setRechnung(IRechnung rechnung) {
        this.rechnung = rechnung;
    }

    public void setAuftragsNummer(int auftragsNummer) {
        this.auftragsNummer = auftragsNummer;
    }

    public void setBeauftragtAm(Date beauftragtAm) {
        this.beauftragtAm = beauftragtAm;
    }

    @Override
    public String toString() {
        return "Auftrag{" +
                "auftragsNummer=" + auftragsNummer +
                ", istAbgeschlossen=" + istAbgeschlossen +
                ", beauftragtAm=" + beauftragtAm +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auftrag)) return false;

        Auftrag auftrag = (Auftrag) o;

        if (auftragsNummer != auftrag.auftragsNummer) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return auftragsNummer;
    }
}
