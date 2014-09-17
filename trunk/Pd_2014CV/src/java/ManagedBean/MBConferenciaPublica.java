/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Artigorevisao;
import HibernatePackage.Conferenciaedicao;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBConferenciaPublica")
@Dependent
public class MBConferenciaPublica {
    private List<Conferenciaedicao> listaConfRealiz;
    private List<Conferenciaedicao> listaConfFuturas;
    
    private List<Artigorevisao> listaTopArtigos;
    /**
     * Creates a new instance of MBConferenciaPublica
     */
    public MBConferenciaPublica() {
    }
 
    public List<Conferenciaedicao> getListaConfRealiz() {
        if (listaConfRealiz == null){
            String condicao = " where conferenciaedicao.data < curdate() "
                    + "order by conferenciaedicao.data desc limit 10";
            listaConfRealiz = (List<Conferenciaedicao>)AllHellper.getListQualquerCoisaCondicao(Conferenciaedicao.class, condicao);
        }                
        return listaConfRealiz;
    }

    public void setListaConfRealiz(List<Conferenciaedicao> listaConfRealiz) {
        this.listaConfRealiz = listaConfRealiz;
    }

    public List<Conferenciaedicao> getListaConfFuturas() {
        if (listaConfFuturas == null){
            String condicao = " where conferenciaedicao.data >= curdate() "
                    + "order by conferenciaedicao.data desc limit 10";
            listaConfFuturas = (List<Conferenciaedicao>)AllHellper.getListQualquerCoisaCondicao(Conferenciaedicao.class, condicao);
        }                        
        return listaConfFuturas;
    }

    public void setListaConfFuturas(List<Conferenciaedicao> listaConfFuturas) {
        this.listaConfFuturas = listaConfFuturas;
    }

    public List<Artigorevisao> getListaTopArtigos() {
        if (listaTopArtigos == null){
            String condicao = " order by artigorevisao.pontuacao desc limit 10";
            listaTopArtigos = (List<Artigorevisao>)AllHellper.getListQualquerCoisaCondicao(Artigorevisao.class, condicao);
        }                                
        return listaTopArtigos;
    }

    public void setListaTopArtigos(List<Artigorevisao> listaTopArtigos) {
        this.listaTopArtigos = listaTopArtigos;
    }
    
    
}
