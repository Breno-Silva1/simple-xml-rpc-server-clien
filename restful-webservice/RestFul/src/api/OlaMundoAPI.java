package api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ola")
public class OlaMundoAPI {

	@GET
	@Path("/html")
	@Produces(MediaType.TEXT_HTML)
	public String sayHelloHTML(){
		return "<html>"
				+ "<meta charset=\"UTF-8\">"
				+ "<h1>Olá Mundo!</h1>"
				+ "</html>";
	}
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloJSON(){
		String jsonFormattedResponse = "['hello world!']";
	    return jsonFormattedResponse;
	}
	
	@GET
	@Path("/xml")
	@Produces(MediaType.TEXT_XML)
	public String sayHelloXML(){
		return "<?xml version = '1.0' encoding='UTF-8'?>"
				+ "<hello>"
				+ "	<titulo> Ola Mundo </titulo>"
				+ "	<mensagem> Esta eh uma mensagem de ola mundo! </mensagem>"
				+ "</hello>";
	}
	
	@GET
	@Path("/text")
	@Produces("text/plain")
	public String sayHello(){
		return "Olá Mundo!";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayRotas(){
		return "<html>"
				+ "<meta charset=\"UTF-8\">"
				+ "<h1>Rotas:</h1>"
				+ "<a href='http://localhost:8080/RestFul/ola/xml'>xml</a><br>"
				+ "<a href='http://localhost:8080/RestFul/ola/json'>json</a><br>"
				+ "<a href='http://localhost:8080/RestFul/ola/html'>hmtl</a><br>"
				+ "<a href='http://localhost:8080/RestFul/ola/text'>text</a>"
				+ "</html>";
	}
	
}
