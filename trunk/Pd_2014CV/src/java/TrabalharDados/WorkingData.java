/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalharDados;

import HelpersHibernate.AllHellper;
import HibernatePackage.Artigo;
import HibernatePackage.Conferencia;
import HibernatePackage.Conferenciaartigo;
import HibernatePackage.Conferenciacomite;
import HibernatePackage.Conferenciaedicao;
import HibernatePackage.Conferenciapoolrevisores;
import HibernatePackage.Contacto;
import HibernatePackage.Investigador;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author Carlos
 */
public class WorkingData {

    public static Conferenciaedicao getUltimaEdição(Conferencia conferencia) {
        Conferenciaedicao aux = null;
        Set<Conferenciaedicao> setConferenciaedicao = conferencia.getConferenciaedicaos();
        int id = 0;
        for (Conferenciaedicao conferenciaedicao : setConferenciaedicao) {
            if (conferenciaedicao.getId() > id) {
                aux = conferenciaedicao;
                id = conferenciaedicao.getId();
            }

        }
        return aux;
    }

    public static List<Conferencia> getTodasConferenciasAbertasInvestigador(Investigador investigador) {
        Conferencia aux = null;
        Set<Conferencia> setConferencia = investigador.getConferencias();
        List<Conferencia> listConferencia = new ArrayList<Conferencia>();
        int id = 0;
        for (Conferencia conferencia : setConferencia) {
            Conferenciaedicao conferenciaedicao = getUltimaEdição(conferencia);
            if (isOpenConferenciaedicao(conferenciaedicao)) {
                listConferencia.add(conferencia);
            }
        }
        return listConferencia;
    }

    public static List<Conferencia> getTodasConferenciasFechadasInvestigador(Investigador investigador) {
        Conferencia aux = null;
        Set<Conferencia> setConferencia = investigador.getConferencias();
        List<Conferencia> listConferencia = new ArrayList<Conferencia>();
        int id = 0;
        for (Conferencia conferencia : setConferencia) {
            Conferenciaedicao conferenciaedicao = getUltimaEdição(conferencia);
            if (!isOpenConferenciaedicao(conferenciaedicao)) {
                listConferencia.add(conferencia);
            }
        }
        return listConferencia;
    }

    public static List<Conferenciaedicao> getTodasEdicaosConferenciasAbertasInvestigador(Investigador investigador) {
        Conferencia aux = null;
        Set<Conferencia> setConferencia = investigador.getConferencias();
        List<Conferenciaedicao> listConferencia = new ArrayList<Conferenciaedicao>();
        int id = 0;
        for (Conferencia conferencia : setConferencia) {
            Conferenciaedicao conferenciaedicao = getUltimaEdição(conferencia);
            if (isOpenConferenciaedicao(conferenciaedicao)) {
                listConferencia.add(conferenciaedicao);
            }
        }
        return listConferencia;
    }

    public static List<Conferenciaedicao> getTodasEdicoesConferenciasAbertasInvestigadorComite(Investigador investigador) {
        Conferencia aux = null;
        Set<Conferenciacomite> setConferenciacomite = investigador.getConferenciacomites();
        List<Conferenciaedicao> listConferenciaedicao = new ArrayList<Conferenciaedicao>();
        int id = 0;
        for (Conferenciacomite comite : setConferenciacomite) {
            Conferenciaedicao conferenciaedicao = comite.getConferenciaedicao();
            if (isOpenConferenciaedicao(conferenciaedicao)) {
                listConferenciaedicao.add(conferenciaedicao);
            }
        }
        return listConferenciaedicao;
    }

    public static List<Conferenciaedicao> getTodasEdicoesConferenciasAbertasInvestigadorRevisores(Investigador investigador) {
        Conferencia aux = null;
        Set<Conferenciapoolrevisores> setConferenciacomite = investigador.getConferenciapoolrevisoreses();
        List<Conferenciaedicao> listConferenciaedicao = new ArrayList<Conferenciaedicao>();
        int id = 0;
        for (Conferenciapoolrevisores revisor : setConferenciacomite) {
            Conferenciaedicao conferenciaedicao = revisor.getConferenciaedicao();
            if (isOpenConferenciaedicao(conferenciaedicao)) {
                listConferenciaedicao.add(conferenciaedicao);
            }
        }
        return listConferenciaedicao;
    }

    public static List<Conferencia> getTodasEdicaosConferenciasAbertasTodosUtilizadores() {
        Conferencia aux = null;
        List<Conferencia> setConferencia = (List<Conferencia>) AllHellper.getListQualquerCoisa(Conferencia.class);
        List<Conferencia> listConferencia = new ArrayList<Conferencia>();
        int id = 0;
        for (Conferencia conferencia : setConferencia) {
            Conferenciaedicao conferenciaedicao = getUltimaEdição(conferencia);
            if (isOpenConferenciaedicao(conferenciaedicao)) {
                listConferencia.add(conferencia);
            }
        }
        return listConferencia;
    }

    public static boolean isOpenConferenciaedicao(Conferenciaedicao conferenciaedicao) {
        if (conferenciaedicao == null) {
            return false;
        }
        if (conferenciaedicao.getData().after(new Date()) && conferenciaedicao.getConfiguracaoEncerrada() == false) {
            return true;
        }
        return false;
    }

    public static List<Conferenciaedicao> getListEdicoesPassadas() {
        Conferencia aux = null;
        List<Conferencia> setConferencia = (List<Conferencia>) AllHellper.getListQualquerCoisa(Conferencia.class);
        List<Conferenciaedicao> listConferencia = new ArrayList<Conferenciaedicao>();
        int id = 0;
        for (Conferencia conferencia : setConferencia) {
            Conferenciaedicao conferenciaedicao = getUltimaEdição(conferencia);
            if (isEdicaoPassada(conferenciaedicao)) {
                listConferencia.add(conferenciaedicao);
            }
        }
        return listConferencia;
    }    

    public static List<Conferenciaedicao> getListEdicoesFuturas() {
        Conferencia aux = null;
        List<Conferencia> setConferencia = (List<Conferencia>) AllHellper.getListQualquerCoisa(Conferencia.class);
        List<Conferenciaedicao> listConferencia = new ArrayList<Conferenciaedicao>();
        int id = 0;
        for (Conferencia conferencia : setConferencia) {
            Conferenciaedicao conferenciaedicao = getUltimaEdição(conferencia);
            if (!isEdicaoPassada(conferenciaedicao)) {
                listConferencia.add(conferenciaedicao);
            }
        }
        return listConferencia;
    }        
    
    public static boolean isEdicaoPassada(Conferenciaedicao conferenciaedicao) {
        if (conferenciaedicao == null) {
            return false;
        }
        if (conferenciaedicao.getData().before(new Date())) {
            return true;
        }
        return false;
    }    
    
    public static String getDiasFimConferencia(String nome) {
        String condicao = (" as conf where conf.nome='" + nome + "'");
        try {

            Conferencia conferencia = (Conferencia) AllHellper.getQualquerCoisaCondicao(Conferencia.class, condicao);
            if (conferencia == null) {
                return "A conferencia não existe";
            }
            Conferenciaedicao conferenciaedicao = getUltimaEdição(conferencia);
            if (conferenciaedicao == null) {
                return "A conferencia não tem ediçoes";
            }
            if (isOpenConferenciaedicao(conferenciaedicao)) {
                return "" + (int) ((conferenciaedicao.getData().getTime() - (new Date()).getTime()) / (1000 * 60 * 60 * 24));
            }

            return "Não existem edições abertas";
        } catch (Exception e) {
            return "erro";
        }

    }

    public static String getDiasFimConferencia(int id) {
        String condicao = (" as conf where conf.id='" + id + "'");
        try {

            Conferencia conferencia = (Conferencia) AllHellper.getQualquerCoisaCondicao(Conferencia.class, condicao);
            if (conferencia == null) {
                return "A conferencia não existe";
            }
            Conferenciaedicao conferenciaedicao = getUltimaEdição(conferencia);
            if (conferenciaedicao == null) {
                return "A conferencia não tem ediçoes";
            }
            if (isOpenConferenciaedicao(conferenciaedicao)) {
                return "" + (int) ((conferenciaedicao.getData().getTime() - (new Date()).getTime()) / (1000 * 60 * 60 * 24));
            }

            return "Não existem edições abertas";
        } catch (Exception e) {
            return "erro";
        }
    }

    public static boolean ConferenciaJaExiste(String nome) {
        String condicao = (" as conf where conf.nome='" + nome + "'");
        Conferencia conferencia = null;
        try {

            conferencia = (Conferencia) AllHellper.getQualquerCoisaCondicao(Conferencia.class, condicao);

        } catch (Exception e) {
            return true;
        }
        if (conferencia != null) {
            return true;
        }
        return false;

    }

   //investigador 
    public static boolean utilizadorJaExiste(String username, String email) {
        Investigador investigador = null;
        try {
            String condicao = (" as inv where inv.utilizador='" + username + "' or inv.email='" + email + "'");

            investigador = (Investigador) AllHellper.getQualquerCoisaCondicao(Investigador.class, condicao);

        } catch (Exception e) {
            return true;
        }
        if (investigador != null) {
            return true;
        }
        return false;
    }

    public static List<Investigador> GetContactosDoInvestigador(Investigador investigador) {

        List<Investigador> listaInvestigadores = new ArrayList<Investigador>();
        Set<Contacto> Contactos = investigador.getContactosForIdInvestigador();
        for (Contacto contactos : Contactos) {
            Investigador sub = contactos.getInvestigadorByInvestigadorContactId();
            listaInvestigadores.add(sub);
        }
        return listaInvestigadores;
    }

    public static List<Investigador> getListaInvestigadoresNaoAmigos(Investigador investigador) {

        List<Investigador> listaInvestigadores = (List<Investigador>) AllHellper.getListQualquerCoisa(Investigador.class);
        List<Investigador> listaContactos = GetContactosDoInvestigador(investigador);

        for (Investigador contactos : listaContactos) {

            int i = contactos.getId();

            for (Investigador invF : listaInvestigadores) {
                if (invF.getId() == i) {
                    listaInvestigadores.remove(invF);
                    break;
                }
            }

        }

        int i = investigador.getId();

        for (Investigador invF : listaInvestigadores) {
            if (invF.getId() == i) {
                listaInvestigadores.remove(invF);
                break;
            }
        }

        return listaInvestigadores;
    }

    public static List<Artigo> getListaArtigosInvestigador(Investigador investigador) {

        ArrayList<Artigo> listaArtigos = new ArrayList<Artigo>();
        try {
            listaArtigos.addAll(investigador.getArtigos());
        } catch (Exception ex) {

        }

        return listaArtigos;
    }

    public static List<Artigo> getListaArtigosConferenciaedicao(Conferenciaedicao conferenciaedicao) {

        ArrayList<Artigo> listaArtigos = new ArrayList<Artigo>();
        try {
            for (Conferenciaartigo listaArtigo : conferenciaedicao.getConferenciaartigos()) {
                Artigo a = listaArtigo.getArtigo();
                if (a != null) {
                    listaArtigos.add(a);
                }
            }

        } catch (Exception ex) {

        }

        return listaArtigos;
    }

    public static List<Artigo> getListaArtigosConferenciaedicaoNaoSubmetidosInvestigador(Conferenciaedicao conferenciaedicao, Investigador investigador) {

        ArrayList<Artigo> listaArtigos = new ArrayList<Artigo>();
        List<Artigo> InvestigadorArtigos = getListaArtigosInvestigador(investigador);
        List<Artigo> ConferenciaedicaoArtigos = getListaArtigosConferenciaedicao(conferenciaedicao);
        for (Artigo artigo : InvestigadorArtigos) {
            for (Artigo ConferenciaedicaoArtigo : ConferenciaedicaoArtigos) {
                if (ConferenciaedicaoArtigo.getId() == artigo.getId()) {
                    listaArtigos.add(artigo);
                    break;
                }
            }

        }
        InvestigadorArtigos.removeAll(listaArtigos);
        return InvestigadorArtigos;
    }

    public static List<Investigador> getComiteEdicao(Conferenciaedicao conferenciaedicao) {

        ArrayList<Investigador> listaInvestigadores = new ArrayList<Investigador>();
        try {
            for (Conferenciacomite conferenciacomite : conferenciaedicao.getConferenciacomites()) {
                Investigador i = conferenciacomite.getInvestigador();
                if (i != null) {
                    listaInvestigadores.add(i);
                }
            }

        } catch (Exception ex) {

        }

        return listaInvestigadores;
    }

    public static List<Investigador> getListaInvestigadoresConferenciaedicaoLivres(Conferenciaedicao conferenciaedicao, Investigador investigador) {

        ArrayList<Investigador> listInvestigador = new ArrayList<Investigador>();
        List<Investigador> Investigadoramigos = GetContactosDoInvestigador(investigador);
        List<Investigador> ConferenciaedicaoInvestigador = getComiteEdicao(conferenciaedicao);
        for (Investigador inv : Investigadoramigos) {
            for (Investigador Com : ConferenciaedicaoInvestigador) {
                if (Com.getId() == inv.getId()) {
                    listInvestigador.add(inv);
                    break;
                }
            }

        }
        
        Investigadoramigos.removeAll(listInvestigador);
        return Investigadoramigos;
    }

}
