/**
 * persistence package, this is where we can cure the DTO classes
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.ClasicoManoDTO;
import co.edu.unbosque.model.ContraRelojDTO;
import co.edu.unbosque.model.DirectorDeportivoDTO;
import co.edu.unbosque.model.EmbaladorDTO;
import co.edu.unbosque.model.EscaladorDTO;
import co.edu.unbosque.model.GregarioDTO;
import co.edu.unbosque.model.MasajistaDTO;
import co.edu.unbosque.model.RodadorDTO;
import co.edu.unbosque.model.UsuarioDTO;

/**
 * Class where objects can be created, updated, deleted, and displayed.
 * Implements the functions of the CRUDOperarion interface.
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */

public class UsuarioDAO implements CRUDOperation<UsuarioDTO> {

	/**
	 * List of users
	 * 
	 * @type ArrayList<>
	 */
	private ArrayList<UsuarioDTO> listaUsuarios;
	/**
	 * Directory where the list of users will be saved in a file
	 * 
	 * @type String
	 */
	private final String FILE_NAME = "datos/ListaUsuarios.txt";
	/**
	 * Directory where the list of users will be saved in a serialized file
	 * 
	 * @type String
	 */
	private final String SERIALIZED_FILE_NAME = "datos/ListaCompletaUsuarios.isuci";

	/**
	 * Constructor of the UsuarioDAO class creates an instance of the list
	 * 
	 * @param listaCiclistas
	 */
	public UsuarioDAO() {
		listaUsuarios = new ArrayList<>();
		leerDesdeArchivoSerializado();
//		listaUsuarios=(ArrayList<UsuarioDTO>)FileHandler.abrirLeerSerializado(NOMBRE_ARCHIVO_SERIALIZADO);
		FileHandler.abrirYEscribirEnSerializable(SERIALIZED_FILE_NAME, listaUsuarios);
	}

	/**
	 * Function to write to the file
	 */
	public void escribirArchivo() {
		String contenido = "";

		for (int i = 0; i < listaUsuarios.size(); i++) {
			contenido += listaUsuarios.get(i).getCedula() + ";";
			contenido += listaUsuarios.get(i).getGenero() + ";";
			contenido += listaUsuarios.get(i).getCorreoElectronico() + ";";
			contenido += listaUsuarios.get(i).getId() + ";";
			contenido += listaUsuarios.get(i).getContrasenia() + ";";
			contenido += listaUsuarios.get(i).getId();

			if (i < listaUsuarios.size() - 1) {
				contenido += "\n";
			}
		}

		FileHandler.abrirYEscribirArchivo(FILE_NAME, contenido);

	}

	/**
	 * Function to read the file
	 */
	public void leerDeArchivos() {
		String contenido = "";
		contenido = FileHandler.abrirYLeerArchivo(FILE_NAME);
		if (contenido.equals("")) {
			listaUsuarios = new ArrayList<>();
			return;

		}

		String[] filas = contenido.split("\n");

		for (int i = 0; i < filas.length; i++) {

			String[] columnas = filas[i].split(";");
			UsuarioDTO aux = new UsuarioDTO();

			aux.setCedula(Long.parseLong(columnas[0]));
			aux.setGenero(columnas[1]);
			aux.setCorreoElectronico(columnas[2]);
			aux.setId(columnas[3]);
			aux.setContrasenia(columnas[4]);

			listaUsuarios.add(aux);
		}

	}

	/**
	 * Function to read a serialized file
	 */
	public void leerDesdeArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);
		if (contenido == null) {
			listaUsuarios = new ArrayList<>();
		} else {
			listaUsuarios = (ArrayList<UsuarioDTO>) contenido;
		}
	}

	/**
	 * Function that creates a type of user and returns a message
	 * 
	 * @return message
	 */
	@Override
	public String create(UsuarioDTO data) {

		if (data instanceof EscaladorDTO) {
			EscaladorDTO miEscalador = (EscaladorDTO) data;
			new EscaladorDAO(listaUsuarios).create(miEscalador);
		}
		if (data instanceof CiclistaDTO) {
			CiclistaDTO miCiclista = (CiclistaDTO) data;
			new CiclistaDAO(listaUsuarios).create(miCiclista);
		}
		if (data instanceof ClasicoManoDTO) {
			ClasicoManoDTO miClasicoMano = (ClasicoManoDTO) data;
			new ClasicoManoDAO(listaUsuarios).create(miClasicoMano);
		}
		if (data instanceof ContraRelojDTO) {
			ContraRelojDTO miContraReljo = (ContraRelojDTO) data;
			new ContraRelojDAO(listaUsuarios).create(miContraReljo);
		}
		if (data instanceof DirectorDeportivoDTO) {
			DirectorDeportivoDTO miDirectorDeportivo = (DirectorDeportivoDTO) data;
			new DirectorDeportivoDAO(listaUsuarios).create(miDirectorDeportivo);
		}
		if (data instanceof EmbaladorDTO) {
			EmbaladorDTO miEmbalador = (EmbaladorDTO) data;
			new EmbaladorDAO(listaUsuarios).create(miEmbalador);
		}
		if (data instanceof MasajistaDTO) {
			MasajistaDTO miMasajista = (MasajistaDTO) data;
			new MasajistaDAO(listaUsuarios).create(miMasajista);
		}
		if (data instanceof GregarioDTO) {
			GregarioDTO miGregario = (GregarioDTO) data;
			new GregarioDAO(listaUsuarios).create(miGregario);
		}
		if (data instanceof RodadorDTO) {
			RodadorDTO miRodador = (RodadorDTO) data;
			new RodadorDAO(listaUsuarios).create(miRodador);
		}
		listaUsuarios.add(data);
		escribirArchivo();
		FileHandler.abrirYEscribirEnSerializable(SERIALIZED_FILE_NAME, listaUsuarios);
		return "User: \n" + data.toString() + "created.";
	}

	/**
	 * Function that displays all objects in the list
	 * 
	 * @return objects in text
	 */
	@Override
	public String readAll() {
		StringBuilder sb = new StringBuilder();
		listaUsuarios.forEach((e) -> {
			sb.append(e.toString());
		});
		return sb.toString();
	}

	/**
	 * Function to find the position in the list by id
	 * 
	 * @param id
	 * @return int
	 */
	public int buscarPosicion(String id) {

		int index = -1;

		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getId().equals(id))
				index = i;
		}

		return index;
	}

	/**
	 * Function that updates the data of a UsuarioDTO object in the list
	 * 
	 * @return text message
	 */

	@Override
	public String update(int index, UsuarioDTO newData) {
		if (newData instanceof EscaladorDTO) {
			EscaladorDTO miEscalador = (EscaladorDTO) newData;
			new EscaladorDAO(listaUsuarios).update(index, miEscalador);
		}
		if (newData instanceof CiclistaDTO) {
			CiclistaDTO miCiclista = (CiclistaDTO) newData;
			new CiclistaDAO(listaUsuarios).update(index, miCiclista);
		}
		if (newData instanceof ClasicoManoDTO) {
			ClasicoManoDTO miClasicoMano = (ClasicoManoDTO) newData;
			new ClasicoManoDAO(listaUsuarios).update(index, miClasicoMano);
		}
		if (newData instanceof ContraRelojDTO) {
			ContraRelojDTO miContraReljo = (ContraRelojDTO) newData;
			new ContraRelojDAO(listaUsuarios).update(index, miContraReljo);
		}
		if (newData instanceof DirectorDeportivoDTO) {
			DirectorDeportivoDTO miDirectorDeportivo = (DirectorDeportivoDTO) newData;
			new DirectorDeportivoDAO(listaUsuarios).update(index, miDirectorDeportivo);
		}
		if (newData instanceof EmbaladorDTO) {
			EmbaladorDTO miEmbalador = (EmbaladorDTO) newData;
			new EmbaladorDAO(listaUsuarios).update(index, miEmbalador);
		}
		if (newData instanceof MasajistaDTO) {
			MasajistaDTO miMasajista = (MasajistaDTO) newData;
			new MasajistaDAO(listaUsuarios).update(index, miMasajista);
		}
		if (newData instanceof GregarioDTO) {
			GregarioDTO miGregario = (GregarioDTO) newData;
			new GregarioDAO(listaUsuarios).update(index, miGregario);
		}
		if (newData instanceof RodadorDTO) {
			RodadorDTO miRodador = (RodadorDTO) newData;
			new RodadorDAO(listaUsuarios).update(index, miRodador);
		}
		if (index < 0) {
			return "Positions cannot be negative";
		}
		if (index >= listaUsuarios.size()) {
			return "The index has exceeded the size of the list, current size: " + listaUsuarios.size() + " data";
		}
		listaUsuarios.set(index, newData);
		escribirArchivo();
		FileHandler.abrirYEscribirEnSerializable(SERIALIZED_FILE_NAME, listaUsuarios);
		return "User updated successfully";
	}

//	-------------------------------------------------
	/**
	 * Function that writes to serialized
	 * 
	 * @return
	 */
	public String update() {

		escribirArchivo();
		FileHandler.abrirYEscribirEnSerializable(SERIALIZED_FILE_NAME, listaUsuarios);
		return "User updated successfully";
	}
//--------------------------------------------------------------------

	/**
	 * Function that deletes an object from the list
	 * 
	 * @return text message
	 */
	@Override
	public String delete(int index) {
		if (index < 0 || index >= listaUsuarios.size()) {
			return "User with index " + index + " not deleted.";

		} else {
			listaUsuarios.remove(index);
			escribirArchivo();
			FileHandler.abrirYEscribirEnSerializable(SERIALIZED_FILE_NAME, listaUsuarios);
			return "User with index " + index + " has been deleted \n redirecting to login";

		}
	}

	/**
	 * Function that retrieves the user found by its id
	 * 
	 * @param id
	 * @return UsuarioDTO
	 */
	public UsuarioDTO getUsuarios(String id) {
		UsuarioDTO user = null;

		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getId().equals(id))
				user = listaUsuarios.get(i);
		}

		return user;
	}

	/**
	 * Gets the list of users
	 * 
	 * @return listaUsuarios
	 */
	public ArrayList<UsuarioDTO> getListaUsuarios() {
		return listaUsuarios;
	}

	/**
	 * Sets the list of users
	 * 
	 * @param listaUsuarios
	 */
	public void setListaUsuarios(ArrayList<UsuarioDTO> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
