package classes;

import interfaces.IAngebot;
import interfaces.IAuftrag;
import interfaces.ILieferung;
import interfaces.IRechnung;

import java.util.Date;

/**
 *
 */
public class Auftrag implements IAuftrag {
    private int auftragsNummer;
    private boolean istAbgeschlossen;
    private Date beauftragtAm;

    private IAngebot angebot;
    private ILieferung lieferung;
    private IRechnung rechnung;
}
