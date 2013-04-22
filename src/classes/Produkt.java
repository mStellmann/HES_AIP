package classes;

import interfaces.*;

import java.util.List;

/**
 *
 */
public class Produkt implements IProdukt {
    private int produktNummer;
    private String name;
    private int lagerbestand;

    private Orderbuch orderbuch;
    private List<IWarenausgangsmeldung> warenausgangsmeldungList;
    private List<IAngebot> angebotList;
    private List<IEinkaufsinfosatz> einkaufsinfosatzList;
    private List<IBestellung> bestellungList;
}
