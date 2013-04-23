package interfaces;
import classes.Kunde;

/**
 * Created with IntelliJ IDEA.
 * User: aaz527
 * Date: 19.04.13
 * Time: 12:41
 * To change this template use File | Settings | File Templates.
 */
public interface IKunde {

    int getKundennummer();
    String getKundenname();
    String getAdresse();
    void putAngebotToList(IAngebot angebot);
}
