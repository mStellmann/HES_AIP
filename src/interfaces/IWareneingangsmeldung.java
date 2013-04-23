package interfaces;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: aaz527
 * Date: 19.04.13
 * Time: 12:46
 * To change this template use File | Settings | File Templates.
 */
public interface IWareneingangsmeldung {

    Date getDatum();

    void setDatum(Date datum);

    int getBestellNr();

    void setBestellNr(int bestellNr);

    IBestellung getBestellung();

    void setBestellung(IBestellung bestellung);
}
