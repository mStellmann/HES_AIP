package classes;

import interfaces.IAngebot;
import interfaces.IAuftrag;
import interfaces.IKunde;
import interfaces.IProdukt;

import java.util.Date;
import java.util.Map;

/**
 *
 */
public class Angebot implements IAngebot {
    private int angebotsNummer;
    private Date gueltigAb;
    private Date gueltigBis;
    private float gesamtPreis;

    private IKunde kunde;
    private IAuftrag auftrag;
    private Map<IProdukt, Integer> produktMengeMap;

    @Override
    public int getAngebotNr() {
        return 0;  // todo
    }

    @Override
    public void addProduktMenge(IProdukt produkt, int Menge) {
        // todo
    }
}
