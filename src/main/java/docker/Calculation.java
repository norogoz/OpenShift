package docker;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("")
public class Calculation {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{e}")
	public String get(@PathParam("e") String e) {
		String result = calculate(e);
		return result;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("post")
	public Response post(final Str e) {
		String result = calculate(e.getString());
		return Response.status(201).entity("{\"str\" : \"" + result + "\"}").build();
	}

	private String calculate(String expression) {
		String value = "";
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");

		try {
			value = engine.eval(expression).toString();
		} catch (ScriptException e1) {
			e1.printStackTrace();
			System.out.println(expression);
		}
		return value;
	}
}