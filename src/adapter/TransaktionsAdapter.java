package adapter;

import komponentenInterfaces.intern.ITransaktionsAdapter;
import org.hibernate.Session;

/**
 * Created with IntelliJ IDEA.
 * User: aaz527
 * Date: 19.04.13
 * Time: 13:30
 * To change this template use File | Settings | File Templates.
 */
public class TransaktionsAdapter implements ITransaktionsAdapter {
    private Session session;

    public TransaktionsAdapter(Session session) {
        this.session = session;
    }
}
