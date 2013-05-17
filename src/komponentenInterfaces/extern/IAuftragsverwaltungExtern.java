package komponentenInterfaces.extern;

import typClasses.AngebotTyp;
import typClasses.AuftragTyp;
import typClasses.LieferungTyp;
import typClasses.RechnungTyp;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 *
 */
public interface IAuftragsverwaltungExtern extends Remote {
    AuftragTyp erstelleAuftrag(Date beauftragtAm, AngebotTyp angebot) throws RemoteException;

    List<AuftragTyp> getAlleAuftraege() throws RemoteException;

    AuftragTyp sucheAuftrag(int id) throws RemoteException;
}
