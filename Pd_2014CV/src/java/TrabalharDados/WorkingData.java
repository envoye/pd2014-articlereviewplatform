/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TrabalharDados;

import HelpersHibernate.AllHellper;
import HibernatePackage.Conferencia;
import HibernatePackage.Conferenciaedicao;
import HibernatePackage.Investigador;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Carlos
 */
public class WorkingData {
    
   public static Conferenciaedicao getUltimaEdição(Conferencia conferencia){
   Conferenciaedicao aux=null;
   Set<Conferenciaedicao> setConferenciaedicao=conferencia.getConferenciaedicaos();
   int id=0;
       for (Conferenciaedicao conferenciaedicao : setConferenciaedicao) {
           if(conferenciaedicao.getId()>id){
           aux=conferenciaedicao;
           id=conferenciaedicao.getId();
           }
           
       }
   return aux;
   }
   
     public static List<Conferencia> getTodasConferenciasAbertasInvestigador(Investigador investigador){
   Conferencia aux=null;
   Set<Conferencia> setConferencia=investigador.getConferencias();
   List<Conferencia> listConferencia=new ArrayList<Conferencia>();
   int id=0;
       for (Conferencia conferencia : setConferencia) {
       Conferenciaedicao conferenciaedicao = getUltimaEdição(conferencia);
        if(isOpenConferenciaedicao(conferenciaedicao)) 
         listConferencia.add(conferencia);
       }
   return listConferencia;
   }
   
   public static boolean isOpenConferenciaedicao(Conferenciaedicao conferenciaedicao){
   if(conferenciaedicao.getData().after(new Date())&&conferenciaedicao.getConfiguracaoEncerrada()==false)
   return true;
   return false;
   }
   
   public static String getDiasFimConferencia(String nome){
    String condicao=(" as conf where conf.nome='"+ nome+"'");

        Conferencia conferencia=(Conferencia)AllHellper.getQualquerCoisaCondicao(Conferencia.class,condicao);
        if(conferencia==null)
            return "A conferencia não existe";
        Conferenciaedicao conferenciaedicao = getUltimaEdição(conferencia);
        if(conferenciaedicao==null)
            return "A conferencia não tem ediçoes";
        if(isOpenConferenciaedicao(conferenciaedicao))
            return ""+(int)( (conferenciaedicao.getData().getTime() - (new Date()).getTime()) / (1000 * 60 * 60 * 24) );
        
        return "Não existem edições abertas"; 
     
        
   } 
    public static String getDiasFimConferencia(int id){
   String condicao=(" as conf where conf.id='"+id+"'");

        Conferencia conferencia=(Conferencia)AllHellper.getQualquerCoisaCondicao(Conferencia.class,condicao);
        if(conferencia==null)
           return "A conferencia não existe";
        Conferenciaedicao conferenciaedicao = getUltimaEdição(conferencia);
        if(conferenciaedicao==null)
             return "A conferencia não tem ediçoes";
        if(isOpenConferenciaedicao(conferenciaedicao))
            return ""+(int)( (conferenciaedicao.getData().getTime() - (new Date()).getTime()) / (1000 * 60 * 60 * 24) );
        
        return "Não existem edições abertas"; 
   } 
}
