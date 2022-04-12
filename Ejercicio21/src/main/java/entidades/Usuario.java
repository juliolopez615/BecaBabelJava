package entidades;

public class Usuario {
	//Atributos
	private String usuario;
	private String password;
	
	//Constructores
	public Usuario(){
		super();
	}
	
	public Usuario(String nombre, String password) {
		this.usuario = nombre;
		this.password = password;
	}
	
	//Getters y Setters
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

