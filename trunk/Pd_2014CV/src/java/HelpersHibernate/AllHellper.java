/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelpersHibernate;

import HibernatePackage.Artigo;
import HibernatePackage.Artigorevisao;
import HibernatePackage.Artigorevisaoitems;
import HibernatePackage.Conferencia;
import HibernatePackage.Conferenciaartigo;
import HibernatePackage.Conferenciacomite;
import HibernatePackage.Conferenciacomiteartigo;
import HibernatePackage.Conferenciaedicao;
import HibernatePackage.Conferenciapoolrevisores;
import HibernatePackage.Contacto;
import HibernatePackage.Grauacademico;
import HibernatePackage.Investigador;
import HibernatePackage.Investigadorareaconhecimento;
import HibernatePackage.Itemrevisao;
import HibernatePackage.Subtema;
import HibernatePackage.Tema;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Carlos
 */
public class AllHellper {

    /**
     *  Insere informação numa tabela da BD mediante o tipo de dados apresentado
     */
    
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

    /**
     *  Elimina informação de uma tabela da BD mediante o tipo de dados apresentado
     */
    
    public static <T> Boolean DelQualquerCoisa(T i) {
        Session session = GeralHelper.GetSession();
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //t.getClass().toString()
            session.delete(i);
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
    
    /**
     *  Conjunto de funções que executam queries à BD
     */
    
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

    /**
     *  Conjunto de funções que permitem atualizar informação existente na BD
     */    
    
    public static Investigador UpdateInvestigador(int id, Grauacademico grauacademico, String nome, String instituicao, Date datanascimento, String utilizador, String email, String telefone, String telemovel) {
        Session session = GeralHelper.GetSession();
        Investigador investigador;
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();

            investigador  = (Investigador) session.get(Investigador.class, id);
            
            investigador.setGrauacademico(grauacademico);
            investigador.setNome(nome);
            investigador.setInstituicao(instituicao);
            investigador.setDatanascimento(datanascimento);
            investigador.setUtilizador(utilizador);
            investigador.setEmail(email);
            investigador.setTelefone(telefone);
            investigador.setTelemovel(telemovel);
            
            session.update(investigador);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return null;
        }
        return investigador;
    }

     public static Investigador UpdatePassInvestigador(int id,String pass) {
        Investigador investigador;
        Session session = GeralHelper.GetSession();
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            investigador = (Investigador) session.get(Investigador.class, id);
            
            investigador.setPassword(pass);
            
            session.update(investigador);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return null;
        }
        return investigador;
    }        
    
    public static Boolean UpdateTema(int id, String nomeTema, String descricao) {
        Session session = GeralHelper.GetSession();
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Tema tema = (Tema) session.get(Tema.class, id);
            
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

    public static Boolean UpdateSubtema(int id, Tema tema, String nome, String descricao) {
        Session session = GeralHelper.GetSession();
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Subtema subtema = (Subtema) session.get(Subtema.class, id);
            
            subtema.setTema(tema);
            subtema.setNome(nome);
            subtema.setDescricao(descricao);
            
            session.update(subtema);

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        }
        return true;
    }        
    
    public static Boolean UpdateItemRevisao(int id, String nomeItem, boolean tipo, boolean privado, String descricao) {
        Session session = GeralHelper.GetSession();
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Itemrevisao item = (Itemrevisao) session.get(Itemrevisao.class, id);

            item.setNomeItem(nomeItem);
            item.setTipo(tipo);
            item.setPrivado(privado);
            item.setDescricao(descricao);

            session.update(item);

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        }
        return true;
    }    
    
    public static Boolean UpdateAreaConhecimento(int id, Subtema subtema, Investigador investigador, Byte grauConfianca, Byte preferencia) {
        Session session = GeralHelper.GetSession();
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Investigadorareaconhecimento area = (Investigadorareaconhecimento) session.get(Investigadorareaconhecimento.class, id);

            area.setSubtema(subtema);
            area.setInvestigador(investigador);
            area.setGrauConfianca(grauConfianca);
            area.setPreferencia(preferencia);
            
            session.update(area);

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        }
        return true;
    }        
    
    public static Boolean UpdateGrauAcademico(int id, String grauacademico) {
        Session session = GeralHelper.GetSession();
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Grauacademico grau = (Grauacademico) session.get(Grauacademico.class, id);

            grau.setGrauacademico(grauacademico);
            
            session.update(grau);

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        }
        return true;
    }
    
    public static Boolean UpdateContacto(int id, Investigador inv1, Investigador inv2, int idContacto) {
        Session session = GeralHelper.GetSession();
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Contacto contacto = (Contacto) session.get(Contacto.class, id);

            contacto.setInvestigadorByInvestigadorContactId(inv1);
            contacto.setInvestigadorByIdInvestigador(inv2);
            contacto.setIdContacto(idContacto);
            
            session.update(contacto);

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        }
        return true;
    }    
    
    public static Boolean UpdateConferenciaPoolRevisores(int id, Conferenciaedicao conferenciaedicao, Investigador investigador, Byte classificacao, String estado, Date dataInicioConvite, Date dataFimConvite) {
        Session session = GeralHelper.GetSession();
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Conferenciapoolrevisores poolRevisores = (Conferenciapoolrevisores) session.get(Conferenciapoolrevisores.class, id);

            poolRevisores.setConferenciaedicao(conferenciaedicao);
            poolRevisores.setInvestigador(investigador);
            poolRevisores.setClassificacao(classificacao);
            poolRevisores.setEstado(estado);
            poolRevisores.setDataInicioConvite(dataInicioConvite);
            poolRevisores.setDataFimConvite(dataFimConvite);
            
            session.update(poolRevisores);

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        }
        return true;
    }
    
    public static Boolean UpdateConferenciaEdicao(Integer id, Tema tema, Conferencia conferencia, String subNomeConferencia, String descricao, Date data, String local, int edicao, Date dataLimiteSubmissao, Short maxArtigosRevisor, Short maxArtigos, Boolean configuracaoEncerrada) {
        Session session = GeralHelper.GetSession();
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Conferenciaedicao conferenciaedicao = (Conferenciaedicao) session.get(Conferenciaedicao.class, id);

            conferenciaedicao.setTema(tema);
            conferenciaedicao.setConferencia(conferencia);
            conferenciaedicao.setSubNomeConferencia(subNomeConferencia);
            conferenciaedicao.setDescricao(descricao);
            conferenciaedicao.setData(data);
            conferenciaedicao.setLocal(local);
            conferenciaedicao.setEdicao(edicao);
            conferenciaedicao.getDataLimiteSubmissao();
            conferenciaedicao.setMaxArtigosRevisor(maxArtigosRevisor);
            conferenciaedicao.setMaxArtigos(maxArtigos);
            conferenciaedicao.setConfiguracaoEncerrada(configuracaoEncerrada);
            
            session.update(conferenciaedicao);

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        }
        return true;
    }    
    
        public static Boolean UpdateConferenciaComiteArtigo(Integer id, Conferenciacomite conferenciacomite, Artigo artigo, String estado, Date dataInicioLicitacao, Date dataFimLicitacao, Byte pontuacao, Byte pontuacaoComite) {
        Session session = GeralHelper.GetSession();
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Conferenciacomiteartigo conferenciacomiteartigo = (Conferenciacomiteartigo) session.get(Conferenciacomiteartigo.class, id);

            conferenciacomiteartigo.setConferenciacomite(conferenciacomite);
            conferenciacomiteartigo.setArtigo(artigo);
            conferenciacomiteartigo.setEstado(estado);
            conferenciacomiteartigo.setDataInicioLicitacao(dataInicioLicitacao);
            conferenciacomiteartigo.setDataFimLicitacao(dataFimLicitacao);
            conferenciacomiteartigo.setPontuacao(pontuacao);
            conferenciacomiteartigo.setPontuacaoComite(pontuacaoComite);
            
            session.update(conferenciacomiteartigo);

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        }
        return true;
    }    
    
    public static Boolean UpdateConferenciaComite(Integer id, Conferenciaedicao conferenciaedicao, Investigador investigador, Boolean aceite) {
        Session session = GeralHelper.GetSession();
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Conferenciacomite conferenciacomite = (Conferenciacomite) session.get(Conferenciacomite.class, id);

            conferenciacomite.setConferenciaedicao(conferenciaedicao);
            conferenciacomite.setInvestigador(investigador);
            conferenciacomite.setAceite(aceite);
            
            session.update(conferenciacomite);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        }
        return true;
    }    
        
    public static Boolean UpdateConferenciaArtigo(Integer id, Conferenciaedicao conferenciaedicao, Artigo artigo, Boolean publicar) {
        Session session = GeralHelper.GetSession();
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Conferenciaartigo conferenciaartigo = (Conferenciaartigo) session.get(Conferenciaartigo.class, id);

            conferenciaartigo.setConferenciaedicao(conferenciaedicao);
            conferenciaartigo.setArtigo(artigo);
            conferenciaartigo.setPublicar(publicar);
            
            session.update(conferenciaartigo);

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        }
        return true;
    }    

    public static Boolean UpdateConferencia(Integer id, Investigador investigador, String nome) {
        Session session = GeralHelper.GetSession();
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Conferencia conferencia = (Conferencia) session.get(Conferencia.class, id);

            conferencia.setInvestigador(investigador);
            conferencia.setNome(nome);
            
            session.update(conferencia);

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        }
        return true;
    }        
    
    public static Boolean UpdateArtigoRevisaoItems(Integer id, Artigorevisao artigorevisao, Itemrevisao itemrevisao, Byte classificacao, String descricao) {
        Session session = GeralHelper.GetSession();
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Artigorevisaoitems artigorevisaoitems = (Artigorevisaoitems) session.get(Artigorevisaoitems.class, id);

            artigorevisaoitems.setArtigorevisao(artigorevisao);
            artigorevisaoitems.setItemrevisao(itemrevisao);
            artigorevisaoitems.setClassificacao(classificacao);
            artigorevisaoitems.setDescricao(descricao);
            
            session.update(artigorevisaoitems);

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        }
        return true;
    }
    
    public static Boolean UpdateArtigoRevisao(Integer id, Conferenciacomiteartigo conferenciacomiteartigo, Conferenciapoolrevisores conferenciapoolrevisores, Byte preferencia, Boolean estadoRevisor, Boolean estadoAuto, Boolean estadoGc, Byte pontuacao) {
        Session session = GeralHelper.GetSession();
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Artigorevisao artigorevisao = (Artigorevisao) session.get(Artigorevisao.class, id);

            artigorevisao.setConferenciacomiteartigo(conferenciacomiteartigo);
            artigorevisao.setConferenciapoolrevisores(conferenciapoolrevisores);
            artigorevisao.setPreferencia(preferencia);
            artigorevisao.setEstadoRevisor(estadoRevisor);
            artigorevisao.setEstadoAuto(estadoAuto);
            artigorevisao.setEstadoGc(estadoGc);
            artigorevisao.setPontuacao(pontuacao);
            
            session.update(artigorevisao);

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        }
        return true;
    }
    
    public static Boolean UpdateArtigo(Integer id, Subtema subtema, String titulo, String resumo, Date data, String link, String ficheiroPdf, String palavrasChave) {
        Session session = GeralHelper.GetSession();
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Artigo artigo = (Artigo) session.get(Artigo.class, id);
            
            artigo.setSubtema(subtema);
            artigo.setTitulo(titulo);
            artigo.setResumo(resumo);
            artigo.setData(data);
            artigo.setLink(link);
            artigo.setFicheiroPdf(ficheiroPdf);
            artigo.setPalavrasChave(palavrasChave);

            session.update(artigo);

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
