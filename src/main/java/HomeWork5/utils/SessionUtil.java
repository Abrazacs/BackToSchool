package HomeWork5.utils;


import org.hibernate.Session;
import org.hibernate.Transaction;

public class SessionUtil {

    private Session session;
    private Transaction transaction;

    public Session openSession(){
        session = SessionInitializer.getSessionFactory().openSession();
        return session;
    }

    public void closeSession(){
        session.close();
    }

    public Session openTransaction(){
        session = openSession();
        transaction = session.beginTransaction();
        return session;
    }

    public void closeTransaction(){
        transaction.commit();
        closeSession();
    }

}
