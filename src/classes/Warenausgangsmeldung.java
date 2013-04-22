package classes;

import interfaces.IBestellung;
import interfaces.IWarenausgangsmeldung;

import java.util.Date;

/**
 *
 */
public class Warenausgangsmeldung implements IWarenausgangsmeldung {
    private int lieferschein; // idnummer vom lieferschein (bar-code)
    private Date datum;

    private IBestellung bestellung;
}
