package io.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * Application domain model.
 * 
 * @author s7n
 */
@Getter
@Setter
public class App {

	@XmlAttribute
	@Setter(value = AccessLevel.NONE)
	private Long id;

	private String name;

	private String description;

	private Double price;

	private boolean activated;

	private Date adddate;

	private String checksum;

	private String appdata;

}
