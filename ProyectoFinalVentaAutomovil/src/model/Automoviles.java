package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Automoviles {
	private ArrayList<Automovil> listAutomoviles;

	public Automoviles() {
		this.listAutomoviles = new ArrayList<Automovil>(); 
	}

	public ArrayList<Automovil> getListAutomoviles() {
		return listAutomoviles;
	}

	public void setListAutomoviles(ArrayList<Automovil> listAutomoviles) {
		this.listAutomoviles = listAutomoviles;
	}
	
	public void agregar(Automovil automovil) {
		this.listAutomoviles.add(automovil);
	}

	
	public int tamanio() {
		return this.listAutomoviles.size();
	}
	
	public int ultimo() {
		//ordena en forma descendente
        Collections.sort(listAutomoviles, Comparator.comparing(Automovil::getCodigoAutomovil));
        // Obtiene el último automovil (el que tiene el código más alto)
        Automovil ultimoAutomovil = listAutomoviles.get(listAutomoviles.size() - 1);
        
        return ultimoAutomovil.getCodigoAutomovil();
	}
	public Automovil navegarAutomovils(int posicion) {
		Collections.sort(listAutomoviles, Comparator.comparing(Automovil::getCodigoAutomovil));
        return listAutomoviles.get(posicion);
	}
	
	public boolean actualizar(Automovil automovil) {
		boolean isActualizado=false;
		for(Automovil auto: listAutomoviles) {
			if(auto.getCodigoAutomovil()==automovil.getCodigoAutomovil()) {
				auto.setCodigoAutomovil(automovil.getCodigoAutomovil());
				auto.setMarca(automovil.getMarca());
				auto.setModelo (automovil.getModelo());
				auto.setAnioFabricacion (automovil.getAnioFabricacion());
				auto.setPais(automovil.getPais());
				auto.setColor(automovil.getColor());
				auto.setEsAutomatico(automovil.isEsAutomatico());
				auto.setPrecio(automovil.getPrecio());
				auto.setCantidadAsientos(automovil.getCantidadAsientos ());
				auto.setTipoCombustible(automovil.getTipoCombustible());
				auto.setStockActual(automovil.getStockActual());
				auto.setStockMinimo(automovil.getStockMinimo());
				auto.setStockMaximo(automovil.getStockMaximo());
				auto.setEstado(automovil.isEstado());
				isActualizado = true;
				break;
			}
		}
		return isActualizado;
	}
	
	public boolean eliminar(Automovil automovil) {
		boolean isEliminado=false;
		for(Automovil auto: listAutomoviles) {
			if(auto.getCodigoAutomovil()==automovil.getCodigoAutomovil()) {
				listAutomoviles.remove(automovil);
				isEliminado = true;
				break;
			}
		}
		return isEliminado;
	}
	
	public Automovil busqueda(int id) {
		for(Automovil auto: listAutomoviles) {
			if(auto.getCodigoAutomovil()==id) {
				return auto;
			}
		}
		return null;
	}
	
	public void actualizarStockActual(int id,int cantidad,boolean isResta) {
		for(Automovil auto: listAutomoviles) {
			if(auto.getCodigoAutomovil()==id) {
				if(isResta) {
					auto.setStockActual(auto.getStockActual() - cantidad);
				}else {
					auto.setStockActual(auto.getStockActual() + cantidad);
				}
				break;
			}
		}
	}
	
	//valida si ya se registro el auntomovil, marca, modelo, año y color
	public boolean validarExistencia(String marca, String modelo, String anio, String color) {
		boolean isExiste=false;
		for(Automovil Auto: listAutomoviles) {
			if(Auto.getMarca().trim().equals(marca.trim()) && 
					Auto.getModelo().trim().equals(modelo.trim()) && 
					Auto.getAnioFabricacion().trim().equals(anio.trim()) &&
					Auto.getColor().trim().equals(color.trim()))  {
				isExiste = true;
				break;
			}
		}
		return isExiste;
	}
}
