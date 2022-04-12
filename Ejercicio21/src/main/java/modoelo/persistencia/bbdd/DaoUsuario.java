package modoelo.persistencia.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Usuario;


public class DaoUsuario {
	
static {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");//Mysql8
	} catch (ClassNotFoundException e) {
		System.out.println("No se ha encontrado el driver para MySQL");
	}
	System.out.println("Se ha cargado el Driver de MySQL");
}
private Connection conexion;
	
	public boolean abrirConexion(){
		String url = "jdbc:mysql://localhost:3306/usuarios";
		String usuario = "root";
		String password = "";
		try {
			conexion = DriverManager.getConnection(url,usuario,password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean cerrarConexion(){
		try {
			conexion.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * 
	 * @param parameter usuario que se quiere buscar
	 * @return null si el usuario no existe, objeto de tipo usuario si existe.
	 */
	public Usuario buscar(String parameter) {
		Usuario userTemp = null;
		if(!abrirConexion()){
			System.out.println("No se ha hecho la búsqueda correctamente");
			return userTemp;
		}
		String query = "select user, password from usuario "
				+ "where user = ?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, parameter);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				userTemp = new Usuario();
				userTemp.setUsuario(rs.getString(1));
				userTemp.setPassword(rs.getString(2));
			}
		} catch (SQLException e) {
			System.out.println("No se encontró el usuario.");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		return userTemp;
	}

}
