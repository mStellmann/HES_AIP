package komponentenInterfaces.intern;

import interfaces.IAuftrag;
import interfaces.ILieferung;

/**
 *
 */
public interface IAuftragsverwaltungIntern {
    ILieferung erstelleLieferung();

    void markiereAuftragAlsVerschickt(int auftragsNummer);

    void auftragAbschliessen(int auftragsNummer);
}
