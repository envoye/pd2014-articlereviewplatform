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
@Named(value = "ConferenciaTema")
@Dependent
public class ConferenciaTema {
    private String tema;
    private String descricao;
    private List<ConferenciaSubtema> listaSubtemas;
    
    /**
     * Creates a new instance of ConferenciaTema
     */
    public ConferenciaTema() { }
    
    public ConferenciaTema(String tema, String descricao) {
        this.tema = tema;
        this.descricao = descricao;
    }

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
    
    public List<ConferenciaSubtema> getSubtemas() {
        if(this.listaSubtemas == null){
            this.listaSubtemas = (List<ConferenciaSubtema>)AllHellper.getListQualquerCoisa(Subtema.class);
        }
        return this.listaSubtemas;
    }
    
    public void addSubtema(String nome, String descricao) {
        this.listaSubtemas.add(new ConferenciaSubtema(new Tema(this.tema),nome,descricao));
    }
    
    public void delSubtema(ConferenciaSubtema subtema) {
        this.listaSubtemas.remove(subtema);
    }
    
    public String introduzir() {
        System.out.println("Passei aqui para novo");
        return "index";
    }
    
    public String registar() {
        System.out.println("Passei aqui para gravar");
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
