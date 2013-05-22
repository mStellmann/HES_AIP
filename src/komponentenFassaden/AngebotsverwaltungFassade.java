package komponentenFassaden;

import interfaces.IAngebot;
import interfaces.IKunde;
import interfaces.IProdukt;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class AngebotsverwaltungFassade implements IAngebotsverwaltungIntern, IAngebotsverwaltungExtern {
    private AngebotsverwaltungRepository repository;
    private AngebotsverwaltungLogik logik;

    public AngebotsverwaltungFassade(IProduktverwaltungIntern produktverwaltungIntern, IKundenverwaltungIntern kundenverwaltungIntern, IPersitenz persitenz) throws RemoteException {
        repository = new AngebotsverwaltungRepository(persitenz);
        logik = new AngebotsverwaltungLogik(produktverwaltungIntern, kundenverwaltungIntern, repository);
    }

    // from extern
    @Override
    public AngebotTyp erstelleAngebot(Date gueltigAb, Date gueltigBis, float gesamtPreis, KundeTyp kunde) {
        IAngebot angebot = logik.erstelleAngebot(gueltigAb, gueltigBis, gesamtPreis, kunde);
        return new AngebotTyp(angebot.getAngebotsNummer(), angebot.getGueltigAb(), angebot.getGueltigBis(), gesamtPreis, kunde);
    }

    @Override
    public AngebotTyp sucheAngebot(int id) throws RemoteException {
        IAngebot angebot = repository.sucheAngebot(id);
        return new AngebotTyp(angebot);
    }

    @Override
    public List<AngebotTyp> getAlleAngebote() throws RemoteException {
        List<? extends IAngebot> angebotList = repository.getAlleAngebote();
        List<AngebotTyp> angebotTypList = new ArrayList<AngebotTyp>();
        for (IAngebot elem : angebotList) {
            angebotTypList.add(new AngebotTyp(elem));
        }
        return angebotTypList;
    }

    @Override
    public void addProduktMengeZuAngebot(AngebotTyp angebot, ProduktTyp produkt, int menge) {
        logik.addProduktMengeZuAngebot(repository.getAngebot(angebot.getAngebotsNummer()), produkt, menge);
    }

    @Override
    public ProduktTyp erstelleProdukt(String name, int lagerbestand) throws RemoteException {
        IProdukt produkt = logik.erstelleProdukt(name, lagerbestand);
        return new ProduktTyp(produkt);
    }

    @Override
    public ProduktTyp sucheProdukt(String name) throws RemoteException {
        IProdukt produkt = logik.sucheProdukt(name);
        return new ProduktTyp(produkt);
    }

    @Override
    public ProduktTyp sucheProdukt(int id) throws RemoteException {
        IProdukt produkt = logik.sucheProdukt(id);
        return new ProduktTyp(produkt);
    }

    @Override
    public List<ProduktTyp> getAlleProdukte() {
        List<? extends IProdukt> produktList = logik.getAlleProdukte();
        List<ProduktTyp> produktTypList = new ArrayList<ProduktTyp>();
        for (IProdukt elem : produktList) {
            produktTypList.add(new ProduktTyp(elem));
        }
        return produktTypList;
    }

    @Override
    public KundeTyp erstelleKunde(String name, String adresse) throws RemoteException {
        IKunde kunde = logik.erstelleKunde(name, adresse);
        return new KundeTyp(kunde);
    }

    @Override
    public KundeTyp sucheKunde(String name) throws RemoteException {
        IKunde kunde = logik.sucheKunde(name);
        return new KundeTyp(kunde);
    }

    @Override
    public KundeTyp sucheKunde(int id) throws RemoteException {
        IKunde kunde = logik.sucheKunde(id);
        return new KundeTyp(kunde);
    }

    @Override
    public List<KundeTyp> getAlleKunden() {
        List<? extends IKunde> kundeList = logik.getAlleKunden();
        List<KundeTyp> kundeTypList = new ArrayList<KundeTyp>();
        for (IKunde elem : kundeList) {
            kundeTypList.add(new KundeTyp(elem));
        }
        return kundeTypList;
    }


    // from intern
    @Override
    public IAngebot erstelleAngebot(Date gueltigAb, Date gueltigBis, float gesamtPreis, IKunde kunde) {
        return repository.erstelleAngebot(gueltigAb, gueltigBis, gesamtPreis, kunde);
    }

    @Override
    public IAngebot getAngebot(int angebotsNummer) {
        return repository.getAngebot(angebotsNummer);
    }
}
