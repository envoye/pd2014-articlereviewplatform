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
import HibernatePackage.Investigador;
import TrabalharDados.WorkingData;
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
public class MBConferenciaArtigo implements Serializable  {
    private Conferenciaedicao conferenciaedicao=new Conferenciaedicao();
    private Artigo artigo=new Artigo();
    private boolean publicar;
    private List<Conferencia> listaEdicoes;
    private List<Artigo> listaArtigos;
    @Inject
     private LoginUtilizador loginUtilizador;
    
    private int id=0;
    private int idartigo=0;

    public int getIdartigo() {
        return idartigo;
    }

    public void setIdartigo(int idartigo) {
        this.idartigo = idartigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    private Conferencia conferencia=new Conferencia();    

    public Conferencia getConferencia() {
        return conferencia;
    }

    public void setConferencia(Conferencia conferencia) {
        this.conferencia = conferencia;
    }
    /**
     * Creates a new instance of MBConferenciaArtigo
     */
    public MBConferenciaArtigo() {
    }

   

  

    public Boolean isPublicar() {
        return publicar;
    }

    public void setPublicar(Boolean publicar) {
        this.publicar = publicar;
    }

    public List<Conferencia> getListaEdicoes() {
       listaEdicoes= WorkingData.getTodasEdicaosConferenciasAbertasTodosUtilizadores();
        return listaEdicoes;
    }

    public void setListaEdicoes(List<Conferencia> listaEdicoes) {
        this.listaEdicoes = listaEdicoes;
    }

    public List<Artigo> getListaArtigos() {
        
       listaArtigos= WorkingData.getListaArtigosConferenciaedicaoNaoSubmetidosInvestigador(conferenciaedicao,loginUtilizador.getInvestigador());               
        return listaArtigos;
    }

    public void setListaArtigos(List<Artigo> listaArtigos) {
        this.listaArtigos = listaArtigos;
    }

    public String introduzir() {
        return "index";
    }
    
    public String gravar() {
         if(idartigo==0)
            return"";
        for (Artigo Edicoe : listaArtigos) {
             if(Edicoe.getId()==idartigo){
             artigo=Edicoe;
             break;
             }
            }
        
        AllHellper.SaveQualquerCoisa(new Conferenciaartigo(conferenciaedicao, artigo, false));
        loginUtilizador.actualisaInvestigador();
         return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }
    
    public String cancelar() {
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }

    public String pesquisar() {
        return "index";
    }    
    
    public String next() {
        if(id==0)
            return"";
        for (Conferencia Edicoe : listaEdicoes) {
             if(Edicoe.getId()==id){
             conferencia=Edicoe;
             break;
             }
            }
        this.conferenciaedicao=WorkingData.getUltimaEdição(conferencia);
            return "/model/conferencias/ConferenciaArtigoDois.xhtml?faces-redirect=true";
       
    }
}
