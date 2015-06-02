package io.server.ws.web;

import io.server.ws.BackendBean;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@ApplicationScoped
public class RuntimeHome implements Serializable {

	private static final long serialVersionUID = -2955707944574962595L;

	private Logger log = LoggerFactory.getLogger(RuntimeHome.class);

	@Inject
	private BackendBean backendBean;

	@PostConstruct
	public void init() {
		this.backendBean.init();
	}

	public String getActiveAppCount() {
		return String.valueOf(this.backendBean.findAll().size());
	}

	public String getInactiveAppCount() {
		return String.valueOf(this.backendBean.findAllInactivated().size());
	}

	public String resetModel() {
		this.backendBean.init();
		return "/index.xhtml";
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
