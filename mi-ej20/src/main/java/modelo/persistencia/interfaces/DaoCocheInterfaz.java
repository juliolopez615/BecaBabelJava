package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Coche;


public interface DaoCocheInterfaz {
	boolean alta(Coche c);
	boolean baja(int id);
	boolean modificar(Coche c);
	Coche buscarid(int id);
	Coche buscarmatricula(int matricula);
	List<Coche> buscarmarca(String marca);
	List<Coche> buscarmodelo(String modelo);
	List<Coche> listar();

}
