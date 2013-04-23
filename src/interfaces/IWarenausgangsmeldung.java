package interfaces;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: aaz527
 * Date: 19.04.13
 * Time: 12:46
 * To change this template use File | Settings | File Templates.
 */
public interface IWarenausgangsmeldung {

    Date getDatum();

    void setDatum(Date datum);

    int getMenge();

    void setMenge(int menge);

    IProdukt getProdukt();

    void setProdukt(IProdukt produkt);
}
