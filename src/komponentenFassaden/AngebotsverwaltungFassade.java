package komponentenFassaden;

import interfaces.IAngebot;
import interfaces.IKunde;
import komponentenInterfaces.extern.IAngebotsverwaltungExtern;
import komponentenInterfaces.intern.IAngebotsverwaltungIntern;
import komponentenInterfaces.intern.IKundenverwaltungIntern;
import komponentenInterfaces.intern.IPersitenz;
import komponentenInterfaces.intern.IProduktverwaltungIntern;
import komponentenLogik.AngebotsverwaltungLogik;
import komponentenRepositories.AngebotsverwaltungRepository;
import typClasses.AngebotTyp;
import typClasses.AuftragTyp;
import typClasses.KundeTyp;
import typClasses.ProduktTyp;

import java.util.Date;


public class AngebotsverwaltungFassade implements IAngebotsverwaltungIntern, IAngebotsverwaltungExtern {
    private AngebotsverwaltungRepository repository;
    private AngebotsverwaltungLogik logik;

    public AngebotsverwaltungFassade(IProduktverwaltungIntern produktverwaltungIntern, IKundenverwaltungIntern kundenverwaltungIntern, IPersitenz persitenz) {
        repository = new AngebotsverwaltungRepository(persitenz);
        logik = new AngebotsverwaltungLogik(produktverwaltungIntern, kundenverwaltungIntern, repository);
    }

    @Override
    public AngebotTyp erstelleAngebot(Date gueltigAb, Date gueltigBis, float gesamtPreis, KundeTyp kunde) {
        IAngebot angebot = logik.erstelleAngebot(gueltigAb, gueltigBis, gesamtPreis, kunde);
        return new AngebotTyp(angebot.getAngebotsNummer(), angebot.getGueltigAb(), angebot.getGueltigBis(), gesamtPreis, kunde);
    }

    @Override
    public void addProduktMengeZuAngebot(AngebotTyp angebot, ProduktTyp produkt, int menge) {
        logik.addProduktMengeZuAngebot(repository.getAngebot(angebot.getAngebotsNummer()), produkt, menge);
    }

    @Override
    public IAngebot erstelleAngebot(Date gueltigAb, Date gueltigBis, float gesamtPreis, IKunde kunde) {
        return repository.erstelleAngebot(gueltigAb, gueltigBis, gesamtPreis, kunde);
    }

    @Override
    public IAngebot getAngebot(int angebotsNummer) {
        return repository.getAngebot(angebotsNummer);
    }
}
