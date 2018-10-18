package api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/calc")
public class CalcAPI {

	@GET
	@Path("{operacao}/{a}/{b}")
	@Produces(MediaType.TEXT_XML)
	public String calc(@PathParam("operacao") String opr, @PathParam("a") int a, @PathParam("b") int b) {
		if (opr.equals("soma"))
			return soma(a, b);
		else if (opr.equals("sub"))
			return sub(a, b);
		else if (opr.equals("mult"))
			return mult(a, b);
		else if (opr.equals("div"))
			return div(a, b);
		else 
			return "Operação inválida!";
	}

	@GET
	@Path("soma/{a}/{b}")
	@Produces(MediaType.TEXT_XML)
	public String soma(@PathParam("a") int a, @PathParam("b") int b) {
		String resultado = String.valueOf(a + b);
		return "<?xml version = '1.0' encoding='UTF-8'?>"
		+ "<calc><resultado>" + resultado +"</resultado></calc>";
	}

	@GET
	@Path("sub/{a}/{b}")
	@Produces(MediaType.TEXT_XML)
	public String sub(@PathParam("a") int a, @PathParam("b") int b) {
		String resultado = String.valueOf(a - b);
		return "<?xml version = '1.0' encoding='UTF-8'?>"
		+ "<calc><resultado>" + resultado +"</resultado></calc>";
	}

	@GET
	@Path("mult/{a}/{b}")
	@Produces(MediaType.TEXT_XML)
	public String mult(@PathParam("a") int a, @PathParam("b") int b) {
		String resultado = String.valueOf(a * b);
		return "<?xml version = '1.0' encoding='UTF-8'?>"
		+ "<calc><resultado>" + resultado +"</resultado></calc>";
	}

	@GET
	@Path("div/{a}/{b}")
	@Produces(MediaType.TEXT_XML)
	public String div(@PathParam("a") int a, @PathParam("b") int b) {
		String resultado = String.valueOf(a / b);
		return "<?xml version = '1.0' encoding='UTF-8'?>"
		+ "<calc><resultado>" + resultado +"</resultado></calc>";
	}

}
