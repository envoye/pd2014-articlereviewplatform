/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HelpersHibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Carlos
 */
public class GeralHelper {
 private static SessionFactory sf = null;

    public static Session GetSession() {
        if (sf == null) {
            sf = HibernateUtil.getSessionFactory();
        }
        sf.getCurrentSession().close();
        return sf.openSession();

    }   
}
