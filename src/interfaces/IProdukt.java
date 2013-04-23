package interfaces;
import classes.Orderbuch;
import java.util.List;

public interface IProdukt {
    int getProduktNummer();
    String getProduktName();
    int getLagerbestand();
    Orderbuch getOrderbuch();
    List<IWarenausgangsmeldung> getWarenausgangsmeldungList();
    List<IAngebot> getAngebotList();
    List<IEinkaufsinfosatz> getEinkaufsinfosatzList();
    List<IBestellung> getBestellungList();
    void putWarenausgangsmeldungToList(IWarenausgangsmeldung warenausgangsmeldung);
    void putAngebotToList(IAngebot angebot);
    void putEinkaufsinfosatzToList(IEinkaufsinfosatz einkaufsinfosatz);
    void putBestellung(IBestellung bestellung);
}
