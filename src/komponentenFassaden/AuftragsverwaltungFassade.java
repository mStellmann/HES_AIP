package komponentenFassaden;

import interfaces.IAuftrag;
import interfaces.ILieferung;
import komponentenInterfaces.extern.IAuftragsverwaltungExtern;
import komponentenInterfaces.intern.*;
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

    public AuftragsverwaltungFassade(IAngebotsverwaltungIntern angebotsverwaltungIntern, ILagerverwaltungIntern lagerverwaltungIntern, ITransportdienstleisterAdapter transportdienstleisterAdapter, IPersitenz persitenz) {
        repository = new AuftragsverwaltungRepository(persitenz);
        logik = new AuftragsverwaltungLogik(angebotsverwaltungIntern, lagerverwaltungIntern, transportdienstleisterAdapter, repository);
    }
    // from extern
    @Override
    public AuftragTyp erstelleAuftrag(int auftragsNummer, Date beauftragtAm, AngebotTyp angebot) {
        IAuftrag auftrag = logik.erstelleAuftrag(auftragsNummer,beauftragtAm,angebot);
        return new AuftragTyp(auftrag.getAuftragsNummer(),auftrag.getBeauftragtAm(),angebot);
    }

    // from intern
    @Override
    public ILieferung erstelleLieferung(int lieferungsNummer) {
        return repository.erstelleLieferung(lieferungsNummer);
    }

    @Override
    public void markiereAuftragAlsVerschickt(int auftragsNummer) {
        repository.getAuftrag(auftragsNummer).getLieferung().getTransportauftrag().setLieferungErfolgt(true);
    }

    @Override
    public void auftragAbschliessen(int auftragsNummer) {
        repository.getAuftrag(auftragsNummer).setIstAbgeschlossen(true);
    }
}
