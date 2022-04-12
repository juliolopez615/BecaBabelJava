package modoelo.persistencia.bbdd;

import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.interfaces.DaoCocheInterfaz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoCoche implements DaoCocheInterfaz {
	private Connection conexion;
	
	public boolean abrirConexion(){
		String url = "jdbc:mysql://localhost:3306/coches";
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
	
	@Override
	public boolean alta(Coche c) {
		if(!abrirConexion()){
			return false;
		}
		boolean alta = true;
		
		String query = "insert into coche (MATRICULA, MARCA, MODELO, KILOMETROS) "
				+ " values(?,?,?,?)";
		try {
			//preparamos la query con valores parametrizables(?)
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, c.getMatricula());
			ps.setString(2, c.getMarca());
			ps.setString(3, c.getModelo());
			ps.setInt(4, c.getKilometros());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0) {
				alta = false;
			}
		} catch (SQLException e) {
			System.out.println("Error al insertar el elemento (ALTA): " + c);
			alta = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return alta;
	}

	@Override
	public boolean baja(int id) {
		if(!abrirConexion()){
			return false;
		}
		
		boolean borrado = true;
		
		String query = "delete from coche where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			//sustituimos la primera interrgante por la id
			ps.setInt(1, id);
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				borrado = false;
		} catch (SQLException e) {
			System.out.println("No se ha dado de baja"
					+ " el id " + id + " (BAJA)");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return borrado; 
	}

	@Override
	public boolean modificar(Coche c) {
		if(!abrirConexion()){
			return false;
		}
		boolean modificado = true;
		String query = "update coche set MATRICULA=?, MARCA=?, "
				+ "MODELO=?, KILOMETROS=? WHERE ID=?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, c.getMatricula());
			ps.setString(2, c.getMarca());
			ps.setString(3, c.getModelo());
			ps.setInt(4, c.getKilometros());
			ps.setInt(5, c.getId());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				modificado = false;
			else
				modificado = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al modificar el coche " + c + " (MODIFICAR");
			modificado = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return modificado;
	}

	@Override
	public List<Coche> listar() {
		List<Coche> cocheList = new ArrayList<Coche>();
		Coche cocheTemp = null;
		
		if(!abrirConexion()){
			System.out.println("No se ha hecho la búsqueda correctamente");
			return cocheList;
		}
		String query = "select * from coche ";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
						
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				cocheTemp = new Coche();
				cocheTemp.setId(rs.getInt(1));
				cocheTemp.setMatricula(rs.getInt(2));
				cocheTemp.setMarca(rs.getString(3));
				cocheTemp.setModelo(rs.getString(4));
				cocheTemp.setKilometros(rs.getInt(5)); 
				
				cocheList.add(cocheTemp);
			}
		} catch (SQLException e) {
			System.out.println("No se encontró el listado de coches");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		return cocheList;
	}

	@Override
	public Coche buscarid(int id) {
		Coche cocheTemp = null;
		if(!abrirConexion()){
			System.out.println("No se ha hecho la búsqueda correctamente");
			return cocheTemp;
		}
		String query = "select ID, MATRICULA, MARCA, MODELO, KILOMETROS from coche "
				+ "where ID = ?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				cocheTemp = new Coche();
				cocheTemp.setId(rs.getInt(1));
				cocheTemp.setMatricula(rs.getInt(2));
				cocheTemp.setMarca(rs.getString(3));
				cocheTemp.setModelo(rs.getString(4));
				cocheTemp.setKilometros(rs.getInt(5));
			}
		} catch (SQLException e) {
			System.out.println("No se encontró el coche con id " + id + " (BUSCARID)");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		
		return cocheTemp;
	}

	@Override
	public Coche buscarmatricula(int matricula) {
		Coche cocheTemp = null;
		if(!abrirConexion()){
			System.out.println("No se ha hecho la búsqueda correctamente");
		}
		String query = "select ID, MATRICULA, MARCA, MODELO, KILOMETROS from coche "
				+ "where MATRICULA = ?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, matricula);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				cocheTemp = new Coche();
				cocheTemp.setId(rs.getInt(1));
				cocheTemp.setMatricula(rs.getInt(2));
				cocheTemp.setMarca(rs.getString(3));
				cocheTemp.setModelo(rs.getString(4));
				cocheTemp.setKilometros(rs.getInt(5));
			}
		} catch (SQLException e) {
			System.out.println("No se encontró el coche con matricula " + matricula + " (BUSCARMATRICULA)");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		
		return cocheTemp;
	}

	@Override
	public List<Coche> buscarmarca(String marca) {
		List<Coche> cocheList = new ArrayList<Coche>();
		Coche cocheTemp = null;
		
		if(!abrirConexion()){
			System.out.println("No se ha hecho la búsqueda correctamente");
			return cocheList;
		}
		String query = "select ID, MATRICULA, MARCA, MODELO, KILOMETROS from coche "
				+ "where MARCA = ?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, marca);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				cocheTemp = new Coche();
				cocheTemp.setId(rs.getInt(1));
				cocheTemp.setMatricula(rs.getInt(2));
				cocheTemp.setMarca(rs.getString(3));
				cocheTemp.setModelo(rs.getString(4));
				cocheTemp.setKilometros(rs.getInt(5)); 
				
				cocheList.add(cocheTemp);
			}
		} catch (SQLException e) {
			System.out.println("No se encontró el coche con marca " + marca + " (BUSCARMARCA)");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		
		return cocheList;
	}

	@Override
	public List<Coche> buscarmodelo(String modelo) {
		List<Coche> cocheList = new ArrayList<Coche>();
		Coche cocheTemp = null;
		
		if(!abrirConexion()){
			System.out.println("No se ha hecho la búsqueda correctamente");
			return cocheList;
		}
		String query = "select ID, MATRICULA, MARCA, MODELO, KILOMETROS from coche "
				+ "where MODELO = ?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, modelo);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				cocheTemp = new Coche();
				cocheTemp.setId(rs.getInt(1));
				cocheTemp.setMatricula(rs.getInt(2));
				cocheTemp.setMarca(rs.getString(3));
				cocheTemp.setModelo(rs.getString(4));
				cocheTemp.setKilometros(rs.getInt(5)); 
				
				cocheList.add(cocheTemp);
			}
		} catch (SQLException e) {
			System.out.println("No se encontró el coche con modelo " + modelo + " (BUSCARMODELO)");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		
		return cocheList;
	}
	
}
