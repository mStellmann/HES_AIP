package komponentenLogik;

import classes.Warenausgangsmeldung;
import classes.Wareneingangsmeldung;
import komponentenInterfaces.intern.IEinkaufsverwaltungIntern;
import komponentenInterfaces.intern.IProduktverwaltungIntern;
import komponentenRepositories.LagerverwaltungRepository;
import typClasses.LieferungTyp;
import typClasses.ProduktTyp;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: aaz527
 * Date: 19.04.13
 * Time: 13:16
 * To change this template use File | Settings | File Templates.
 */
public class LagerverwaltungLogik {
    private LagerverwaltungRepository repository;
    private IProduktverwaltungIntern produktverwaltung;
    private IEinkaufsverwaltungIntern einkaufsverwaltung;


    public LagerverwaltungLogik(LagerverwaltungRepository repository, IProduktverwaltungIntern produktverwaltung, IEinkaufsverwaltungIntern einkaufsverwaltung) {
        this.repository = repository;
        this.produktverwaltung = produktverwaltung;
        this.einkaufsverwaltung = einkaufsverwaltung;
    }

    public void produktAusliefern(int warenNr) {
        ProduktTyp produkt = getProduktTyp(warenNr);
        if (istAusreichendVorhanden(warenNr, produkt.getMenge())) {

            Warenausgangsmeldung warenausgangsmeldung = repository.createWarenausgangsmeldung(produkt.getMenge(), new Date());
        } else {
            LieferungTyp lieferung = wareBestellen(warenNr);
            Wareneingangsmeldung wareneingangsmeldung = repository.createWareneingangsmeldung(lieferung.getBestellNr(), new Date()); //Date platzhalter für JodaTime
            produktAusliefern(warenNr); // da jetzt vorhanden wird eine warenausgangsmeldung erzeugt.
        }
    }

    private LieferungTyp wareBestellen(int warenNr) {
        return einkaufsverwaltung.wareBestellen(warenNr);
    }

    private boolean istAusreichendVorhanden(int warenNr,int menge) {
        return produktverwaltung.istAusreichendVorhanden(warenNr,menge);
    }

    private ProduktTyp getProduktTyp(int warenNr) {
        return produktverwaltung.getProduktTyp(warenNr);

    }
}
