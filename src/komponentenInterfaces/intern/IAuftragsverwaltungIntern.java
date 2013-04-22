package komponentenInterfaces.intern;

import interfaces.IAuftrag;
import interfaces.ILieferung;

/**
 *
 */
public interface IAuftragsverwaltungIntern {
    ILieferung erstelleLieferung(int lieferungsNummer);

    void markiereAuftragAlsVerschickt(int auftragsNummer);

    void auftragAbschliessen(int auftragsNummer);
}
