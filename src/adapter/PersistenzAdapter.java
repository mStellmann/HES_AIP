package adapter;

import komponentenInterfaces.intern.IPersitenz;

/**
 * Created with IntelliJ IDEA.
 * User: aaz527
 * Date: 19.04.13
 * Time: 13:30
 * To change this template use File | Settings | File Templates.
 */
public class PersistenzAdapter implements IPersitenz {
    @Override
    public <T> void saveObject(T objectToSave) {
        // todo
    }

    @Override
    public <T> T getObject(int id, Class<T> tClass) {
        return null;  // todo
    }

    @Override
    public <T> void updateObject(int id, Class<T> tClass) {
        // todo
    }
}
