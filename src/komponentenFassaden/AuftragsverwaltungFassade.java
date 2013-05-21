package komponentenFassaden;

import interfaces.IAngebot;
import interfaces.IAuftrag;
import interfaces.ILieferung;
import interfaces.ITransportauftrag;
import komponentenInterfaces.extern.IAuftragsverwaltungExtern;
import komponentenInterfaces.intern.*;
import komponentenLogik.AuftragsverwaltungLogik;
import komponentenRepositories.AuftragsverwaltungRepository;
import typClasses.AngebotTyp;
import typClasses.AuftragTyp;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class AuftragsverwaltungFassade implements IAuftragsverwaltungIntern, IAuftragsverwaltungExtern {
    private AuftragsverwaltungLogik logik;
    private AuftragsverwaltungRepository repository;

    public AuftragsverwaltungFassade(IAngebotsverwaltungIntern angebotsverwaltungIntern, ILagerverwaltungIntern lagerverwaltungIntern, ITransportdienstleisterAdapter transportdienstleisterAdapter, IPersitenz persitenz) throws RemoteException {
        repository = new AuftragsverwaltungRepository(persitenz);
        logik = new AuftragsverwaltungLogik(angebotsverwaltungIntern, lagerverwaltungIntern, transportdienstleisterAdapter, repository);
    }

    // ----- from extern -----
    @Override
    public AuftragTyp erstelleAuftrag(Date beauftragtAm, AngebotTyp angebot) {
        IAuftrag auftrag = null;
        try {
            auftrag = logik.erstelleAuftrag(beauftragtAm, angebot);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AuftragTyp(auftrag.getAuftragsNummer(), auftrag.getBeauftragtAm(), angebot);
    }

    @Override
    public List<AuftragTyp> getAlleAuftraege() throws RemoteException {
        List<? extends IAuftrag> auftragList = repository.getAlleAuftraege();
        List<AuftragTyp> auftragTypList = new ArrayList<AuftragTyp>();
        for (IAuftrag elem : auftragList)
            auftragTypList.add(new AuftragTyp(elem));
        return auftragTypList;
    }

    @Override
    public AuftragTyp sucheAuftrag(int id) throws RemoteException {
        IAuftrag auftrag = repository.sucheAuftrag(id);
        return new AuftragTyp(auftrag);
    }

    // ----- from intern -----
    @Override
    public ILieferung erstelleLieferung() {
        return repository.erstelleLieferung();
    }

    @Override
    public IAuftrag erstelleAuftrag(Date beauftragtAm, IAngebot angebot) {
        return repository.erstelleAuftrag(beauftragtAm, angebot);
    }

    @Override
    public ITransportauftrag erstelleTransportauftrag(Date ausgangsdatum, String transportdienstleister) {
        return repository.erstelleTransportauftrag(ausgangsdatum, transportdienstleister);
    }

    @Override
    public ITransportauftrag getTransportauftrag(int transportauftragsNummer) {
        return repository.getTransportauftrag(transportauftragsNummer);
    }

    @Override
    public IAuftrag getAuftrag(int auftragsNummer) {
        return repository.getAuftrag(auftragsNummer);
    }

    @Override
    public ILieferung getLieferung(int lieferungsNummer) {
        return repository.getLieferung(lieferungsNummer);
    }

    @Override
    public void markiereAuftragAlsVerschickt(int auftragsNummer) {
        IAuftrag auftrag = repository.getAuftrag(auftragsNummer);
        auftrag.getLieferung().getTransportauftrag().setLieferungErfolgt(true);
        repository.updateAuftrag(auftrag);
    }

    @Override
    public void auftragAbschliessen(int auftragsNummer) {
        IAuftrag auftrag = repository.getAuftrag(auftragsNummer);
        auftrag.setIstAbgeschlossen(true);
        repository.updateAuftrag(auftrag);
    }
}
