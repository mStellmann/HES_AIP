package komponentenInterfaces.extern;

import org.hibernate.cfg.annotations.ResultsetMappingSecondPass;
import typClasses.AngebotTyp;
import typClasses.AuftragTyp;
import typClasses.KundeTyp;
import typClasses.ProduktTyp;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 *
 */
public interface IAngebotsverwaltungExtern  {

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
}
