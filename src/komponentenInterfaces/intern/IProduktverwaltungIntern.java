package komponentenInterfaces.intern;

import interfaces.IProdukt;
import typClasses.ProduktTyp;

import java.util.List;

/**
 *
 */
public interface IProduktverwaltungIntern {
    void lagerbestendReduzieren(int rausgehendeMenge);

    boolean nrIstVorhanden(int warenNr);

    IProdukt getProdukt(int warenNr);

    IProdukt createProdukt(String name, int lagerbestand);

    List<? extends IProdukt> getAllProdukte();

    IProdukt getProdukt(String name);
}
