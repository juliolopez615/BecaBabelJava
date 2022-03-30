package modelo.entidad;

public class Coche {
	
	//Atributos
	private int id = -1;
	private int matricula;
	private String marca;
	private String modelo;
	private int kilometros;
	
	//Constructores
	public Coche() {}
	
	public Coche(int matricula, String marca, String modelo, int kilometros) {
		super();
		
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.kilometros = kilometros;
	}
	
	//Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getKilometros() {
		return kilometros;
	}
	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}
	
	//Tostring
	@Override
	public String toString() {
		return "Coche [id=" + id + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo
				+ ", kilometros=" + kilometros + "]";
	}
}
