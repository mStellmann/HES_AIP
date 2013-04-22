package komponentenInterfaces.intern;

/**
 * User: Matthias
 * Date: 22.04.13
 * Time: 21:06
 */
public interface IPersitenz {
    <T> void saveObject(T objectToSave);

    <T> T getObject(int id, Class<T> tClass);

    <T> void updateObject(int id, Class<T> tClass);
}
