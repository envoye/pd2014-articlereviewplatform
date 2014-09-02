/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelpersHibernate;

import HibernatePackage.Investigador;
import HibernatePackage.Tema;
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
            System.out.println(i);
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
        Query q;
        try {
            Session session = GeralHelper.GetSession(); //HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            q = session.createQuery("from " + classObj.getSimpleName());
        } catch (Exception e) {

            return null;
        }
        return q.list();
    }

    public static List<? extends Object> getListQualquerCoisaCondicao(Class classObj, String condicao) {
        Query q;
        try {
            Session session = GeralHelper.GetSession(); //HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            q = session.createQuery("from " + classObj.getSimpleName() + condicao);
        } catch (Exception e) {

            return null;
        }
        return q.list();
    }

    public static List<? extends Object> getListArtigosInvestigador(String condicao) {
        Query q;
        try {
            Session session = GeralHelper.GetSession(); //HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            q = session.createQuery(condicao);
        } catch (Exception e) {

            return null;
        }
        return q.list();
    }

    public static Object getQualquerCoisaCondicao(Class classObj, String condicao) {
        Session session = GeralHelper.GetSession(); //HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from " + classObj.getSimpleName() + condicao);

        return q.uniqueResult();
    }

    public static Boolean UpdateInvestigador(int idInvestigador) {
        Session session = GeralHelper.GetSession();
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Investigador investigador
                    = (Investigador) session.get(Investigador.class, idInvestigador);
               investigador.setInstituicao(null);
            session.update(investigador);

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        }
        return true;
    }

        public static Boolean UpdateTema(int idTema, String nomeTema, String descricao) {
        Session session = GeralHelper.GetSession();
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Tema tema = (Tema) session.get(Tema.class, idTema);
            tema.setNomeTema(nomeTema);
            tema.setDescricao(descricao);
            session.update(tema);

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        }
        return true;
    }
    
}
