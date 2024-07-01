package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Almacenes {
	private ArrayList<Almacen> listAlmacenes;

	public Almacenes() {
		this.listAlmacenes = new ArrayList<Almacen>(); 
	}

	public ArrayList<Almacen> getListAlmacenes() {
		return listAlmacenes;
	}

	public void setListAlmacenes(ArrayList<Almacen> listAlmacenes) {
		this.listAlmacenes = listAlmacenes;
	}
	
	public void agregar(Almacen almacen) {
		this.listAlmacenes.add(almacen);
	}

	
	public int tamanio() {
		return this.listAlmacenes.size();
	}
	
	public int ultimo() {
		//ordena en forma descendente
        Collections.sort(listAlmacenes, Comparator.comparing(Almacen::getCodigoAlmacen));
        // Obtiene el último almacen (el que tiene el código más alto)
        Almacen ultimoAlmacen = listAlmacenes.get(listAlmacenes.size() - 1);
        
        return ultimoAlmacen.getCodigoAlmacen();
	}
	public Almacen navegarAlmacens(int posicion) {
		Collections.sort(listAlmacenes, Comparator.comparing(Almacen::getCodigoAlmacen));
        return listAlmacenes.get(posicion);
	}
	
	public boolean actualizar(Almacen almacen) {
		boolean isActualizado=false;
		for(Almacen filaAlmacen: listAlmacenes) {
			if(filaAlmacen.getCodigoAlmacen()==almacen.getCodigoAlmacen()) {
				filaAlmacen.setCodigoAlmacen(almacen.getCodigoAlmacen());
				filaAlmacen.setCodigoAutomovil(almacen.getCodigoAutomovil());
				filaAlmacen.setCantidadIngreso(almacen.getCantidadIngreso());
				filaAlmacen.setFechaRegistro(almacen.getFechaRegistro());
				filaAlmacen.setNombreUsuario(almacen.getNombreUsuario());
				filaAlmacen.setAnulado(almacen.isAnulado());
				isActualizado = true;
				break;
			}
		}
		return isActualizado;
	}
	
	public boolean anular(Almacen almacen) {
		boolean isAnulado=false;
		for(Almacen filaAlmacen: listAlmacenes) {
			if(filaAlmacen.getCodigoAlmacen()==almacen.getCodigoAlmacen()) {
				filaAlmacen.setAnulado(true);
				isAnulado = true;
				break;
			}
		}
		return isAnulado;
	}

	
	public Almacen busqueda(int id) {
		for(Almacen auto: listAlmacenes) {
			if(auto.getCodigoAlmacen()==id) {
				return auto;
			}
		}
		return null;
	}
}
