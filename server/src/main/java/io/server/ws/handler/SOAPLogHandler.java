/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.server.ws.handler;

import java.util.Collections;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 *
 * @author Christopher
 */
public class SOAPLogHandler implements SOAPHandler<SOAPMessageContext> {
      
    public boolean handleMessage(SOAPMessageContext messageContext) {
        logMessage(messageContext);
        return true;
    }
    
    public Set<QName> getHeaders() {
        return Collections.EMPTY_SET;
    }
    
    public boolean handleFault(SOAPMessageContext messageContext) {
        logMessage(messageContext);
        return true;
    }
    
    public void close(MessageContext context) {
    }
    
    private void logMessage(SOAPMessageContext messageContext){
        Boolean direction = (Boolean) messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        
        if(direction==true){
            System.out.println("Outbound message:");
        }else{
            System.out.println("Inbound message:");
        }
        
        SOAPMessage message = messageContext.getMessage();
        try{
            message.writeTo(System.out);
            System.out.println();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
