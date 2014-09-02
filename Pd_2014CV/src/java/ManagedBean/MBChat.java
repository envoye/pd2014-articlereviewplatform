/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import Chat.Message;
import HibernatePackage.Conferenciacomiteartigoforum;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Carlos
 */
@Named(value = "mBChat")
@ViewScoped
public class MBChat {
private Conferenciacomiteartigoforum forum; 
    /**
     * Creates a new instance of MBChat
     */
    @Inject
    MBChatData mm;
 
    private List<Message> messages;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    private Date lastUpdate;
    private Message message;
 
    /**
     * Creates a new instance of MessageBean
     */
    public MBChat() {
        messages = Collections.synchronizedList(new LinkedList());
        lastUpdate = new Date(0);
        message = new Message();
    }
 
    public Date getLastUpdate() {
        return lastUpdate;
    }
 
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
 
    public Message getMessage() {
        return message;
    }
 
    public void setMessage(Message message) {
        this.message = message;
    }
 
    public void sendMessage(ActionEvent evt) {
        mm.sendMessage(message);
    }
 
    public void firstUnreadMessage(ActionEvent evt) {
       RequestContext ctx = RequestContext.getCurrentInstance();
 
       Message m = mm.getFirstAfter(lastUpdate);
 
       ctx.addCallbackParam("ok", m!=null);
       if(m==null)
           return;
 
       lastUpdate = m.getDateSent();
 
       ctx.addCallbackParam("user", m.getUser());
       ctx.addCallbackParam("dateSent", m.getDateSent().toString());
       ctx.addCallbackParam("text", m.getMessage());
 
    }
    
}
