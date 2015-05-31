package io.server.ws.web;

import io.server.ws.BackendBean;
import io.server.ws.model.App;
import io.server.ws.model.ReturnCode;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@ViewScoped
public class RuntimeHome implements Serializable {

	private static final long serialVersionUID = -2955707944574962595L;

	private Logger log = LoggerFactory.getLogger(RuntimeHome.class);

	@Inject
	private BackendBean backendBean;

	@PostConstruct
	public void init() {
		this.backendBean.init();
	}

	@SuppressWarnings("unused")
	private void sample() {
		List<App> appList = this.backendBean.findAll();
		App app = this.backendBean.get(1L);
		ReturnCode rc = this.backendBean.delete(2L);
		List<App> findList = this.backendBean.find("ChroFox");
		// byte[] barray = this.backendBean.getBinary(1L);
		// 4L, "Go!", "The Game", 0.25, activated, new Date(),
		// this.backendBean.update(4L, true, "The Game Go", "new description",
		// 99.99d);
		appList = this.backendBean.findAll();
	}

	public String getAppCount() {
		return String.valueOf(this.backendBean.findAll().size());
	}

	public String getIp() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (final UnknownHostException e) {
			this.log.error(e.getMessage(), e);
			return "unknown host";
		}
	}
}
