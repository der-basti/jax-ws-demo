package io.server.ws.model;

import java.awt.Image;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

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

	@XmlAttribute(required = true)
	@Setter(value = AccessLevel.NONE)
	private Long id;

	@XmlElement(required = true)
	private String name;

	@XmlElement(required = true)
	private String description;

	@XmlElement(required = true)
	private Double price;

	@XmlElement(required = true)
	private boolean activated;

	@XmlElement(required = true)
	private Date addDate;

	@XmlElement(required = true)
	private String appUrl;

	@XmlElement(required = true)
	private String checksum;

	private Image image;

}
