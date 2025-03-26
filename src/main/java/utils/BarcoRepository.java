package utils;

import barcos.Barco;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BarcoRepository {
    public void guardarBarco(Barco barco) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(barco);
        tx.commit();
        session.close();
    }
}
