package io.ws.server.web;

import io.ws.server.BackendBean;
import io.ws.server.model.App;
import io.ws.server.model.ReturnCode;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class RuntimeHome implements Serializable {

	private static final long serialVersionUID = -2955707944574962595L;

	@Inject
	private BackendBean backendBean;

	@PostConstruct
	public void init() {
		// this.backend.init(this.getClass().getClassLoader().getResource("data.xml").getFile());
		 this.backendBean.init();
	}
	
	private void sample() {
		@SuppressWarnings("unused")
		List<App> appList = this.backendBean.findAll();
		@SuppressWarnings("unused")
		App app = this.backendBean.get(1L);
		@SuppressWarnings("unused")
		ReturnCode rc = this.backendBean.delete(2L);
		@SuppressWarnings("unused")
		List<App> findList = this.backendBean.find("ChroFox");
		byte[] barray = this.backendBean.getBinary(1L);
		// 4L, "Go!", "The Game", 0.25, activated, new Date(),
		this.backendBean.update(4L, "The Game Go", "new description", 99.99d,
				"newData".getBytes());
		appList = this.backendBean.findAll();
	}

	public String getAppCount() {
		// FIXME sample();
		return String.valueOf(this.backendBean.findAll().size());
	}
}
