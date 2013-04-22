package komponentenInterfaces.extern;

import typClasses.AngebotTyp;
import typClasses.AuftragTyp;
import typClasses.LieferungTyp;
import typClasses.RechnungTyp;

import java.util.Date;

/**
 *
 */
public interface IAuftragsverwaltungExtern {
    AuftragTyp erstelleAuftrag(int auftragsNummer, Date beauftragtAm, AngebotTyp angebot, LieferungTyp lieferung, RechnungTyp rechnung);
}