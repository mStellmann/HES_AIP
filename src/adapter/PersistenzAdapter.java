package adapter;

import komponentenInterfaces.intern.IPersitenz;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class PersistenzAdapter implements IPersitenz {
    private Session session;

    public PersistenzAdapter(Session session) {
        this.session = session;
    }

    @Override
    public <T> void saveObject(T objectToSave) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(objectToSave);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
    }

    @Override
    public <T> T getObjectByID(int id, Class<T> tClass) {
        Transaction transaction = null;
        T obj = null;
        try {
            transaction = session.beginTransaction();
            obj = (T) session.get(tClass, id);
            transaction.commit();

        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        return obj;
    }

    @Override
    public <T> void updateObject(T objectToUpdate) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(objectToUpdate);
            transaction.commit();

        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
    }
}
