package komponentenInterfaces.intern;

import typClasses.ProduktTyp;

/**
 *
 */
public interface IProduktverwaltungIntern {
    boolean istAusreichendVorhanden(int nr); //soll true zurückliefern wenn Lagerbestand ausreichend

    ProduktTyp getProduktTyp(int nr);     // liefert AF mit Nr Name und Lagerbestand
}
