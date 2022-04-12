package validador;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Validador {
	/**
	 * Hacemos una peticion al servicio que nos devuelve un Json string. Convertimos ese String en un objeto Json
	 * para acceder a sus valores y devolvemos true o false en función de los mismos.
	 * 
	 * @param user que se desea comprobar
	 * @param password que se desea comprobar
	 * @return verdadero si el usuario y contraseña son correctos y se encuentran en base de datos. Falso
	 * si el usuario o contraseña no están en base de datos.
	 */
	public boolean validar(String user, String password) {
		
		try {
			
			HttpRequest request = HttpRequest.newBuilder()
					  .uri(new URI("http://localhost:8080/Ejercicio21/usuarios/login?"
					  		+ "nombre="+ user +"&password=" + password))
					  .GET()
					  .build();
			
			HttpClient client = HttpClient.newHttpClient();
			
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			
			System.out.println(response.body());
			
			JSONParser parser = new JSONParser();
			try {
				JSONObject json = (JSONObject) parser.parse(response.body());
				if((boolean) json.get("validado")) {
					return true;
				} else {
					return false;
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}


