package interfaces;

import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: aaz527
 * Date: 19.04.13
 * Time: 12:37
 * To change this template use File | Settings | File Templates.
 */
public interface IAngebot {
    int getAngebotsNummer();

    void addProduktMenge(IProdukt produkt, int Menge);

    Date getGueltigAb();

    Date getGueltigBis();

    float getGesamtPreis();

    void setGesamtPreis(float gesamtPreis);

    IKunde getKunde();

    void setKunde(IKunde kunde);

    IAuftrag getAuftrag();

    void setAuftrag(IAuftrag auftrag);

    Map<IProdukt, Integer> getProduktMengeMap();

    void setProduktMengeMap(Map<IProdukt, Integer> produktMengeMap);
}
