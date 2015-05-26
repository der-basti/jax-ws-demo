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
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

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
    
     /** Get service port stub for App web service. */
    private AppService getAppServicePort() {
        AppServiceService service = new AppServiceService();
        return service.getAppServicePort();
    }
}
