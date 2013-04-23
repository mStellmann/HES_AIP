package classes;

import interfaces.IAngebot;
import interfaces.IKunde;

import java.util.ArrayList;
import java.util.List;

public class Kunde implements IKunde{
    private int kundenNummer;
    private String name;
    private String adresse;
    private List<IAngebot> angebotsList = new ArrayList<IAngebot>();

    public Kunde(int kundenNummer, String name, String adresse) {
        this.kundenNummer = kundenNummer;
        this.name = name;
        this.adresse = adresse;
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
}
