package komponentenFassaden;

import interfaces.ILieferung;
import komponentenInterfaces.extern.IAuftragsverwaltungExtern;
import komponentenInterfaces.intern.IAngebotsverwaltungIntern;
import komponentenInterfaces.intern.IAuftragsverwaltungIntern;
import komponentenInterfaces.intern.ILagerverwaltungIntern;
import komponentenInterfaces.intern.ITransportdienstleisterAdapter;
import komponentenLogik.AuftragsverwaltungLogik;
import komponentenRepositories.AuftragsverwaltungRepository;
import typClasses.AngebotTyp;
import typClasses.AuftragTyp;
import typClasses.LieferungTyp;
import typClasses.RechnungTyp;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 13:11
 * To change this template use File | Settings | File Templates.
 */
public class AuftragsverwaltungFassade implements IAuftragsverwaltungIntern, IAuftragsverwaltungExtern {
    private AuftragsverwaltungLogik logik;
    private AuftragsverwaltungRepository repository;

    public AuftragsverwaltungFassade(IAngebotsverwaltungIntern angebotsverwaltungIntern, ILagerverwaltungIntern lagerverwaltungIntern, ITransportdienstleisterAdapter transportdienstleisterAdapter) {
        repository = new AuftragsverwaltungRepository();
        logik = new AuftragsverwaltungLogik(angebotsverwaltungIntern, lagerverwaltungIntern, transportdienstleisterAdapter, repository);
    }

    @Override
    public AuftragTyp erstelleAuftrag(int auftragsNummer, Date beauftragtAm, AngebotTyp angebot, LieferungTyp lieferung, RechnungTyp rechnung) {
        return null;  // todo
    }

    @Override
    public ILieferung erstelleLieferung(int auftragsNummer) {
        return null;  // todo
    }

    @Override
    public void markiereAuftragAlsVerschickt(int auftragsNummer) {
        // todo
    }

    @Override
    public void auftragAbschliessen(int auftragsNummer) {
        // todo
    }
}
