package io.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;

import lombok.AccessLevel;
<<<<<<< HEAD
import lombok.Getter;
=======
import lombok.AllArgsConstructor;
import lombok.Data;
>>>>>>> 255ef0f085ce6fa883217fd99677bafe1bf16ed8
import lombok.Setter;

/**
 * Application domain model.
 * 
 * @author s7n
 */
<<<<<<< HEAD
@Getter
@Setter
=======
@Data
@AllArgsConstructor
>>>>>>> 255ef0f085ce6fa883217fd99677bafe1bf16ed8
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
