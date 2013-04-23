package komponentenFassaden;

import interfaces.IBestellung;
import interfaces.IProdukt;
import interfaces.IWarenausgangsmeldung;
import interfaces.IWareneingangsmeldung;
import komponentenInterfaces.extern.ILagerverwaltungExtern;
import komponentenInterfaces.intern.IEinkaufsverwaltungIntern;
import komponentenInterfaces.intern.ILagerverwaltungIntern;
import komponentenInterfaces.intern.IPersitenz;
import komponentenInterfaces.intern.IProduktverwaltungIntern;
import komponentenLogik.LagerverwaltungLogik;
import komponentenRepositories.LagerverwaltungRepository;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 13:10
 * To change this template use File | Settings | File Templates.
 */
public class LagerverwaltungFassade implements ILagerverwaltungIntern, ILagerverwaltungExtern {
    private LagerverwaltungLogik logik;
    private LagerverwaltungRepository repositorie;

    public LagerverwaltungFassade(IProduktverwaltungIntern produkt, IEinkaufsverwaltungIntern einkauf, IPersitenz persistenz) {

        repositorie = new LagerverwaltungRepository(persistenz);
        logik = new LagerverwaltungLogik(repositorie, produkt, einkauf);
    }

    public IWareneingangsmeldung createWareneingangsmeldung(int bestellNr, Date datum, IBestellung bestellung)   {
                   return repositorie.createWareneingangsmeldung(bestellNr, datum, bestellung);
    }

    public IWarenausgangsmeldung createWarenausgangsmeldung(int menge, Date datum, IProdukt produkt){
                      return repositorie.createWarenausgangsmeldung(menge,datum,produkt);
    }

    @Override
    public boolean pruefeLagerbestand(int produktNummer, int geforderteProduktMenge) {
        return logik.pruefeLagerbestand(produktNummer,geforderteProduktMenge);
       // return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
