package interfaces;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: aaz527
 * Date: 19.04.13
 * Time: 12:43
 * To change this template use File | Settings | File Templates.
 */
public interface IOrderbuchsatz {

    Date getGueltigAb();

    void setGueltigAb(Date gueltigAb);

    Date getGueltigBis();

    void setGueltigBis(Date gueltigBis);

    ILieferant getLieferant();

    void setLieferant(ILieferant lieferant);

    IOrderbuch getOrderbuch();

    void setOrderbuch(IOrderbuch orderbuch);
}
