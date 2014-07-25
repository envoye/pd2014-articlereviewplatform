/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Artigo;
import HibernatePackage.Conferenciaartigo;
import HibernatePackage.Conferenciaedicao;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBConferenciaArtigo")
@ViewScoped
public class MBConferenciaArtigo {
    private Conferenciaedicao conferenciaedicao;
    private Artigo artigo;
    private boolean publicar;
    private List<Conferenciaedicao> listaEdicoes;
    private List<Artigo> listaArtigos;
    
    
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

    public List<Conferenciaedicao> getListaEdicoes() {
        if(this.listaEdicoes == null){
            this.listaEdicoes = (List<Conferenciaedicao>)AllHellper.getListQualquerCoisa(Conferenciaedicao.class);
        }        
        return listaEdicoes;
    }

    public void setListaEdicoes(List<Conferenciaedicao> listaEdicoes) {
        this.listaEdicoes = listaEdicoes;
    }

    public List<Artigo> getListaArtigos() {
        if(this.listaArtigos == null){
            this.listaEdicoes = (List<Conferenciaedicao>)AllHellper.getListQualquerCoisa(Conferenciaedicao.class);
        }                
        return listaArtigos;
    }

    public void setListaArtigos(List<Artigo> listaArtigos) {
        this.listaArtigos = listaArtigos;
    }
    
    public String gravar() {
        AllHellper.SaveQualquerCoisa(new Conferenciaartigo(conferenciaedicao, artigo, publicar));
        return "index";
    }
    
    public String cancelar() {
        return "index";
    }

    public String pesquisar() {
        return "index";
    }    
}
