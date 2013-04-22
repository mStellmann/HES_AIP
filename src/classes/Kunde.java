package classes;

import interfaces.IAngebot;
import interfaces.IKunde;

import java.util.List;

/**
 *
 */
public class Kunde implements IKunde {
    private int kundenNummer;
    private String name;
    private String adresse;

    private List<IAngebot> angebotsList;
}
