/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Subtema;
import HibernatePackage.Tema;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBConferenciaSubtema")
@Dependent
public class MBConferenciaSubtema {
    private Tema tema;
    private String nome;
    private String descricao;
    private List<Tema> listTemas;
    /**
     * Creates a new instance of MBConferenciaSubtema
     */
    public MBConferenciaSubtema() {
    }

    public MBConferenciaSubtema(Tema tema, String nome, String descricao) {
        this.tema = tema;
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public void setTema(Tema tema) {
        for(int i=0;i<getListTemas().size();i++){
            if(this.getListTemas().get(i).getId().equals(this.tema.getId())){
                tema=this.getListTemas().get(i);
            }
        }        
        this.tema = tema;
    }
    
    public Tema getTema() {
        return this.tema;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return this.descricao;
    }

    public List<Tema> getListTemas() {
        if(listTemas == null){
            listTemas = (List<Tema>)AllHellper.getListQualquerCoisa(Tema.class);
        }
        return listTemas;
    }

    public void setListTemas(List<Tema> listTemas) {
        this.listTemas = listTemas;
    }

        public String gravar() {
        AllHellper.SaveQualquerCoisa(new Subtema(this.tema,this.nome,this.descricao,null,null));
        return "index";
    }
    
    public String cancelar() {
        return "index";
    }
}
