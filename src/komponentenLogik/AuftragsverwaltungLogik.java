package komponentenLogik;

import interfaces.IAuftrag;
import komponentenInterfaces.intern.IAngebotsverwaltungIntern;
import komponentenInterfaces.intern.ILagerverwaltungIntern;
import komponentenInterfaces.intern.ITransportdienstleisterAdapter;
import komponentenRepositories.AuftragsverwaltungRepository;
import typClasses.AngebotTyp;
import typClasses.AuftragTyp;
import typClasses.LieferungTyp;
import typClasses.RechnungTyp;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: aaz527
 * Date: 19.04.13
 * Time: 13:23
 * To change this template use File | Settings | File Templates.
 */
public class AuftragsverwaltungLogik {
    private IAngebotsverwaltungIntern angebotsverwaltungIntern;
    private ILagerverwaltungIntern lagerverwaltungIntern;
    private ITransportdienstleisterAdapter transportdienstleisterAdapter;
    private AuftragsverwaltungRepository repository;


    public AuftragsverwaltungLogik(IAngebotsverwaltungIntern angebotsverwaltungIntern, ILagerverwaltungIntern lagerverwaltungIntern, ITransportdienstleisterAdapter transportdienstleisterAdapter, AuftragsverwaltungRepository auftragsverwaltungRepository) {
        this.angebotsverwaltungIntern = angebotsverwaltungIntern;
        this.repository = auftragsverwaltungRepository;
        this.lagerverwaltungIntern = lagerverwaltungIntern;
        this.transportdienstleisterAdapter = transportdienstleisterAdapter;
    }

    public IAuftrag erstelleAuftrag(int auftragsNummer, Date beauftragtAm, AngebotTyp angebot, LieferungTyp lieferung, RechnungTyp rechnung) {
        return null;  // todo
    }
}
