package io.server.ws.model;

import java.awt.Image;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Application domain model.
 * 
 * @author s7n
 */
@Getter
@Setter
@AllArgsConstructor
public class App {

	@XmlAttribute
	@Setter(value = AccessLevel.NONE)
	private Long id;

	private String name;

	private String description;

	private Double price;

	private boolean activated;

	private Date addDate;

	private String appUrl;
	
	private String checksum;
	
	private Image image;

}
