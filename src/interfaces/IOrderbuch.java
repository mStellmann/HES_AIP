package interfaces;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: aaz527
 * Date: 19.04.13
 * Time: 12:42
 * To change this template use File | Settings | File Templates.
 */
public interface IOrderbuch {

    IProdukt getProdukt();

    void setProdukt(IProdukt produkt);

    List<IOrderbuchsatz> getOrderbuchsatzList();

    void setOrderbuchsatzList(List<IOrderbuchsatz> orderbuchsatzList);
}
