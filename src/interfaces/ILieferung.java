package interfaces;

/**
 * Created with IntelliJ IDEA.
 * User: aaz527
 * Date: 19.04.13
 * Time: 12:41
 * To change this template use File | Settings | File Templates.
 */
public interface ILieferung {
    int getLieferungsNummer();

    ITransportauftrag getTransportauftrag();

    void setTransportauftrag(ITransportauftrag transportauftrag);

    IAuftrag getAuftrag();

    void setAuftrag(IAuftrag auftrag);
}
