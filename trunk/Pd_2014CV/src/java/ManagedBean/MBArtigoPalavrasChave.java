/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Artigo;
import HibernatePackage.Artigopalavrachave;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBArtigoPalavrasChave")
@ViewScoped
public class MBArtigoPalavrasChave {
    private Artigo artigo;
    private String palavraChave;
    private List<Artigo> listaArtigos;
    private List<Artigopalavrachave> listaPalavrasChave;
    
    /**
     * Creates a new instance of MBArtigoPalavrasChave
     */
    public MBArtigoPalavrasChave() {
    }

    public Artigo getArtigo() {
        return artigo;
    }

    public void setArtigo(Artigo artigo) {
        this.artigo = artigo;
    }

    public String getPalavraChave() {
        return palavraChave;
    }

    public void setPalavraChave(String palavraChave) {
        this.palavraChave = palavraChave;
    }

    public List<Artigo> getListaArtigos() {
        if(this.listaArtigos == null){
            this.listaArtigos = (List<Artigo>)AllHellper.getListQualquerCoisa(Artigo.class);
        }                        
        return listaArtigos;
    }

    public void setListaArtigos(List<Artigo> listaArtigos) {
        this.listaArtigos = listaArtigos;
    }
    
    public List<Artigopalavrachave> getListaPalavrasChave() {
        if(this.listaPalavrasChave == null){
            this.listaPalavrasChave = (List<Artigopalavrachave>)AllHellper.getListQualquerCoisa(Artigopalavrachave.class);
        }                
        return this.listaPalavrasChave;
    }

    public void setListaPalavrasChave(List<Artigopalavrachave> listaPalavrasChave) {
        this.listaPalavrasChave = listaPalavrasChave;
    }
    
    public String gravar() {
        AllHellper.SaveQualquerCoisa(new Artigopalavrachave(artigo, palavraChave));
        return "index";
    }
    
    public String cancelar() {
        return "index";
    }

    public String pesquisar() {
        return "index";
    }        
}
