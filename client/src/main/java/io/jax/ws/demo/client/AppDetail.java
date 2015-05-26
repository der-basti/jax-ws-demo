/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.jax.ws.demo.client;

import io.server.ws.App;
import io.server.ws.AppService;
import io.server.ws.AppServiceService;
import java.awt.Image;
import javax.annotation.ManagedBean;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingProvider;
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
        
     /** Get service port stub for App web service. */
    private AppService getAppServicePort() {
        AppServiceService service = new AppServiceService();
        return service.getAppServicePort(new MTOMFeature(true, 10240));
    }
}
