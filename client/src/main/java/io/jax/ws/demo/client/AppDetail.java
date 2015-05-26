/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.jax.ws.demo.client;

import io.server.ws.App;
import io.server.ws.AppService;
import io.server.ws.AppServiceService;
import javax.annotation.ManagedBean;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.xml.ws.soap.MTOMFeature;

/**
 *
 * @author Christopher
 */
@Named(value = "appDetail")
@ManagedBean
@RequestScoped
public class AppDetail {
    
    private long id=-1L;

    public long getId() {
        return id;
    }
    
    private String output;

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    private App app;

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }
    private AppService appServicePort;
    
    /**
     * Creates a new instance of AppDetail
     */
    public AppDetail() {
        appServicePort = this.getAppServicePort();
        //codes enable MTOM in client
//        BindingProvider bp = (BindingProvider) appServicePort;
//        SOAPBinding binding = (SOAPBinding) bp.getBinding();
//        binding.setMTOMEnabled(true);
    } 
 
    public String loadApp() {
        if(id!=-1L){
            this.app = appServicePort.getAppById(this.id);
        }
        return null;
    }
    
    public String getAddDate(){
        String addDate = "";
        if(id!=-1L){
            addDate = this.app.getAddDate().toString();
        }
        return addDate;
    }
    
    public String getImageAsBase64(){
        String base64Image = "";
                
        //Image img = appServicePort.downloadImage(this.id);
        
        return base64Image;
    }
    
    public void update(){      
        // update
        System.out.println("updating item");
        
        this.output ="success...";
//        if(id!=-1L){
//            System.out.println("updating item");
//        }
//        // create
//        else{
//            System.out.println("creating item");
//            this.id = -1;
//        }
//        
//        appServicePort.update(this.app, new byte[10]);
    }
        
     /** Get service port stub for App web service. */
    private AppService getAppServicePort() {
        AppServiceService service = new AppServiceService();
        return service.getAppServicePort(new MTOMFeature(true, 10240));
    }
}
