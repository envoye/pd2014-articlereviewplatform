/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HibernatePackage.Tema;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "subtemaConferencia")
@Dependent
public class SubtemaConferencia {
    private Tema tema;
    private String nome;
    private String descricao;
    /**
     * Creates a new instance of SubtemaConferencia
     */
    public SubtemaConferencia() {
    }

    public SubtemaConferencia(Tema tema, String nome, String descricao) {
        this.tema = tema;
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public void setTema(Tema tema) {
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
    
}
