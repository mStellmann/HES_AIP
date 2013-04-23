package komponentenInterfaces.intern;

import interfaces.IAngebot;
import interfaces.IAuftrag;
import interfaces.ILieferung;
import interfaces.ITransportauftrag;

import java.util.Date;

/**
 *
 */
public interface IAuftragsverwaltungIntern {
    ILieferung erstelleLieferung();

    IAuftrag erstelleAuftrag(Date beauftragtAm, IAngebot angebot);

    ITransportauftrag erstelleTransportauftrag(Date ausgangsdatum, String transportdienstleister);

    ITransportauftrag getTransportauftrag(int transportauftragsNummer);

    IAuftrag getAuftrag(int auftragsNummer);

    ILieferung getLieferung(int lieferungsNummer);

    void markiereAuftragAlsVerschickt(int auftragsNummer);

    void auftragAbschliessen(int auftragsNummer);
}
