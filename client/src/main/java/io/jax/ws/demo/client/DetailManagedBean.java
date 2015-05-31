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
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Base64;
import java.util.Base64.Encoder;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

import javax.xml.ws.soap.MTOMFeature;
import sun.misc.IOUtils;


/**
 *
 * @author cschulze
 */
@Named(value = "detailManagedBean")
@SessionScoped
public class DetailManagedBean implements Serializable {

    private long id;
    private App app;
    private AppService appServicePort;
    private String output;
    private Part imageFile;

    /**
     * Creates a new instance of DetailManagedBean
     */
    public DetailManagedBean() {
        appServicePort = this.getAppServicePort();
    }

    /**
     * Get service port stub for App web service.
     */
    private AppService getAppServicePort() {
        AppServiceService service = new AppServiceService();
        return service.getAppServicePort(new MTOMFeature(true, 10240));
    }

    public String loadApp() {
        // clear output
        this.output = "";

        if (id != -1L) {
            this.app = appServicePort.getAppById(this.id);
        } else {
            this.app = new App();
        }
        return null;
    }

    public String imageAsBase64() {
        String base64Image = "";
        if (this.id != -1L) {
            Encoder encoder = Base64.getEncoder();
            base64Image = "data:image/png;base64," + encoder.encodeToString(this.app.getImage());
        }
        return base64Image;

    }

     public String create() {
        this.update();
        
        
        return null;
    }
    
    public String update() {
        ReturnCode returnCode;
        
        // update Name, Description and Price
        try {         
            //returnCode = appServicePort.update(app.getId(), app.getName(), app.getDescription(), app.getPrice());
            returnCode = appServicePort.update(app.getId(), app.isActivated(), app.getName(),app.getDescription(),app.getPrice());
            this.output = returnCode.toString();
        } catch (Exception e) {
            this.output = "Update/Create: " + ReturnCode.INTERNAL_ERROR.toString();
        }
        
        // update Image
        if(imageFile!=null){
        try{
            byte[] bytes;   
            try ( 
                    InputStream inputStream = imageFile.getInputStream()) {
                bytes = IOUtils.readFully(inputStream,-1,true);
            }  
            
        returnCode = appServicePort.uploadImage(app.getId(), bytes);
        this.output = output+"\n File Upload: " + returnCode;
        
        
        }catch(IOException e){
            this.output = this.output+"\n Could not get fileContent";
        }
        }

        return null;
    }

    public String delete() {
        ReturnCode deleteReturn = appServicePort.delete(this.id);

        this.output = "Delete returned: " + deleteReturn;

        return null;
    }

    /**
     * Getter & Setter
     */
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

    public Part getImageFile() {
        return imageFile;
    }

    public void setImageFile(Part imageFile) {
        this.imageFile = imageFile;
    }

    
}
