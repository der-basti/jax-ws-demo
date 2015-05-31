package io.server.ws.handler;

import javax.xml.transform.Source;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author Christopher
 */
public class LogicalLogHandler implements LogicalHandler<LogicalMessageContext> {
    
    public boolean handleMessage(LogicalMessageContext messageContext) {
        //LogicalMessage msg = messageContext.getMessage();
        logMessage(messageContext);
        return true;
    }
    
    public boolean handleFault(LogicalMessageContext messageContext) {
        logMessage(messageContext);
        return true;
    }
    
    public void close(MessageContext context) {
    }
    
    private void logMessage(LogicalMessageContext messageContext){
        Boolean direction = (Boolean) messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        
        if(direction==true){
            System.out.println("Outbound message:");
        }else{
            System.out.println("Inbound message:");
        }
        
        LogicalMessage message = messageContext.getMessage();
        try{
            Source payload = message.getPayload();
            System.out.println(payload);
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }
}
