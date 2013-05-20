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

    public List<IKunde> getAlleKunden() {
        return null;  // TODO
    }

    public IKunde sucheKunde(int id) {
        return null;  // TODO
    }

    public IKunde sucheKunde(String name) {
        return null;  // TODO
    }

    public IKunde erstelleKunde(String name, String adresse) {
        return null;  // TODO
    }

    public List<IProdukt> getAlleProdukte() {
        return null;  // TODO
    }

    public IProdukt sucheProdukt(int id) {
        return null;  // TODO
    }

    public IProdukt sucheProdukt(String name) {
        return null;  // TODO
    }

    public IProdukt erstelleProdukt(String name, int lagerbestand) {
        return null;  // TODO
    }
}
