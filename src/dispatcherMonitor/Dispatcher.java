package dispatcherMonitor;

import dispatcherMonitor.interfaces.IDispatcher;
import dispatcherMonitor.interfaces.IMonitor;
import serverFassaden.interfaces.ICallCenterServerFassade;
import typClasses.AngebotTyp;
import typClasses.AuftragTyp;
import typClasses.KundeTyp;
import typClasses.ProduktTyp;

import java.rmi.RemoteException;
import java.util.*;

/**
 *
 */
public class Dispatcher implements IDispatcher {

    private IMonitor monitor;
    private Map<String, ICallCenterServerFassade> systemMap;
    private Map<String, ICallCenterServerFassade> benutzteSysteme;
//    private ICallCenterServerFassade activesSystem;
//    private String activesSystemName;

    public Dispatcher(IMonitor monitor, Map systemMap) {
        this.monitor = monitor;
        this.systemMap = systemMap;
        this.benutzteSysteme = new HashMap<String, ICallCenterServerFassade>();
    }

    public ICallCenterServerFassade getNaechstesHES() {
        if (benutzteSysteme.size() == systemMap.size()) {
            benutzteSysteme.clear();
        }

        Set<String> systemNamen = systemMap.keySet();
        for (String elem : systemNamen) {
            if (!(benutzteSysteme.containsKey(elem)) && monitor.isVerfuegbar(elem)) {
                ICallCenterServerFassade naechstesHES = systemMap.get(elem);
                benutzteSysteme.put(elem, naechstesHES);
                monitor.countOneOp(elem);
                return naechstesHES;
            }

        }
        System.out.println("DAS IST SCHEISSE UND DARF NIE PASSIEREN");
        return null;  //sollte nie passieren
    }

    @Override
    public AngebotTyp erstelleAngebot(Date gueltigAb, Date gueltigBis, float gesamtPreis, KundeTyp kunde) {
        try {
            return getNaechstesHES().erstelleAngebot(gueltigAb, gueltigBis, gesamtPreis, kunde);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public AngebotTyp sucheAngebot(int id) {
        try {
            return getNaechstesHES().sucheAngebot(id);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public List<AngebotTyp> getAlleAngebote() {
        try {
            return getNaechstesHES().getAlleAngebote();
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public void addProduktMengeZuAngebot(AngebotTyp angebot, ProduktTyp produkt, int menge) {
        try {
            getNaechstesHES().addProduktMengeZuAngebot(angebot, produkt, menge);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Override
    public KundeTyp erstelleKunde(String name, String adresse) {
        try {
            return getNaechstesHES().erstelleKunde(name, adresse);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public ProduktTyp erstelleProdukt(String name, int lagerbestand) {
        try {
            return getNaechstesHES().erstelleProdukt(name, lagerbestand);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public ProduktTyp sucheProdukt(String name) {
        try {
            return getNaechstesHES().sucheProdukt(name);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public ProduktTyp sucheProdukt(int id) {
        try {
            return getNaechstesHES().sucheProdukt(id);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ProduktTyp> getAlleProdukte() {
        try {
            return getNaechstesHES().getAlleProdukte();
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public KundeTyp sucheKunde(String name) {
        try {
            return getNaechstesHES().sucheKunde(name);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public KundeTyp sucheKunde(int id) {
        try {
            return getNaechstesHES().sucheKunde(id);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public List<KundeTyp> getAlleKunden() {
        try {
            return getNaechstesHES().getAlleKunden();
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public AuftragTyp erstelleAuftrag(Date beauftragtAm, AngebotTyp angebot) {
        try {
            return getNaechstesHES().erstelleAuftrag(beauftragtAm, angebot);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public List<AuftragTyp> getAlleAuftraege() {
        try {
            return getNaechstesHES().getAlleAuftraege();  //To change body of implemented methods use File | Settings | File Templates.
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public AuftragTyp sucheAuftrag(int id) {
        try {
            return getNaechstesHES().sucheAuftrag(id);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
}
