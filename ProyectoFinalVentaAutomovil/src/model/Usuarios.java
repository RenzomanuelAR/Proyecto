package model;

import java.util.ArrayList;

public class Usuarios {
	private ArrayList<Usuario> listUsuarios;

	public Usuarios() {
		this.listUsuarios = new ArrayList<Usuario>();
	}

	public ArrayList<Usuario> getListUsuarios() {
		return listUsuarios;
	}

	public void setListUsuario(ArrayList<Usuario> listUsuarios) {
		this.listUsuarios = listUsuarios;
	}
	
	public void agregar(Usuario usuario) {
		this.listUsuarios.add(usuario);
	}
	
	public boolean validarInicioSesion(Usuario usuario) {
		
		for(Usuario usu: listUsuarios) {
			if(usu.getNomUsuario().equals(usuario.getNomUsuario()) && usu.getPassword().equals(usuario.getPassword())) {
				return true;
			}
		}
		return false;
	}
}
