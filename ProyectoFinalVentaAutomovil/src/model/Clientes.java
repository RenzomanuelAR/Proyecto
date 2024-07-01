package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Clientes {
	private ArrayList<Cliente> listClientes;

	public Clientes() {
		this.listClientes = new ArrayList<Cliente>();
	}

	public ArrayList<Cliente> getListClientes() {
		return listClientes;
	}

	public void setListClientes(ArrayList<Cliente> listClientes) {
		this.listClientes = listClientes;
	}
	
	public void agregar(Cliente cliente) {
		this.listClientes.add(cliente);
	}
	
	public int tamanio() {
		return this.listClientes.size();
	}
	
	public int ultimo() {
		//ordena en forma descendente
        Collections.sort(listClientes, Comparator.comparing(Cliente::getCodigoCliente));
        // Obtiene el último cliente (el que tiene el código más alto)
        Cliente ultimoCliente = listClientes.get(listClientes.size() - 1);
        
        return ultimoCliente.getCodigoCliente();
	}
	public Cliente navegarClientes(int posicion) {
		Collections.sort(listClientes, Comparator.comparing(Cliente::getCodigoCliente));
        return listClientes.get(posicion);
	}
	
	public boolean actualizar(Cliente cliente) {
		boolean isActualizado=false;
		for(Cliente client: listClientes) {
			if(client.getCodigoCliente()==cliente.getCodigoCliente()) {
				client.setApellidos(cliente.getApellidos());
				client.setNombres(cliente.getNombres());
				client.setDireccion(cliente.getDireccion());
				client.setDni(cliente.getDni());
				client.setEmail(cliente.getEmail());
				client.setTelefono(cliente.getTelefono());
				client.setEstado(cliente.isEstado());
				isActualizado = true;
				break;
			}
		}
		return isActualizado;
	}
	
	public boolean eliminar(Cliente cliente) {
		boolean isEliminado=false;
		for(Cliente client: listClientes) {
			if(client.getCodigoCliente()==cliente.getCodigoCliente()) {
				listClientes.remove(cliente);
				isEliminado = true;
				break;
			}
		}
		return isEliminado;
	}
	
	public Cliente busqueda(int id) {
		for(Cliente client: listClientes) {
			if(client.getCodigoCliente()==id) {
				return client;
			}
		}
		return null;
	}
	
	//valida la existencia de un cliente por los nombre y apellido o por el DNI
	public boolean validarExistencia(String nombres, String apellidos, String dni) {
		boolean isExiste=false;
		for(Cliente client: listClientes) {
			if(client.getNombres().trim().equals(nombres.trim()) && client.getApellidos().trim().equals(apellidos.trim()) || 
					client.getDni().trim().equals(dni.trim())) {
				isExiste = true;
				break;
			}
		}
		return isExiste;
	}
}
