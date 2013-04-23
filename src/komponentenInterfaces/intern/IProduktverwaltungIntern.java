package komponentenInterfaces.intern;

import interfaces.IProdukt;
import typClasses.ProduktTyp;

/**
 *
 */
public interface IProduktverwaltungIntern {
    //boolean istAusreichendVorhanden(int nr, int menge); //soll true zurückliefern wenn Lagerbestand ausreichend

    ProduktTyp getProduktTyp(int nr);     // liefert AF mit Nr Name und Lagerbestand

    void lagerbestendReduzieren(int rausgehendeMenge);

    boolean nrIstVorhanden(int warenNr);

    IProdukt getProdukt(int warenNr);
}
