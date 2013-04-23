package komponentenLogik;

import classes.Warenausgangsmeldung;
import classes.Wareneingangsmeldung;
import interfaces.IProdukt;
import interfaces.IWarenausgangsmeldung;
import interfaces.IWareneingangsmeldung;
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

    public boolean pruefeLagerbestand(int warenNr, int geforderteMenge) throws IndexOutOfBoundsException{
        IProdukt produkt = getProdukt(warenNr);
        if (geforderteMenge <= produkt.getLagerbestand()) {
            IWarenausgangsmeldung warenausgangsmeldung = repository.createWarenausgangsmeldung(geforderteMenge, new Date(), produkt);
            produktverwaltung.lagerbestendReduzieren(geforderteMenge);
            return true;
        } else {
              return false;
//            LieferungTyp lieferung = wareBestellen(warenNr);
//            IWareneingangsmeldung wareneingangsmeldung = repository.createWareneingangsmeldung(lieferung.getBestellNr(), new Date()); //Date platzhalter für JodaTime
//            pruefeLagerbestand(warenNr,geforderteMenge); // da jetzt vorhanden wird eine warenausgangsmeldung erzeugt.
        }
    }



    private LieferungTyp wareBestellen(int warenNr) {
        return einkaufsverwaltung.wareBestellen(warenNr);
    }

//    private boolean istAusreichendVorhanden(int warenNr,int menge) {
//        return produktverwaltung.istAusreichendVorhanden(warenNr,menge);
//    }

    private boolean nrIstVorhanden(int warenNr){
        return produktverwaltung.nrIstVorhanden(warenNr);
    }

    private IProdukt getProdukt(int warenNr) throws IndexOutOfBoundsException {
        if (nrIstVorhanden(warenNr)) return produktverwaltung.getProdukt(warenNr);
        else throw new IndexOutOfBoundsException();

    }
}
