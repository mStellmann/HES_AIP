package typClasses;

import interfaces.IAngebot;
import interfaces.IKunde;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 12:41
 * To change this template use File | Settings | File Templates.
 */
public class KundeTyp {

    private int kundenNummer;
    private String name;
    private String adresse;
    private List<IAngebot> angebotsList;

    public KundeTyp(int kundenNummer, String name, String adresse, List<IAngebot> angebotsList) {
        this.kundenNummer = kundenNummer;
        this.name = name;
        this.adresse = adresse;
        this.angebotsList=angebotsList;
    }

    public KundeTyp(IKunde kunde) {
        this(kunde.getKundennummer(),kunde.getKundenname(),kunde.getAdresse(), null); // oh shit null für eine Leere Liste <- Marker fuer spaeter
    }

    public int getKundenNummer() {
        return kundenNummer;
    }

    public String getName() {
        return name;
    }

    public String getAdresse() {
        return adresse;
    }

    public List<IAngebot> getAngebotsList() {
        return angebotsList;
    }
}
