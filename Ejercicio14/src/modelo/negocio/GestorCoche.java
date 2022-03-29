package modelo.negocio;

import java.util.List;

import modelo.entidad.Coche;
import modoelo.persistencia.bbdd.DaoCoche;

public class GestorCoche{
	private DaoCoche daoC = null;
	
	public boolean alta(Coche c) {
		this.daoC = new DaoCoche();
		int matricula = c.getMatricula();
		int kilometros = c.getKilometros();
		
		System.out.println(c.getMatricula());
		if(!(matricula > 999999 && matricula <= 9999999)) {
			System.out.println("Matricula no tiene 7 digitos");
			return false;
			
		} else if(this.daoC.buscarmatricula(c.getMatricula()) != null) {
			if(c.getMatricula() == this.daoC.buscarmatricula(c.getMatricula()).getMatricula()) {
				return false;
			}
			
		} else if(kilometros < 0) {
			return false;
			
		}else{
			System.out.println("Dando de alta...");
			if (this.daoC.alta(c)) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;		
	}

	public boolean baja(int id) {
		this.daoC = new DaoCoche();
		
		System.out.println("Dando de baja...");
		if (this.daoC.baja(id)) {
			return true;		
		}else {
			return false;
		}
	}

	public boolean modificar(Coche c) {
		this.daoC = new DaoCoche();
		int matricula = c.getMatricula();
		int kilometros = c.getKilometros();
		
		if(!(matricula > 999999 && matricula <= 9999999)) {
			System.out.println("Matricula no tiene 7 digitos");
			return false;
			
		} else if(kilometros < 0) {
			return false;
			
		}else{
			System.out.println("Modificando...");
			if (this.daoC.modificar(c)) {
				return true;
			}
			else {
				return false;
			}
		}
	}

	
	public Coche buscarid(int id) {
		this.daoC = new DaoCoche();
		return daoC.buscarid(id);
	}

	
	public Coche buscarmatricula(int matricula) {
		this.daoC = new DaoCoche();
		return daoC.buscarmatricula(matricula);
	}

	
	public List<Coche> buscarmarca(String marca) {
		this.daoC = new DaoCoche();
		return daoC.buscarmarca(marca);
	}

	
	public List<Coche> buscarmodelo(String modelo) {
		this.daoC = new DaoCoche();
		return daoC.buscarmodelo(modelo);
	}

	
	public List<Coche> listar() {
		this.daoC = new DaoCoche();
		return daoC.listar();
	}

}
