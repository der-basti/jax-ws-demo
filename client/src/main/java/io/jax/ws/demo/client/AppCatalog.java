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
    private long id;

    /* Creates a new instance of AppCatalog */
    public AppCatalog() {
        appServicePort = this.getAppServicePort();
    }

    /* Get service port stub for App web service */
    private AppService getAppServicePort() {
        AppServiceService service = new AppServiceService();
        return service.getAppServicePort();
    }

    /* Get all activated Apps from Webservice and return */
    public List<App> getApps() {
        return appServicePort.listAll();
    }

    /* Get all not activated Apps from Webservice and return */
    public List<App> getAppsInactivated() {
        return appServicePort.listAllInactivated();
    }

    /* Getter & Setter */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
