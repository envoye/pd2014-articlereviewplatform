/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Tema;
import HibernatePackage.Subtema;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "TemaConferencia")
@Dependent
public class TemaConferencia {
    private String tema;
    private String descricao;
    private List<SubtemaConferencia> listaSubtemas;
    
    /**
     * Creates a new instance of TemaConferencia
     */
    public TemaConferencia() { }
/*    
    public TemaConferencia(String tema, String descricao) {
        this.tema = tema;
        this.descricao = descricao;
    }
*/
    public void setTema(String tema) {
        this.tema = tema;
    }
    
    public String getTema() {
        return this.tema;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public List<SubtemaConferencia> getSubtemas() {
        if(this.listaSubtemas == null){
            this.listaSubtemas = (List<SubtemaConferencia>)AllHellper.getListQualquerCoisa(Subtema.class);
        }
        return this.listaSubtemas;
    }
    
    public void addSubtema(String nome, String descricao) {
        this.listaSubtemas.add(new SubtemaConferencia(new Tema(this.tema),nome,descricao));
    }
    
    public void delSubtema(SubtemaConferencia subtema) {
        this.listaSubtemas.remove(subtema);
    }
    
    public String introduzir() {
        return "index";
    }
    
    public String registar() {
        AllHellper.SaveQualquerCoisa(new Tema(tema,descricao,null,null));
        return "index";
    }
    
    public String cancelar() {
        return "index";
    }

    public String pesquisar() {
        return "index";
    }
    
    /*
    * TESTE

    
    public void teste(){
        this.listaSubtemas.add(new SubtemaConferencia(new Tema("Cidades"),"igrejas","história"));
        this.listaSubtemas.add(new SubtemaConferencia(new Tema("Cidades"),"largos","acontecimentos"));
        this.listaSubtemas.add(new SubtemaConferencia(new Tema("Cidades"),"ruas","ligações"));
        this.listaSubtemas.add(new SubtemaConferencia(new Tema("Cidades"),"mapa","tipo"));
    }
    */
}
