package komponentenRepositories;

import classes.Angebot;
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

     // Creates
    public IWareneingangsmeldung createWareneingangsmeldung(int bestellNr, Date datum, IBestellung bestellung) {
        Wareneingangsmeldung wareneingangsmeldung = new Wareneingangsmeldung(bestellNr, datum, bestellung);
        save(wareneingangsmeldung);
        return wareneingangsmeldung;
    }



    public IWarenausgangsmeldung createWarenausgangsmeldung(int menge, Date datum, IProdukt produkt) {
        Warenausgangsmeldung warenausgangsmeldung = new Warenausgangsmeldung(menge, datum, produkt);
        save(warenausgangsmeldung);
        return warenausgangsmeldung;
    }

    // Saves
    private <T> void save(T lagerMeldung) {
        persistenz.saveObject(lagerMeldung);
    }

    // Updates
    public void Wareneingangsmeldung(IWareneingangsmeldung wareneingangsmeldung) {
        persistenz.updateObject(wareneingangsmeldung);
    }
    public void Warenausgangsmeldung(IWarenausgangsmeldung warenausgangsmeldung) {
        persistenz.updateObject(warenausgangsmeldung);
    }

    // Getter
    public IWareneingangsmeldung getWareneingangsmeldung(int id){
        return persistenz.getObjectByID(id, Wareneingangsmeldung.class);
    }

    public IWarenausgangsmeldung getWarenausgangsmeldung(int id){
        return persistenz.getObjectByID(id, Warenausgangsmeldung.class);
    }




}
