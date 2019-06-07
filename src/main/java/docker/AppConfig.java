package docker;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//host:8080/docker/calculate

/**
 * Manages further web resources.
 * 
 * @author Grzegorz Norbert Rogozinski
 *
 */

@ApplicationPath("calculate")
public class AppConfig extends Application {
	private Set<Class<?>> resources = new HashSet<>();

	public AppConfig() {
		System.out.println("Created AppConfig");
		resources.add(Calculation.class);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return resources;
	}
}
