package adapter;

import interfaces.IZahlungseingang;
import komponentenInterfaces.intern.IBankAdapter;

// TODO - Jersey sendToTDL()
public class BankAdapter implements IBankAdapter {
    @Override
    public IZahlungseingang getNaechstenZahlungseingang() {
        return null;  // TODO
    }
}
