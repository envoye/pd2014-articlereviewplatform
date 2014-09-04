/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Artigo;
import HibernatePackage.Conferencia;
import HibernatePackage.Conferenciaartigo;
import HibernatePackage.Conferenciaedicao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBConferenciaArtigo")
@SessionScoped
public class MBConferenciaArtigo implements Serializable {
    private Conferenciaedicao conferenciaedicao;
    private Artigo artigo;
    private boolean publicar;
    private List<Conferencia> listaEdicoes;
    private List<Artigo> listaArtigos;
    @Inject
     private LoginUtilizador loginUtilizador;
    private Conferencia conferencia=new Conferencia();    
    /**
     * Creates a new instance of MBConferenciaArtigo
     */
    public MBConferenciaArtigo() {
    }

    public Conferenciaedicao getConferenciaedicao() {
        return conferenciaedicao;
    }

    public void setConferenciaedicao(Conferenciaedicao conferenciaedicao) {
        this.conferenciaedicao = conferenciaedicao;
    }

    public Artigo getArtigo() {
        return artigo;
    }

    public void setArtigo(Artigo artigo) {
        this.artigo = artigo;
    }

    public Boolean isPublicar() {
        return publicar;
    }

    public void setPublicar(Boolean publicar) {
        this.publicar = publicar;
    }

    public List<Conferencia> getListaEdicoes() {
        if(this.listaEdicoes == null){
            this.listaEdicoes = new ArrayList<Conferencia>();
            List<Conferencia> lConferencia=(List<Conferencia>)AllHellper.getListQualquerCoisa(Conferencia.class);
            for (Conferencia conferencia1 : lConferencia) {
                Conferenciaedicao aux = null;
                int corentId=0;
                for (Conferenciaedicao conferenciaedicao2 : conferencia1.getConferenciaedicaos()) {
                    if(conferenciaedicao2.getId()>corentId){
                    aux=conferenciaedicao2;
                    corentId=conferenciaedicao2.getId();
                    }
                        
                }
                if(aux!=null  && (new Date().before( aux.getDataLimiteSubmissao())))
                this.listaEdicoes.add(conferencia1);
            }
        }        
        return listaEdicoes;
    }

    public void setListaEdicoes(List<Conferencia> listaEdicoes) {
        this.listaEdicoes = listaEdicoes;
    }

    public List<Artigo> getListaArtigos() {
        if(this.listaArtigos == null){
           this.listaArtigos=new ArrayList<Artigo> ();
         try{
            this.listaArtigos.addAll(loginUtilizador.getInvestigador().getArtigos());
         }catch(Exception ex){
         return null;
         }
        }                
        return listaArtigos;
    }

    public void setListaArtigos(List<Artigo> listaArtigos) {
        this.listaArtigos = listaArtigos;
    }

    public String introduzir() {
        return "index";
    }
    
    public String gravar() {
        AllHellper.SaveQualquerCoisa(new Conferenciaartigo(conferenciaedicao, artigo, publicar));
        return "/model/conferencias/ConferenciaComiteArtigo.xhtml?faces-redirect=true";
    }
    
    public String cancelar() {
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }

    public String pesquisar() {
        return "index";
    }    
    
    public String next() {
        if(conferencia.getId()>=0)
            return "/model/conferencias/ConferenciaComiteArtigoDois.xhtml?faces-redirect=true";
        else
            return "";
    }
}
