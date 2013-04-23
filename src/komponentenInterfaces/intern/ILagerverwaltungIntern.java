package komponentenInterfaces.intern;

import interfaces.IBestellung;
import interfaces.IProdukt;
import interfaces.IWarenausgangsmeldung;
import interfaces.IWareneingangsmeldung;

import java.util.Date;

/**
 *
 */
public interface ILagerverwaltungIntern {
    boolean pruefeLagerbestand(int produktNummer, int geforderteProduktMenge);
    IWareneingangsmeldung createWareneingangsmeldung(int bestellNr, Date datum, IBestellung bestellung);
    public IWarenausgangsmeldung createWarenausgangsmeldung(int menge, Date datum, IProdukt produkt);
}
