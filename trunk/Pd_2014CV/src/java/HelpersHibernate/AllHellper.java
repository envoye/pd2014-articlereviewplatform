/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelpersHibernate;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Carlos
 */
public class AllHellper {

    public static <T> Boolean SaveQualquerCoisa(T i) {
        Session session = GeralHelper.GetSession();
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //t.getClass().toString()
            session.save(i);

            //Commit the transaction
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        }
        return true;
    }

    public static List<? extends Object> getListQualquerCoisa(Class classObj) {
        Session session = GeralHelper.GetSession(); //HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from " + classObj.getSimpleName());

        return q.list();
    }

    public static List<? extends Object> getListQualquerCoisaCondicao(Class classObj, String condicao) {
        Session session = GeralHelper.GetSession(); //HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from " + classObj.getSimpleName() + condicao);

        return q.list();
    }

    public static Object getQualquerCoisaCondicao(Class classObj, String condicao) {
        Session session = GeralHelper.GetSession(); //HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from " + classObj.getSimpleName() + condicao);

        return q.uniqueResult();
    }

}
