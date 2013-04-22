package classes;

import interfaces.ILieferung;
import interfaces.ITransportauftrag;

import java.util.Date;

/**
 *
 */
public class Transportauftrag implements ITransportauftrag {
    private int transportauftragsNummer;
    private Date ausgangsdatum;
    private boolean lieferungErfolgt = false;
    private Date lieferdatum;
    private String transportdienstleister;

    private ILieferung lieferung;
}
