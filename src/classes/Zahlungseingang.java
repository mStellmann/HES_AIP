package classes;

import interfaces.IRechnung;
import interfaces.IZahlungseingang;

import java.util.Date;

/**
 *
 */
public class Zahlungseingang implements IZahlungseingang {
    private Date eingangsdatum;
    private float betrag;

    private IRechnung rechnung;
}
