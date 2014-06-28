package HibernatePackage;
// Generated 28/Jun/2014 15:34:25 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Itemrevisao generated by hbm2java
 */
public class Itemrevisao  implements java.io.Serializable {


     private Integer id;
     private String nomeItem;
     private boolean tipo;
     private boolean privado;
     private String descricao;
     private Set<Artigorevisaoitems> artigorevisaoitemses = new HashSet<Artigorevisaoitems>(0);

    public Itemrevisao() {
    }

	
    public Itemrevisao(String nomeItem, boolean tipo, boolean privado) {
        this.nomeItem = nomeItem;
        this.tipo = tipo;
        this.privado = privado;
    }
    public Itemrevisao(String nomeItem, boolean tipo, boolean privado, String descricao, Set<Artigorevisaoitems> artigorevisaoitemses) {
       this.nomeItem = nomeItem;
       this.tipo = tipo;
       this.privado = privado;
       this.descricao = descricao;
       this.artigorevisaoitemses = artigorevisaoitemses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNomeItem() {
        return this.nomeItem;
    }
    
    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }
    public boolean isTipo() {
        return this.tipo;
    }
    
    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }
    public boolean isPrivado() {
        return this.privado;
    }
    
    public void setPrivado(boolean privado) {
        this.privado = privado;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Set<Artigorevisaoitems> getArtigorevisaoitemses() {
        return this.artigorevisaoitemses;
    }
    
    public void setArtigorevisaoitemses(Set<Artigorevisaoitems> artigorevisaoitemses) {
        this.artigorevisaoitemses = artigorevisaoitemses;
    }




}


