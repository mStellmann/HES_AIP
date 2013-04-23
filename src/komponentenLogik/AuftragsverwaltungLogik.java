package komponentenLogik;

import interfaces.IAngebot;
import interfaces.IAuftrag;
import interfaces.IProdukt;
import komponentenInterfaces.intern.IAngebotsverwaltungIntern;
import komponentenInterfaces.intern.ILagerverwaltungIntern;
import komponentenInterfaces.intern.ITransportdienstleisterAdapter;
import komponentenRepositories.AuftragsverwaltungRepository;
import typClasses.*;

import java.util.Date;
import java.util.Set;

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

    public IAuftrag erstelleAuftrag(Date beauftragtAm, AngebotTyp angebot) throws Exception {

        Set<ProduktTyp> produktSet = angebot.getProduktMengeMap().keySet();

        for (ProduktTyp elem : produktSet) {
            if (!lagerverwaltungIntern.pruefeLagerbestand(elem.getProduktNummer(), angebot.getProduktMengeMap().get(elem)))
                throw new Exception("Nicht genug Produkte vorhanden. ProduktNummer(" + elem + ")");
        }

        IAngebot angebotVar = angebotsverwaltungIntern.getAngebot(angebot.getAngebotsNummer());
        return repository.erstelleAuftrag(beauftragtAm, angebotVar);
    }
}
