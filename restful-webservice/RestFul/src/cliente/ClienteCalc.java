package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import entidade.Calc;

public class ClienteCalc {
	
	public static void main(String[] args) throws JAXBException {
		try {
			
			String n1 = JOptionPane.showInputDialog("Número 1:");
			String n2 = JOptionPane.showInputDialog("Número 2:");
			String opr = JOptionPane.showInputDialog("Operação:");
			
			URL url = new URL("http://localhost:8080/RestFul/calc/"+ opr +"/" + n1 + "/" + n2);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));

			JAXBContext context = JAXBContext.newInstance(Calc.class);

			Unmarshaller unmarshaller = context.createUnmarshaller();
			Calc calc = (Calc) unmarshaller.unmarshal(br);
			 
			JOptionPane.showMessageDialog(null, "Resultado: " + calc.getResultado());
	
			con.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
