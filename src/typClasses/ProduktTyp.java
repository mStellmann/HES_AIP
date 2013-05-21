package typClasses;

import classes.Orderbuch;
import interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class ProduktTyp {

    private int produktNummer;
    private String produktName;
    private int lagerbestand;

//    private Orderbuch orderbuch;
//    private List<IWarenausgangsmeldung> warenausgangsmeldungList = new ArrayList<IWarenausgangsmeldung>();
//    private List<IAngebot> angebotList = new ArrayList<IAngebot>();
//    private List<IEinkaufsinfosatz> einkaufsinfosatzList = new ArrayList<IEinkaufsinfosatz>();
//    private List<IBestellung> bestellungList = new ArrayList<IBestellung>();

    public ProduktTyp(int produktNummer, String produktName, int lagerbestand) {
        this.produktNummer = produktNummer;
        this.produktName = produktName;
        this.lagerbestand = lagerbestand;
    }

    public ProduktTyp(IProdukt produkt) {
        this(produkt.getProduktNummer(), produkt.getProduktName(), produkt.getLagerbestand());
    }

    public int getProduktNummer() {
        return produktNummer;
    }

    public String getProduktName() {
        return produktName;
    }

    public int getLagerbestand() {
        return lagerbestand;
    }


//    public Orderbuch getOrderbuch() {
//        return orderbuch;
//    }
//
//    public List<IWarenausgangsmeldung> getWarenausgangsmeldungList() {
//        return warenausgangsmeldungList;
//    }
//
//    public List<IAngebot> getAngebotList() {
//        return angebotList;
//    }
//
//    public List<IEinkaufsinfosatz> getEinkaufsinfosatzList() {
//        return einkaufsinfosatzList;
//    }
//
//    public List<IBestellung> getBestellungList() {
//        return bestellungList;
//    }
}
