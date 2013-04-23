package komponentenRepositories;

import classes.Warenausgangsmeldung;
import classes.Wareneingangsmeldung;
import interfaces.IBestellung;
import interfaces.IProdukt;
import interfaces.IWarenausgangsmeldung;
import interfaces.IWareneingangsmeldung;
import komponentenInterfaces.intern.IPersitenz;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 13:29
 * To change this template use File | Settings | File Templates.
 */
public class LagerverwaltungRepository {
    private IPersitenz persistenz;

    public LagerverwaltungRepository(IPersitenz persistenz) {
        this.persistenz = persistenz;

    }

    public IWareneingangsmeldung createWareneingangsmeldung(int bestellNr, Date datum, IBestellung bestellung) {
        return new Wareneingangsmeldung(bestellNr, datum, bestellung);
    }

    public IWarenausgangsmeldung createWarenausgangsmeldung(int menge, Date datum, IProdukt produkt) {
        return new Warenausgangsmeldung(menge, datum, produkt);
    }

    // Saves
    private <T> void save(T lagerMeldung) {
        persistenz.saveObject(lagerMeldung);
    }
}
