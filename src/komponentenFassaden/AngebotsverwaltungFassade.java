package komponentenFassaden;

import interfaces.IAngebot;
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

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 13:12
 * To change this template use File | Settings | File Templates.
 */
public class AngebotsverwaltungFassade implements IAngebotsverwaltungIntern, IAngebotsverwaltungExtern {
    private AngebotsverwaltungRepository repository;
    private AngebotsverwaltungLogik logik;

    public AngebotsverwaltungFassade(IProduktverwaltungIntern produktverwaltungIntern, IKundenverwaltungIntern kundenverwaltungIntern, IPersitenz persitenz) {
        repository = new AngebotsverwaltungRepository(persitenz);
        logik = new AngebotsverwaltungLogik(produktverwaltungIntern, kundenverwaltungIntern, repository);
    }

    @Override
    public AngebotTyp erstelleAngebot(int angebotsNummer, Date gueltigAb, Date gueltigBis, KundeTyp kunde) {
        IAngebot angebot = logik.erstelleAngebot(angebotsNummer, gueltigAb, gueltigBis, kunde);
        return new AngebotTyp(angebot.getAngebotsNummer(), angebot.getGueltigAb(), angebot.getGueltigBis(), kunde);
    }

    @Override
    public void addProduktMengeZuAngebot(AngebotTyp angebot, ProduktTyp produkt, int menge) {
        logik.addProduktMengeZuAngebot(repository.getAngebot(angebot.getAngebotsNummer()), produkt, menge);
    }

    @Override
    public IAngebot getAngebot(int angebotsNummer) {
        return repository.getAngebot(angebotsNummer);
    }
}
