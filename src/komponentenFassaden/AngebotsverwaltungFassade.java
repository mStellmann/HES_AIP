package komponentenFassaden;

import interfaces.IAngebot;
import interfaces.IKunde;
import komponentenInterfaces.extern.IAngebotsverwaltungExtern;
import komponentenInterfaces.intern.IAngebotsverwaltungIntern;
import komponentenInterfaces.intern.IKundenverwaltungIntern;
import komponentenInterfaces.intern.IPersitenz;
import komponentenInterfaces.intern.IProduktverwaltungIntern;
import komponentenLogik.AngebotsverwaltungLogik;
import komponentenRepositories.AngebotsverwaltungRepository;
import typClasses.AngebotTyp;
import typClasses.AuftragTyp;
import typClasses.KundeTyp;
import typClasses.ProduktTyp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;


public class AngebotsverwaltungFassade extends UnicastRemoteObject implements IAngebotsverwaltungIntern, IAngebotsverwaltungExtern {
    private AngebotsverwaltungRepository repository;
    private AngebotsverwaltungLogik logik;

    public AngebotsverwaltungFassade(IProduktverwaltungIntern produktverwaltungIntern, IKundenverwaltungIntern kundenverwaltungIntern, IPersitenz persitenz) throws RemoteException {
        repository = new AngebotsverwaltungRepository(persitenz);
        logik = new AngebotsverwaltungLogik(produktverwaltungIntern, kundenverwaltungIntern, repository);
    }

    @Override
    public AngebotTyp erstelleAngebot(Date gueltigAb, Date gueltigBis, float gesamtPreis, KundeTyp kunde) {
        IAngebot angebot = logik.erstelleAngebot(gueltigAb, gueltigBis, gesamtPreis, kunde);
        return new AngebotTyp(angebot.getAngebotsNummer(), angebot.getGueltigAb(), angebot.getGueltigBis(), gesamtPreis, kunde);
    }

    @Override
    public AngebotTyp sucheAngebot(int id) throws RemoteException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<AngebotTyp> getAlleAngebote() throws RemoteException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addProduktMengeZuAngebot(AngebotTyp angebot, ProduktTyp produkt, int menge) {
        logik.addProduktMengeZuAngebot(repository.getAngebot(angebot.getAngebotsNummer()), produkt, menge);
    }

    @Override
    public ProduktTyp erstelleProdukt(String name, int lagerbestand) throws RemoteException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ProduktTyp sucheProdukt(String name) throws RemoteException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ProduktTyp sucheProdukt(int id) throws RemoteException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<ProduktTyp> getAlleProdukte() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public KundeTyp erstelleKunde(String name, String adresse) throws RemoteException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public KundeTyp sucheKunde(String name) throws RemoteException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public KundeTyp sucheKunde(int id) throws RemoteException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<KundeTyp> getAlleKunden() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IAngebot erstelleAngebot(Date gueltigAb, Date gueltigBis, float gesamtPreis, IKunde kunde) {
        return repository.erstelleAngebot(gueltigAb, gueltigBis, gesamtPreis, kunde);
    }

    @Override
    public IAngebot getAngebot(int angebotsNummer) {
        return repository.getAngebot(angebotsNummer);
    }
}
