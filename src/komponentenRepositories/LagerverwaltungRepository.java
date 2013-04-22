package komponentenRepositories;

import classes.Warenausgangsmeldung;
import classes.Wareneingangsmeldung;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 13:29
 * To change this template use File | Settings | File Templates.
 */
public class LagerverwaltungRepository {
    public Wareneingangsmeldung createWareneingangsmeldung(int bestellNr, Date datum) {
        return new Wareneingangsmeldung(bestellNr, datum);
    }

    public Warenausgangsmeldung createWarenausgangsmeldung() {
        return new Warenausgangsmeldung();
    }
}
