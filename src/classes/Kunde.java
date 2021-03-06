package classes;

import interfaces.IAngebot;
import interfaces.IKunde;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "KUNDE")
public class Kunde implements IKunde, Serializable {
    @Id
    @GeneratedValue
    private int kundenNummer;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String adresse;
    @OneToMany(mappedBy = "kunde", targetEntity = Angebot.class)
    private List<IAngebot> angebotsList;

    public Kunde(String name, String adresse) {
        this.kundenNummer = kundenNummer;
        this.name = name;
        this.adresse = adresse;
        angebotsList = new ArrayList<IAngebot>();
    }

    public Kunde() {
    }

    public void setKundenNummer(int kundenNummer) {
        this.kundenNummer = kundenNummer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setAngebotsList(List<IAngebot> angebotsList) {
        this.angebotsList = angebotsList;
    }


    @Override
    public int getKundennummer() {
        return this.kundenNummer;
    }

    @Override
    public String getKundenname() {
        return this.name;
    }

    @Override
    public String getAdresse() {
        return this.adresse;
    }

    @Override
    public void putAngebotToList(IAngebot angebot) {
        angebotsList.add(angebot);
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "kundenNummer=" + kundenNummer +
                ", name='" + name + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kunde)) return false;

        Kunde kunde = (Kunde) o;

        if (kundenNummer != kunde.kundenNummer) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return kundenNummer;
    }
}
