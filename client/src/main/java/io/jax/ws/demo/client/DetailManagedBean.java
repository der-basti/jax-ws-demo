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
import javax.xml.ws.Holder;
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

    /* Creates a new instance of DetailManagedBean */
    public DetailManagedBean() {
        appServicePort = this.getAppServicePort();
    }

    /* Get service port stub for App web service */
    private AppService getAppServicePort() {
        AppServiceService service = new AppServiceService();
        return service.getAppServicePort(new MTOMFeature(true, 10240));
    }

    /* Load existing App or create new one */
    public String loadApp() {
        // clear output
        this.output = "";

        if (id != -1L) {
            // get existing App
            this.app = appServicePort.getAppById(this.id);
        } else {
            // create new App and set Id=-1
            this.app = new App();
            this.app.setId(-1L);
        }
        return null;
    }

    /* Convert App.Image byte[] to base64 Image Data */
    public String imageAsBase64() {
        String base64Image = "";
        if (this.id != -1L) {
            Encoder encoder = Base64.getEncoder();
            base64Image = "data:image/png;base64," + encoder.encodeToString(this.app.getImage());
        }
        return base64Image;

    }

    /* Create new App */
    public String create() {
        this.update();
        return null;
    }

    /* Update existing App */
    public String update() {
        ReturnCode returnCode;
        Holder<Long> updateId = new Holder<>();
        updateId.value = this.id;

        // update Name, isActivated, Description and Price
        try {
            appServicePort.update(updateId, app.isActivated(), app.getName(), app.getDescription(), app.getPrice());
            if (updateId.value >= 0) {
                this.output = "Update/Create: " + ReturnCode.SUCCESS + " with Id " + updateId.value;
            } else {
                this.output = "Update/Create: " + ReturnCode.INTERNAL_ERROR + " with Code " + updateId.value;
            }
        } catch (Exception e) {
            this.output = "Update/Create: " + ReturnCode.INTERNAL_ERROR.toString();
        }

        // update Image
        if (imageFile != null && updateId.value >= 0) {
            // convert Part data from inputFile to byte[]
            try {
                byte[] bytes;
                try (
                        InputStream inputStream = imageFile.getInputStream()) {
                    bytes = IOUtils.readFully(inputStream, -1, true);
                }

                returnCode = appServicePort.uploadImage(updateId.value, bytes);
                this.output = output + " File Upload: " + returnCode;

            } catch (IOException e) {
                this.output = this.output + " Could not get fileContent";
            }
        }

        return null;
    }

    /* Delete App */
    public String delete() {
        ReturnCode deleteReturn = appServicePort.delete(this.id);
        this.output = "Delete returned: " + deleteReturn;
        return null;
    }

    /* Getter & Setter */
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
