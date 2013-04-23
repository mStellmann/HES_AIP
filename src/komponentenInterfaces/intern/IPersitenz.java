package komponentenInterfaces.intern;

/**
 * User: Matthias
 * Date: 22.04.13
 * Time: 21:06
 */
public interface IPersitenz {
    <T> void saveObject(T objectToSave);

    <T> T getObjectByID(int id, Class<T> tClass);

    <T> void updateObject(T objectToUpdate);
}
