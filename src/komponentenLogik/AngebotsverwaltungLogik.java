package komponentenLogik;


import interfaces.IAngebot;
import interfaces.IKunde;
import interfaces.IProdukt;
import komponentenInterfaces.intern.IKundenverwaltungIntern;
import komponentenInterfaces.intern.IProduktverwaltungIntern;
import komponentenRepositories.AngebotsverwaltungRepository;
import typClasses.KundeTyp;
import typClasses.ProduktTyp;

import java.util.Date;
import java.util.List;

/**
 *
 */
public class AngebotsverwaltungLogik {
    IProduktverwaltungIntern produktverwaltungIntern;
    IKundenverwaltungIntern kundenverwaltungIntern;
    AngebotsverwaltungRepository repository;

    public AngebotsverwaltungLogik(IProduktverwaltungIntern produktverwaltungIntern, IKundenverwaltungIntern kundenverwaltungIntern, AngebotsverwaltungRepository repository) {
        this.kundenverwaltungIntern = kundenverwaltungIntern;
        this.produktverwaltungIntern = produktverwaltungIntern;
        this.repository = repository;
    }

    public void addProduktMengeZuAngebot(IAngebot angebot, ProduktTyp produkt, int menge) {
        IProdukt produktVar = produktverwaltungIntern.getProdukt(produkt.getProduktNummer());
        repository.getAngebot(angebot.getAngebotsNummer()).addProduktMenge(produktVar, menge);
    }

    public IAngebot erstelleAngebot(Date gueltigAb, Date gueltigBis, float gesamtPreis, KundeTyp kunde) {
        return repository.erstelleAngebot(gueltigAb, gueltigBis, gesamtPreis, kundenverwaltungIntern.getKunde(kunde.getKundenNummer()));
    }

    public List<? extends IKunde> getAlleKunden() {
        return kundenverwaltungIntern.getAllKunden();
    }

    public IKunde sucheKunde(int id) {
        return kundenverwaltungIntern.getKunde(id);
    }

    public IKunde sucheKunde(String name) {
        return kundenverwaltungIntern.getKunde(name);
    }

    public IKunde erstelleKunde(String name, String adresse) {
        return kundenverwaltungIntern.createKunde(name, adresse);
    }

    public List<? extends IProdukt> getAlleProdukte() {
        return produktverwaltungIntern.getAllProdukte();
    }

    public IProdukt sucheProdukt(int id) {
        return produktverwaltungIntern.getProdukt(id);
    }

    public IProdukt sucheProdukt(String name) {
        return produktverwaltungIntern.getProdukt(name);
    }

    public IProdukt erstelleProdukt(String name, int lagerbestand) {
        return produktverwaltungIntern.createProdukt(name, lagerbestand);
    }
}
