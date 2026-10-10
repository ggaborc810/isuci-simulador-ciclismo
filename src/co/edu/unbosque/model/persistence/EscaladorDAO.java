/**
 * persistence package, this is where we can cure the DTO classes
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.EscaladorDTO;
import co.edu.unbosque.model.UsuarioDTO;

/**
 * Clase donde se podra crear, actualizar, elimianar y mostrar los objetos.
 * Implementa las funciones de la interfaz CRUDOperarion
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */

public class EscaladorDAO implements CRUDOperation<EscaladorDTO> {
	/**
	 * lista de escaladores
	 * 
	 * @type ArrayList<>
	 */
	private ArrayList<UsuarioDTO> listaEscaladores;

	/**
	 * Constructor de la clase CiclistaDAO se crea la instancia de la lista
	 * 
	 * @param listaCiclistas
	 */
	public EscaladorDAO(ArrayList<UsuarioDTO> listaEscaladores) {
		this.listaEscaladores = listaEscaladores;
		listaEscaladores = new ArrayList<>();
	}

	/**
	 * Funcion que crea un objeto de EscaladorDTO
	 * 
	 * @return menaje en forma de texto
	 */
	@Override
	public String create(EscaladorDTO data) {
		listaEscaladores.add(data);
		return "Ciclista Escalador: \n" + data.toString() + "creado.";
	}

	/**
	 * Funcion que actualiza a los datos de un objeto de tipo EscaladorDTO de la
	 * lista
	 * 
	 * @return mensaje tipo texto
	 */
	@Override
	public String update(int index, EscaladorDTO newData) {
		if (index < 0) {
			return "Posiciones no pueden ser negativas";
		}
		if (index >= listaEscaladores.size()) {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listaEscaladores.size()
					+ " datos";
		}
		listaEscaladores.set(index, newData);
		return "Ciclista Escalador actualizado con exito";
	}

	/**
	 * Funcion que muestra todos los objetos de la lista
	 * 
	 * @return los objetos en texto
	 */
	@Override
	public String readAll() {
		StringBuilder sb = new StringBuilder();
		listaEscaladores.forEach((e) -> {
			sb.append(e.toString());
		});
		return sb.toString();
	}

	/**
	 * Funcion que elimina un objeto de la lista
	 * 
	 * @return mensaje tipo texto
	 */
	@Override
	public String delete(int index) {
		if (index < 0 || index >= listaEscaladores.size()) {
			return "Ciclista Escalador con índice " + index + " no eliminado.";
		} else {
			listaEscaladores.remove(index);
			return "Ciclista Escalador con índice " + index + " ha sido eliminado.";

		}
	}

	/**
	 * Obtiene la lista de escaladores
	 * 
	 * @return listaEscaladores
	 */
	public ArrayList<UsuarioDTO> getListaEscaladores() {
		return listaEscaladores;
	}

	/**
	 * Establece la lista de escaladores
	 * 
	 * @param listaEscaladores
	 */
	public void setListaEscaladores(ArrayList<UsuarioDTO> listaEscaladores) {
		this.listaEscaladores = listaEscaladores;
	}

}
