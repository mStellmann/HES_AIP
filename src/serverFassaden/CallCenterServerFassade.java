package serverFassaden;

import komponentenFassaden.AngebotsverwaltungFassade;
import komponentenFassaden.AuftragsverwaltungFassade;
import komponentenInterfaces.extern.IAngebotsverwaltungExtern;
import komponentenInterfaces.extern.IAuftragsverwaltungExtern;
import serverFassaden.interfaces.ICallCenterServerFassade;
import typClasses.AngebotTyp;
import typClasses.AuftragTyp;
import typClasses.KundeTyp;
import typClasses.ProduktTyp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 13:08
 * To change this template use File | Settings | File Templates.
 */
public class CallCenterServerFassade extends UnicastRemoteObject implements ICallCenterServerFassade {
    private IAngebotsverwaltungExtern angebotsverwaltungFassade;
    private IAuftragsverwaltungExtern auftragsverwaltungFassade;

    public CallCenterServerFassade(IAngebotsverwaltungExtern angebotsverwaltungFassade, IAuftragsverwaltungExtern auftragsverwaltungFassade) throws RemoteException {
        this.angebotsverwaltungFassade = angebotsverwaltungFassade;
        this.auftragsverwaltungFassade = auftragsverwaltungFassade;
    }

    @Override
    public AngebotTyp erstelleAngebot(Date gueltigAb, Date gueltigBis, float gesamtPreis, KundeTyp kunde) throws RemoteException {
        return angebotsverwaltungFassade.erstelleAngebot(gueltigAb, gueltigBis, gesamtPreis, kunde);
    }

    @Override
    public AngebotTyp sucheAngebot(int id) throws RemoteException {
        return angebotsverwaltungFassade.sucheAngebot(id);
    }

    @Override
    public List<AngebotTyp> getAlleAngebote() throws RemoteException {
        return angebotsverwaltungFassade.getAlleAngebote();
    }

    @Override
    public void addProduktMengeZuAngebot(AngebotTyp angebot, ProduktTyp produkt, int menge) throws RemoteException {
        angebotsverwaltungFassade.addProduktMengeZuAngebot(angebot, produkt, menge);
    }

    @Override
    public ProduktTyp erstelleProdukt(String name, int lagerbestand) throws RemoteException {
        return angebotsverwaltungFassade.erstelleProdukt(name, lagerbestand);
    }

    @Override
    public ProduktTyp sucheProdukt(String name) throws RemoteException {
        return angebotsverwaltungFassade.sucheProdukt(name);
    }

    @Override
    public ProduktTyp sucheProdukt(int id) throws RemoteException {
        return angebotsverwaltungFassade.sucheProdukt(id);
    }

    @Override
    public List<ProduktTyp> getAlleProdukte() throws RemoteException {
        return angebotsverwaltungFassade.getAlleProdukte();
    }

    @Override
    public KundeTyp erstelleKunde(String name, String adresse) throws RemoteException {
        return angebotsverwaltungFassade.erstelleKunde(name, adresse);
    }

    @Override
    public KundeTyp sucheKunde(String name) throws RemoteException {
        return angebotsverwaltungFassade.sucheKunde(name);
    }

    @Override
    public KundeTyp sucheKunde(int id) throws RemoteException {
        return angebotsverwaltungFassade.sucheKunde(id);
    }

    @Override
    public List<KundeTyp> getAlleKunden() throws RemoteException {
        return angebotsverwaltungFassade.getAlleKunden();
    }

    @Override
    public AuftragTyp erstelleAuftrag(Date beauftragtAm, AngebotTyp angebot) throws RemoteException {
        return auftragsverwaltungFassade.erstelleAuftrag(beauftragtAm, angebot);
    }

    @Override
    public List<AuftragTyp> getAlleAuftraege() throws RemoteException {
        return auftragsverwaltungFassade.getAlleAuftraege();
    }

    @Override
    public AuftragTyp sucheAuftrag(int id) throws RemoteException {
        return auftragsverwaltungFassade.sucheAuftrag(id);
    }


//    @Override
//    public AngebotsverwaltungFassade getAngebotsverwqaltungFassade() throws RemoteException {
//        return angebotsverwaltungFassade;
//    }
//
//    @Override
//    public AuftragsverwaltungFassade getAuftragverwaltungFassade() throws RemoteException {
//        return auftragsverwaltungFassade;
//    }
}
