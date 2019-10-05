package bl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HIbernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try{
            return new Configuration().configure().buildSessionFactory();
        }catch (Throwable e){
            throw new ExceptionInInitializerError(e);
        }
        }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void shutdown(Session session){
        session.close();
        getSessionFactory().close();
    }

}
