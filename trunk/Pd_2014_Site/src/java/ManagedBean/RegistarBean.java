/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HibernatePackage.Grauacademico;
import java.util.Date;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Carlos
 */
@Named(value = "registarBean")
@ViewScoped
public class RegistarBean {
     private Grauacademico grauacademico;
     private String nome;
     private String instituicao;
     private Date datanascimento;
     private String utilizador;
     private String password;
     private String email;
     private String telefone;
     private String telemovel;
     private String passwordconf;

    public void setPasswordconf(String passwordconf) {
        this.passwordconf = passwordconf;
    }

    public String getPasswordconf() {
        return passwordconf;
    }
     
    public Grauacademico getGrauacademico() {
        return grauacademico;
    }

    public String getNome() {
        return nome;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public String getUtilizador() {
        return utilizador;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public void setGrauacademico(Grauacademico grauacademico) {
        this.grauacademico = grauacademico;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }
     
   
    
}
