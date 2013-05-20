package serverFassaden;

import komponentenFassaden.AngebotsverwaltungFassade;
import komponentenFassaden.AuftragsverwaltungFassade;
import serverFassaden.interfaces.ICallCenterServerFassade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 13:08
 * To change this template use File | Settings | File Templates.
 */
public class CallCenterServerFassade extends UnicastRemoteObject implements ICallCenterServerFassade {
    private AngebotsverwaltungFassade angebotsverwaltungFassade;
    private AuftragsverwaltungFassade auftragsverwaltungFassade;

    public CallCenterServerFassade(AngebotsverwaltungFassade angebotsverwaltungFassade,AuftragsverwaltungFassade auftragsverwaltungFassade) throws RemoteException {
        super();
        this.angebotsverwaltungFassade = angebotsverwaltungFassade;
        this.auftragsverwaltungFassade = auftragsverwaltungFassade;


    }


    @Override
    public AngebotsverwaltungFassade getAngebotsverwqaltungFassade() throws RemoteException {
        return angebotsverwaltungFassade;
    }

    @Override
    public AuftragsverwaltungFassade getAuftragverwaltungFassade() throws RemoteException {
        return auftragsverwaltungFassade;
    }
}
