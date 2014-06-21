/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HelpersHibernate.InvestigadorHelper;
import HibernatePackage.Grauacademico;
import HibernatePackage.Investigador;
import com.sun.org.apache.bcel.internal.generic.AllocationInstruction;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
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
     private int idGrauacademico;
     private List<Grauacademico> listGrauacademico; 
     
     public int getIdGrauacademico() {
        return idGrauacademico;
    }

    public void setIdGrauacademico(int idGrauacademico) {
        this.idGrauacademico = idGrauacademico;
        for(int i=0;i<getListGrauacademico().size();i++){
            if(listGrauacademico.get(i).getId()==idGrauacademico){
            grauacademico=listGrauacademico.get(i);
            }
        
        }
    }

    public List<Grauacademico> getListGrauacademico() {
        if(listGrauacademico==null){
            
            
        listGrauacademico= (List<Grauacademico>)AllHellper.getListQualquerCoisa(Grauacademico.class);
        
        }
        return listGrauacademico;
    }

    public void setListGrauacademico(List<Grauacademico> listGrauacademico) {
        this.listGrauacademico = listGrauacademico;
        
    }
                        
    public void setPasswordconf(String passwordconf) {
        this.passwordconf = passwordconf;
    }

    public String getPasswordconf() {
        return passwordconf;
    }
     
    public Grauacademico getGrauacademico() {
        if(grauacademico==null)
            if(getListGrauacademico().size()>0)
            grauacademico=listGrauacademico.get(0);
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
       
             this.datanascimento =datanascimento;
         
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
     
  public String registar () {
     
     AllHellper.SaveQualquerCoisa(new Investigador(grauacademico, nome, instituicao, datanascimento, utilizador, password, email, telefone, telemovel, null, null, null, null, null, null));
  
    return "index";
  }
    
}
