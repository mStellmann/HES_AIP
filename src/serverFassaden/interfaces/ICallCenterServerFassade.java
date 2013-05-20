package serverFassaden.interfaces;

import komponentenFassaden.AngebotsverwaltungFassade;
import komponentenFassaden.AuftragsverwaltungFassade;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 20.05.13
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */
public interface ICallCenterServerFassade extends Remote{

    AngebotsverwaltungFassade getAngebotsverwqaltungFassade() throws RemoteException;
    AuftragsverwaltungFassade getAuftragverwaltungFassade() throws RemoteException;

}
