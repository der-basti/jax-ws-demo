package io.server.ws.samples;

import io.server.ws.model.ModelGenerator;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.activation.DataHandler;
import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.soap.MTOM;

/**
 * Binary transport samples.
 * 
 * @author s7n
 *
 */
// Sources:
// https://jax-ws.java.net/2.2/docs/mtom-swaref.html
// https://docs.oracle.com/cd/E17802_01/webservices/webservices/docs/2.0/jaxws/mtom-swaref.html
// http://www.mkyong.com/webservices/jax-ws/jax-ws-attachment-with-mtom/
// https://metro.java.net/nonav/1.2/guide/Binary_Attachments__MTOM_.html#MTOM_threshold
@MTOM(threshold = 3000)
@WebService
public class BinaryService {

	/**
	 * @return MIME Type: image/gif or image/jpeg
	 */
	public Image getImage() {
		try {
			return ImageIO.read(new File(ModelGenerator.getRessouceImage()));
		} catch (final IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @return MIME Type: text/plain
	 */
	public String getString() {
		return "nill";
	}

	/**
	 * @return MIME Type: text/xml or application/xml
	 */
	public Source getSouce() {
		return new StreamSource(new StringReader("Source Text"));
	}

	/**
	 * @return MIME Type: *
	 */
	public DataHandler getData() {
		return new DataHandler("Test content string :"
				+ System.currentTimeMillis(), "your/mimeType");
	}

}
