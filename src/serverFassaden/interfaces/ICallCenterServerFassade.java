package serverFassaden.interfaces;

import komponentenFassaden.AngebotsverwaltungFassade;
import komponentenFassaden.AuftragsverwaltungFassade;
import typClasses.AngebotTyp;
import typClasses.AuftragTyp;
import typClasses.KundeTyp;
import typClasses.ProduktTyp;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 20.05.13
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */
public interface ICallCenterServerFassade extends Remote{

    AngebotTyp erstelleAngebot(Date gueltigAb, Date gueltigBis, float gesamtPreis, KundeTyp kunde) throws RemoteException;

    AngebotTyp sucheAngebot(int id) throws RemoteException;

    List<AngebotTyp> getAlleAngebote() throws RemoteException;

    void addProduktMengeZuAngebot(AngebotTyp angebot, ProduktTyp produkt, int menge) throws RemoteException;

    ProduktTyp erstelleProdukt(String name, int lagerbestand) throws RemoteException;

    ProduktTyp sucheProdukt(String name) throws RemoteException;

    ProduktTyp sucheProdukt(int id) throws RemoteException;

    List<ProduktTyp> getAlleProdukte();

    KundeTyp erstelleKunde(String name, String adresse) throws RemoteException;

    KundeTyp sucheKunde(String name) throws RemoteException;

    KundeTyp sucheKunde(int id) throws RemoteException;

    List<KundeTyp> getAlleKunden();

    AuftragTyp erstelleAuftrag(Date beauftragtAm, AngebotTyp angebot) throws RemoteException;

    List<AuftragTyp> getAlleAuftraege() throws RemoteException;

    AuftragTyp sucheAuftrag(int id) throws RemoteException;

}
