package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import entidade.OlaMundo;


public class ClienteOlaMundo {

	public static void main(String[] args) throws JAXBException {
		try {
			
			URL url = new URL("http://localhost:8080/RestFul/ola/xml");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));

			JAXBContext context = JAXBContext.newInstance(OlaMundo.class);

			Unmarshaller unmarshaller = context.createUnmarshaller();
			OlaMundo ola = (OlaMundo) unmarshaller.unmarshal(br);
			 
			System.out.println("===== FROM REST API =====");
			System.out.println("Título: " + ola.getTitulo());
			System.out.println("Mensagem: " + ola.getMensagem());
	
			con.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
