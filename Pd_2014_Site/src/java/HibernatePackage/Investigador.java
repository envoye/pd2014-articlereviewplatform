package HibernatePackage;
// Generated 16/Abr/2014 23:30:37 by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Investigador generated by hbm2java
 */
public class Investigador  implements java.io.Serializable {


     private Integer id;
     private Grauacademico grauacademico;
     private String nome;
     private String instituicao;
     private Date datanascimento;
     private String utilizador;
     private String password;
     private String email;
     private String telefone;
     private String telemovel;
     private Set<Conferenciacomiteartigoforummensagem> conferenciacomiteartigoforummensagems = new HashSet<Conferenciacomiteartigoforummensagem>(0);
     private Set<Investigadorareaconhecimento> investigadorareaconhecimentos = new HashSet<Investigadorareaconhecimento>(0);
     private Set<Contacto> contactos = new HashSet<Contacto>(0);
     private Set<Conferenciapoolrevisores> conferenciapoolrevisoreses = new HashSet<Conferenciapoolrevisores>(0);
     private Set<Artigoautores> artigoautoreses = new HashSet<Artigoautores>(0);
     private Set<Conferenciacomite> conferenciacomites = new HashSet<Conferenciacomite>(0);

    public Investigador() {
    }

	
    public Investigador(Grauacademico grauacademico, String nome, Date datanascimento, String utilizador, String password) {
        this.grauacademico = grauacademico;
        this.nome = nome;
        this.datanascimento = datanascimento;
        this.utilizador = utilizador;
        this.password = password;
    }
    public Investigador(Grauacademico grauacademico, String nome, String instituicao, Date datanascimento, String utilizador, String password, String email, String telefone, String telemovel, Set<Conferenciacomiteartigoforummensagem> conferenciacomiteartigoforummensagems, Set<Investigadorareaconhecimento> investigadorareaconhecimentos, Set<Contacto> contactos, Set<Conferenciapoolrevisores> conferenciapoolrevisoreses, Set<Artigoautores> artigoautoreses, Set<Conferenciacomite> conferenciacomites) {
       this.grauacademico = grauacademico;
       this.nome = nome;
       this.instituicao = instituicao;
       this.datanascimento = datanascimento;
       this.utilizador = utilizador;
       this.password = password;
       this.email = email;
       this.telefone = telefone;
       this.telemovel = telemovel;
       this.conferenciacomiteartigoforummensagems = conferenciacomiteartigoforummensagems;
       this.investigadorareaconhecimentos = investigadorareaconhecimentos;
       this.contactos = contactos;
       this.conferenciapoolrevisoreses = conferenciapoolrevisoreses;
       this.artigoautoreses = artigoautoreses;
       this.conferenciacomites = conferenciacomites;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Grauacademico getGrauacademico() {
        return this.grauacademico;
    }
    
    public void setGrauacademico(Grauacademico grauacademico) {
        this.grauacademico = grauacademico;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getInstituicao() {
        return this.instituicao;
    }
    
    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
    public Date getDatanascimento() {
        return this.datanascimento;
    }
    
    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }
    public String getUtilizador() {
        return this.utilizador;
    }
    
    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getTelemovel() {
        return this.telemovel;
    }
    
    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }
    public Set<Conferenciacomiteartigoforummensagem> getConferenciacomiteartigoforummensagems() {
        return this.conferenciacomiteartigoforummensagems;
    }
    
    public void setConferenciacomiteartigoforummensagems(Set<Conferenciacomiteartigoforummensagem> conferenciacomiteartigoforummensagems) {
        this.conferenciacomiteartigoforummensagems = conferenciacomiteartigoforummensagems;
    }
    public Set<Investigadorareaconhecimento> getInvestigadorareaconhecimentos() {
        return this.investigadorareaconhecimentos;
    }
    
    public void setInvestigadorareaconhecimentos(Set<Investigadorareaconhecimento> investigadorareaconhecimentos) {
        this.investigadorareaconhecimentos = investigadorareaconhecimentos;
    }
    public Set<Contacto> getContactos() {
        return this.contactos;
    }
    
    public void setContactos(Set<Contacto> contactos) {
        this.contactos = contactos;
    }
    public Set<Conferenciapoolrevisores> getConferenciapoolrevisoreses() {
        return this.conferenciapoolrevisoreses;
    }
    
    public void setConferenciapoolrevisoreses(Set<Conferenciapoolrevisores> conferenciapoolrevisoreses) {
        this.conferenciapoolrevisoreses = conferenciapoolrevisoreses;
    }
    public Set<Artigoautores> getArtigoautoreses() {
        return this.artigoautoreses;
    }
    
    public void setArtigoautoreses(Set<Artigoautores> artigoautoreses) {
        this.artigoautoreses = artigoautoreses;
    }
    public Set<Conferenciacomite> getConferenciacomites() {
        return this.conferenciacomites;
    }
    
    public void setConferenciacomites(Set<Conferenciacomite> conferenciacomites) {
        this.conferenciacomites = conferenciacomites;
    }




}


