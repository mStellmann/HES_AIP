package komponentenInterfaces.intern;

import interfaces.IAuftrag;
import interfaces.ITransportauftrag;

import java.util.List;

/**
 * User: Matthias
 * Date: 22.04.13
 * Time: 21:05
 */
public interface ITransportdienstleisterAdapter {
    ITransportauftrag verschickeAuftrag(IAuftrag auftrag);
    List<String> getAuftaege();
}


