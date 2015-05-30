/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.jax.ws.demo.client;

import io.server.ws.App;
import io.server.ws.AppService;
import io.server.ws.AppServiceService;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author cschulze
 */
@Named(value = "appCatalog")
@Dependent
public class AppCatalog {

    private AppService appServicePort;
    //private List<App> apps;
    
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        System.out.println("id is:"+id);
        this.id = id;
    }
    
    /**
     * Creates a new instance of AppCatalog
     */
    public AppCatalog() {
        appServicePort = this.getAppServicePort();
    }
    
    /** Get service port stub for App web service. */
    private AppService getAppServicePort() {
        AppServiceService service = new AppServiceService();
        return service.getAppServicePort();
    }
    
    public List<App> getApps(){
        return appServicePort.listAll();
    }
}
