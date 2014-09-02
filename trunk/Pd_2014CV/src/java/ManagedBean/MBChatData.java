/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import Chat.Message;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Carlos
 */
@Named(value = "MBChatData")
@ApplicationScoped
public class MBChatData {

    
    private List<Message> messages =
            Collections.synchronizedList(new LinkedList<Message>());
 
    
    public void sendMessage(Message msg) {
        messages.add(msg);
        msg.setDateSent(new Date());
    }
 
    
    public Message getFirstAfter(Date after) {
        if(messages.isEmpty())
            return null;
        if(after == null)
            return messages.get(0);
        for(Message m : messages) {
            if(m.getDateSent().after(after))
                return m;
        }
        return null;
    }
    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public MBChatData() {
     messages.add(new Message(new Date(),"Carlos","ola"));
     messages.add(new Message(new Date(),"john","ola"));
     messages.add(new Message(new Date(),"lol","ola"));   
        
    }
    
}
