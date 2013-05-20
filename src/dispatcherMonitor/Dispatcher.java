package dispatcherMonitor;

import dispatcherMonitor.interfaces.IDispatcher;
import dispatcherMonitor.interfaces.IMonitor;
import serverFassaden.interfaces.ICallCenterServerFassade;
import typClasses.AngebotTyp;
import typClasses.AuftragTyp;
import typClasses.KundeTyp;
import typClasses.ProduktTyp;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class Dispatcher implements IDispatcher {

    private IMonitor monitor;
    private Set<String> systeme;

    public Dispatcher(IMonitor monitor) {
        this.monitor = monitor;
    }

    public ICallCenterServerFassade getNaechstesHES(){
        systeme.
    }

    public void getSysteme(){
        systeme = monitor.getSysteme();
    }

    @Override
    public AngebotTyp erstelleAngebot(Date gueltigAb, Date gueltigBis, float gesamtPreis, KundeTyp kunde) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public AngebotTyp sucheAngebot(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<AngebotTyp> getAlleAngebote() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addProduktMengeZuAngebot(AngebotTyp angebot, ProduktTyp produkt, int menge) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public KundeTyp erstelleKunde(String name, String adresse) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ProduktTyp erstelleProdukt(String name, int lagerbestand) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ProduktTyp sucheProdukt(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ProduktTyp sucheProdukt(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<ProduktTyp> getAlleProdukte() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public KundeTyp sucheKunde(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public KundeTyp sucheKunde(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<KundeTyp> getAlleKunden() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public AuftragTyp erstelleAuftrag(Date beauftragtAm, AngebotTyp angebot) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<AuftragTyp> getAlleAuftraege() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public AuftragTyp sucheAuftrag(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}