package servlets;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import entidades.Usuario;
import modoelo.persistencia.bbdd.DaoUsuario;

@WebServlet("/usuarios/login")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Metodo get. Creamos 2 objetos de tipo json con jsonObject. Creamos las cabeceras para indicar que la respuesta
	 * es un json y eviamos la respuesta haciendo una petición antes a la base de datos para comprobar la información.
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String usuario = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		DaoUsuario dao = new DaoUsuario();
		Usuario user = new Usuario();
		
		String json = "{ \"validado\": true }";
		JsonObject validado = new Gson().fromJson(json, JsonObject.class);
		
		String _json = "{ \"validado\": false }";
		JsonObject novalidado = new Gson().fromJson(_json, JsonObject.class);
		
		PrintWriter out = response.getWriter();
		out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        //nos llaman desde distintos dominiios
        response.addHeader("Access-Control-Allow-Origin", "*");
		
		user = dao.buscar(usuario);
		
		if(!(user == null)) {
			if(user.getPassword().equals(password)) {
		        out.print(validado);
		        out.flush();   
			}
			else{
		        out.print(novalidado);
		        out.flush(); 
			}
			
		}else {
	        out.print(novalidado);
	        out.flush(); 
		}	
		
	}

}
