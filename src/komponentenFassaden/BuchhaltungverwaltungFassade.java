package komponentenFassaden;

import interfaces.IAuftrag;
import interfaces.IRechnung;
import komponentenInterfaces.extern.IBuchhaltungsverwaltungExtern;
import komponentenInterfaces.intern.IAuftragsverwaltungIntern;
import komponentenInterfaces.intern.IBankAdapter;
import komponentenInterfaces.intern.IBuchhaltungsverwaltungIntern;
import komponentenLogik.BuchhaltungLogik;
import komponentenRepositories.BuchhaltungsverwaltungRepository;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 13:10
 * To change this template use File | Settings | File Templates.
 */
public class BuchhaltungverwaltungFassade implements IBuchhaltungsverwaltungIntern, IBuchhaltungsverwaltungExtern {
    @Override
    public IRechnung erstelleRechnung(int rechnungsNummer, Date rechnungsDatum, IAuftrag auftrag) {
        return null;  // todo
    }

    @Override
    public void markiereRechnungAlsBezahlt(int rechnungsNummer) {
        // todo
    }

    private BuchhaltungsverwaltungRepository repository;
    private BuchhaltungLogik logik;

    public BuchhaltungverwaltungFassade(IBankAdapter bankAdapter, IAuftragsverwaltungIntern auftragsverwaltungIntern) {
        this.repository = new BuchhaltungsverwaltungRepository();
        this.logik = new BuchhaltungLogik(bankAdapter, auftragsverwaltungIntern, repository);
    }
}
