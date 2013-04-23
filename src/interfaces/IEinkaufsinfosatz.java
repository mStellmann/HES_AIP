package interfaces;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: aaz527
 * Date: 19.04.13
 * Time: 12:39
 * To change this template use File | Settings | File Templates.
 */
public interface IEinkaufsinfosatz {

    Date getGueltigAb();

    void setGueltigAb(Date gueltigAb);

    Date getGueltigBis();

    void setGueltigBis(Date gueltigBis);

    int getPlanlieferzeit();

    void setPlanlieferzeit(int planlieferzeit);

    int getNormalmenge();

    void setNormalmenge(int normalmenge);

    float getPreis();

    void setPreis(float preis);

    IProdukt getProdukt();

    void setProdukt(IProdukt produkt);
}
