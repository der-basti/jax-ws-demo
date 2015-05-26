/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.jax.ws.demo.client;

import io.server.ws.App;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceRef;

import io.server.ws.AppService;
import io.server.ws.AppServiceService;
import java.util.List;

/**
 *
 * @author Christopher
 */
@Named(value = "javaClientManagedBean")
@Dependent
public class JavaClientManagedBean {
    
    public AppService appService;

      
    /**
     * Creates a new instance of JavaClientManagedBean
     */
    public JavaClientManagedBean() {
        
      
    }
    
  
}
