/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HelpersHibernate;

import HibernatePackage.Conferencia;
import HibernatePackage.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Carlos
 */
public class ConferenceHelper<T> {
    Session session = null;

    public ConferenceHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
 public List<T> getConferences(T t) {
    List<T> conferenciaList = null;
    try {
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("from " + t.getClass().toString());
        conferenciaList = (List<T>) q.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return conferenciaList;
}
}
