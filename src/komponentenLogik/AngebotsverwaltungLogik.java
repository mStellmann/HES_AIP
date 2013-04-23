package komponentenLogik;

import interfaces.IAngebot;
import interfaces.IProdukt;
import komponentenInterfaces.intern.IKundenverwaltungIntern;
import komponentenInterfaces.intern.IProduktverwaltungIntern;
import komponentenRepositories.AngebotsverwaltungRepository;
import typClasses.AngebotTyp;
import typClasses.KundeTyp;
import typClasses.ProduktTyp;

import java.util.Date;

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

    public IAngebot erstelleAngebot(int angebotsNummer, Date gueltigAb, Date gueltigBis, float gesamtPreis, KundeTyp kunde) {
        return repository.erstelleAngebot(angebotsNummer, gueltigAb, gueltigBis, gesamtPreis, kundenverwaltungIntern.getKunde(kunde.getKundenNummer()));
    }
}
