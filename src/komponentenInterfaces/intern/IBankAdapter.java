package komponentenInterfaces.intern;

import interfaces.IZahlungseingang;
import org.javatuples.Pair;


/**
 * User: Matthias
 * Date: 22.04.13
 * Time: 21:05
 */
public interface IBankAdapter {
    // Integer-Wert == Rechnungsnummer
    Pair<IZahlungseingang, Integer> getNaechstenZahlungseingang();
}
