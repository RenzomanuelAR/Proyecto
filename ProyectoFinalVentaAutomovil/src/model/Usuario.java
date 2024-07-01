package model;

public class Usuario {
	private int codigoUsuario;
	private String nomUsuario;
	private String password;
	
	public Usuario() {

	}
	
	public Usuario(int codigoUsuario, String nomUsuario, String password) {
		this.codigoUsuario = codigoUsuario;
		this.nomUsuario = nomUsuario;
		this.password = password;
	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
