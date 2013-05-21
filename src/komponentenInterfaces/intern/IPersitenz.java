package komponentenInterfaces.intern;

import java.util.List;

/**
 * User: Matthias
 * Date: 22.04.13
 * Time: 21:06
 */
public interface IPersitenz {
    <T> void saveObject(T objectToSave);

    <T> T getObjectByID(int id, Class<T> tClass);

    <T> void updateObject(T objectToUpdate);

    <T> List<T> getAllObjects(Class<T> tClass);

    <T> T searchObjectByName(String name, Class<T> tClass);
}
