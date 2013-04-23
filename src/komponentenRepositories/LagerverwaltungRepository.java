package komponentenRepositories;

import classes.Warenausgangsmeldung;
import classes.Wareneingangsmeldung;
import interfaces.IWarenausgangsmeldung;
import interfaces.IWareneingangsmeldung;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 13:29
 * To change this template use File | Settings | File Templates.
 */
public class LagerverwaltungRepository {
    public IWareneingangsmeldung createWareneingangsmeldung(int bestellNr, Date datum) {
        return new Wareneingangsmeldung(bestellNr, datum);
    }

    public IWarenausgangsmeldung createWarenausgangsmeldung(int menge, Date datum) {
        return new Warenausgangsmeldung(menge,datum);
    }
}
