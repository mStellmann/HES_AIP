package komponentenFassaden;

import komponentenInterfaces.extern.IAngebotsverwaltungExtern;
import komponentenInterfaces.intern.IAngebotsverwaltungIntern;
import komponentenInterfaces.intern.IKundenverwaltungIntern;
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

    public AngebotsverwaltungFassade(IProduktverwaltungIntern produktverwaltungIntern, IKundenverwaltungIntern kundenverwaltungIntern) {
        repository = new AngebotsverwaltungRepository();
        logik = new AngebotsverwaltungLogik(produktverwaltungIntern, kundenverwaltungIntern, repository);
    }

    @Override
    public AngebotTyp erstelleAngebot(int angebotsNummer, Date gueltigAb, Date gueltigBis, float gesamtPreis, KundeTyp kunde, AuftragTyp auftrag) {
        return null;  // todo
    }

    @Override
    public void addProduktMengeZuAngebot(AngebotTyp angebot, ProduktTyp produkt, int menge) {
        // todo
    }
}
