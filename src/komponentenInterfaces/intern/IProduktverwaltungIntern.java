package komponentenInterfaces.intern;

import interfaces.IProdukt;
import typClasses.ProduktTyp;

/**
 *
 */
public interface IProduktverwaltungIntern {
    void lagerbestendReduzieren(int rausgehendeMenge);

    boolean nrIstVorhanden(int warenNr);

    IProdukt getProdukt(int warenNr);

    IProdukt createProdukt(String name, int lagerbestand);
}
