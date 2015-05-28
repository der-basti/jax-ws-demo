/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.jax.ws.demo.client;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author cschulze
 */
@Named(value = "appDetailManagedBean")
@RequestScoped
public class AppDetailManagedBean {
    private String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    private String output;
    
    
    /**
     * Creates a new instance of AppDetailManagedBean
     */
    public AppDetailManagedBean() {
    }
    
    public String submit(){
        output = "input was: "+input;
        return "index.xhtml";
    }
}
