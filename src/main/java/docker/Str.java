package docker;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Str {
	@XmlElement private String str;

	public Str() {
	}

	public void setString(String new_str) {
		str = new_str;
	}

	public String getString() {
		return str;
	}
}