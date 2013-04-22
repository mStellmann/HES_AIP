package classes;

import interfaces.IBestellung;
import interfaces.IEinkaufsinfosatz;
import interfaces.ILieferant;
import interfaces.IOrderbuchsatz;

import java.util.List;

/**
 *
 */
public class Lieferant implements ILieferant {
    private int lieferantenNummer;
    private String name;
    private String adresse;
    private String kontoverbindung;

    private List<IEinkaufsinfosatz> einkaufsinfosatzList;
    private List<IBestellung> bestellungList;
    private List<IOrderbuchsatz> orderbuchsatzList;
}
