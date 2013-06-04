package komponentenInterfaces.intern;

import interfaces.IRechnung;
import interfaces.IZahlungseingang;

/**
 * User: Matthias
 * Date: 22.04.13
 * Time: 21:05
 */
public interface IBankAdapter {
    IZahlungseingang getNaechstenZahlungseingang();
}
