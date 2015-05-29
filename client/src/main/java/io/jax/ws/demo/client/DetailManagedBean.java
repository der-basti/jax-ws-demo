/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.jax.ws.demo.client;

import io.server.ws.App;
import io.server.ws.AppService;
import io.server.ws.AppServiceService;
import io.server.ws.ReturnCode;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import javax.faces.view.ViewScoped;
import javax.xml.ws.soap.MTOMFeature;

/**
 *
 * @author cschulze
 */
@Named(value = "detailManagedBean")
@SessionScoped
public class DetailManagedBean implements Serializable{

    private long id;
    private App app;
    private AppService appServicePort;
    private String output;
    
    /**
     * Creates a new instance of DetailManagedBean
     */
    public DetailManagedBean() {
       appServicePort = this.getAppServicePort();       
       System.out.println("Detail Managed Bean inited!");
    }
    
       
    
     /** Get service port stub for App web service. */
    private AppService getAppServicePort() {
        AppServiceService service = new AppServiceService();
        return service.getAppServicePort(new MTOMFeature(true, 10240));
    }
    
    public String loadApp() {
        if(id!=-1L){
            this.app = appServicePort.getAppById(this.id);
        }
        return null;
    }
    
    public String update(){
        //System.out.println("update item with id:"+this.id);
        System.out.println("update app name: "+this.app.getName());
        System.out.println("update app description: "+this.app.getDescription());
        //System.out.println("app name"+app.getName());
        //ReturnCode rC = appServicePort.update(app);
//System.out.println("return code is:"+rC);        
//appServicePort.update(app);
        
        try{
            appServicePort.update(app);
        }catch(Exception e){
            
        }
        
        this.output = ReturnCode.SUCCESS.toString();
        
        return null;
    }
    
    public String delete(){
        ReturnCode deleteReturn = appServicePort.delete(this.id);
        
        this.output = "Delete returned: "+deleteReturn;
        
        return null;
    }

    
    /** Getter & Setter*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
    
    
}
