/**
 * persistence package, this is where we can cure the DTO classes
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.DirectorDeportivoDTO;
import co.edu.unbosque.model.EscuadraDTO;
import co.edu.unbosque.model.GregarioDTO;
import co.edu.unbosque.model.MasajistaDTO;
import co.edu.unbosque.model.UsuarioDTO;

/**
 * Class where objects can be created, updated, deleted, and displayed.
 * Implements the functions of the CRUDOperarion interface
 * 
 * @author Juan Diego Triana Mejía
 * @author Juan David Guarnizo Martínez
 * @author Gabriel Alejandro Ruiz Cruz
 */

public class EscuadraDAO implements CRUDOperation<EscuadraDTO>, EscuadraOp {
	/**
	 * List of cyclists
	 * 
	 * @type ArrayList<>
	 */
	private ArrayList<EscuadraDTO> listaEscuadras;
	/**
	 * Directory where the file will be saved
	 * 
	 * @type String
	 */
	private final String NOMBRE_ARCHIVO = "datos/listaEscuadras.txt";

	/**
	 * Directory where the serialized file will be saved
	 * 
	 * @type String
	 */
	private final String NOMBRE_ARCHIVO_SERIALIZADO = "datos/Escuadras.usuci";

	/**
	 * Data
	 * 
	 * @type String
	 */
	private String data;

	/**
	 * Constructor of the EscuadraDAO class creates an instance of the list
	 * 
	 * @param listaCiclistas
	 */
	public EscuadraDAO() {
		listaEscuadras = new ArrayList<>();
		leerDesdeArchivoSerializado();
		FileHandler.abrirYEscribirEnSerializable(NOMBRE_ARCHIVO_SERIALIZADO, listaEscuadras);
	}

	/**
	 * Function to write to the file
	 */
	public void escribirArchivo() {
		String contenido = "";

		for (int i = 0; i < listaEscuadras.size(); i++) {
			contenido += listaEscuadras.get(i).getNombreEscuadra() + ";";
			contenido += listaEscuadras.get(i).getTiemposCarrera() + ";";
			contenido += listaEscuadras.get(i).getPaisEscuadra();
			if (i < listaEscuadras.size() - 1) {
				contenido += "\n";
			}
		}

		FileHandler.abrirYEscribirArchivo(NOMBRE_ARCHIVO, contenido);

	}

	/**
	 * Function to read from the file
	 */
	public void leerDeArchivos() {
		String contenido = "";
		contenido = FileHandler.abrirYLeerArchivo(NOMBRE_ARCHIVO);
		if (contenido.equals("")) {
			listaEscuadras = new ArrayList<>();
			return;

		}

		String[] filas = contenido.split("\n");

		for (int i = 0; i < filas.length; i++) {

			String[] columnas = filas[i].split(";");
			EscuadraDTO aux = new EscuadraDTO();
			String[] pais = { columnas[1] };

			aux.setNombreEscuadra(columnas[0]);
			aux.setPaisEscuadra(pais);
			aux.setTiemposCarrera(Double.parseDouble(columnas[2]));

			listaEscuadras.add(aux);
		}

	}

	/**
	 * Function to read from a serialized file
	 */
	public void leerDesdeArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(NOMBRE_ARCHIVO_SERIALIZADO);
		if (contenido == null) {
			listaEscuadras = new ArrayList<>();
		} else {
			listaEscuadras = (ArrayList<EscuadraDTO>) contenido;
		}
	}

	/**
	 * Function to add a cyclist to a squad
	 */
	@Override
	public void agregarCiclistaAEscuadra(int escIndex, CiclistaDTO c) {
		listaEscuadras.get(escIndex).getListaCiclistas().add(c);
	}

	/**
	 * Function to add a masseur to a squad
	 */
	@Override
	public void agregarMasajistaAEscuadra(int escIndex, MasajistaDTO m) {
		listaEscuadras.get(escIndex).getListaMasajistas().add(m);

	}

	/**
	 * Function to add a sports director to a squad
	 */
	@Override
	public void agregarDirectorAEscuadra(int escIndex, DirectorDeportivoDTO d) {
		listaEscuadras.get(escIndex).getListaDirectores().add(d);
	}

	/**
	 * Function to verify the position of an object in the list
	 * 
	 * @param index
	 * @return text message
	 */
	public String checkIndex(int index) {
		if (index < 0) {
			return "n";
		}
		if (index > listaEscuadras.size() - 1) {
			return "o";
		}
		return "g";
	}

	/**
	 * Function to read the people from a squad
	 * 
	 * @return returns the list of people as text
	 */
	@Override
	public String leerPersonasDeEscuadra(int escIndex) {
		/**
		 * General user array
		 */

		// ArrayList<Usuario> usuarios = new ArrayList<>();

		/**
		 * Applied Polymorphism
		 */
//		Usuario aux = new CiclistaDTO();
//		Usuario aux2 = new MasajistaDTO();
//		Usuario aux3 = new GregarioDTO();
//		usuarios.add(aux);

		/**
		 * Knowing if it is from one class or another
		 */
//		if (usuarios.get(0) instanceof CiclistaDTO) {
//			System.out.println("Es ciclista");
//		}
		switch (checkIndex(escIndex)) {
		case "n": {
			return "Positions cannot be negative";
		}
		case "o": {
			return "The index has exceeded the size of the list, current size: " + listaEscuadras.size() + " data";
		}
		case "g": {
			listaEscuadras.get(escIndex).getListaCiclistas().forEach((c) -> {
				data += c.toString();
			});
			listaEscuadras.get(escIndex).getListaMasajistas().forEach((m) -> {
				data += m.toString();
			});
			listaEscuadras.get(escIndex).getListaDirectores().forEach((d) -> {
				data += d.toString();
			});
			return data;

		}
		}
		return "Error in squad printing";
	}

	/**
	 * Function to update a cyclist of a squad
	 * 
	 * @return message
	 */
	@Override
	public String ActualizarCiclista(int escIndex, int indexCicl, CiclistaDTO c) {
		switch (checkIndex(escIndex)) {
		case "n": {
			return "Positions cannot be negative";
		}
		case "o": {
			return "The index has exceeded the size of the list, current size: " + listaEscuadras.size() + " data";
		}

		case "g": {
			listaEscuadras.get(escIndex).getListaCiclistas().set(indexCicl, c);
			return "Cyclist updated successfully";
		}
		}
		return "Error in cyclist printing";
	}

	/**
	 * Function to update a masseur of a squad
	 * 
	 * @return message
	 */
	@Override
	public String ActualizarMasajista(int escIndex, int indexMas, MasajistaDTO m) {
		switch (checkIndex(escIndex)) {
		case "n": {
			return "Positions cannot be negative";
		}
		case "o": {
			return "The index has exceeded the size of the list, current size: " + listaEscuadras.size() + " data";
		}
		case "g": {
			listaEscuadras.get(escIndex).getListaMasajistas().set(indexMas, m);
			return "Masseur updated successfully";
		}
		}
		return "Error in masseur printing";
	}

	/**
	 * Function to update a sports director of a squad
	 * 
	 * @return message
	 */
	@Override
	public String ActualizarDirector(int escIndex, int indexDir, DirectorDeportivoDTO d) {
		switch (checkIndex(escIndex)) {
		case "n": {
			return "Positions cannot be negative";
		}
		case "o": {
			return "The index has exceeded the size of the list, current size: " + listaEscuadras.size() + " data";
		}
		case "g": {
			listaEscuadras.get(escIndex).getListaDirectores().set(indexDir, d);
			return "Sports director updated successfully";
		}
		}
		return "Error in director printing";
	}

	/**
	 * Function to delete a cyclist from a squad
	 * 
	 * @return message
	 */
	@Override
	public String eliminarCiclista(int escIndex, int indexCicl) {
		switch (checkIndex(escIndex)) {
		case "n": {
			return "Positions cannot be negative";
		}
		case "o": {
			return "The index has exceeded the size of the list, current size: " + listaEscuadras.size() + " data";
		}
		case "g": {
			listaEscuadras.get(escIndex).getListaCiclistas().remove(indexCicl);
			return "Cyclist deleted successfully";
		}
		}
		return "Error in cyclist printing";
	}

	/**
	 * Function to delete a masseur from a squad
	 * 
	 * @return message
	 */
	@Override
	public String eliminarMasajista(int escIndex, int indexMas) {
		switch (checkIndex(escIndex)) {
		case "n": {
			return "Positions cannot be negative";
		}
		case "o": {
			return "The index has exceeded the size of the list, current size: " + listaEscuadras.size() + " data";
		}
		case "g": {
			listaEscuadras.get(escIndex).getListaMasajistas().remove(indexMas);
			return "Masseur deleted successfully";
		}
		}
		return "Error in masseur printing";
	}

	/**
	 * Function to delete a sports director from a squad
	 * 
	 * @return message
	 */
	@Override
	public String eliminarDirector(int escIndex, int indexDir) {
		switch (checkIndex(escIndex)) {
		case "n": {
			return "Positions cannot be negative";
		}
		case "o": {
			return "The index has exceeded the size of the list, current size: " + listaEscuadras.size() + " data";
		}
		case "g": {
			listaEscuadras.get(escIndex).getListaDirectores().remove(indexDir);
			return "Director deleted successfully";
		}
		}
		return "Error in director printing";
	}

	/**
	 * Function that creates an EscuadraDTO object
	 * 
	 * @return text message
	 */
	@Override
	public String create(EscuadraDTO data) {
		listaEscuadras.add(data);
		escribirArchivo();
		FileHandler.abrirYEscribirEnSerializable(NOMBRE_ARCHIVO_SERIALIZADO, listaEscuadras);
		return "Squad: \n" + data.toString() + "created.";

	}

	/**
	 * Function that displays all objects in the list
	 * 
	 * @return objects as text
	 */
	@Override
	public String readAll() {
		StringBuilder sb = new StringBuilder();
		listaEscuadras.forEach((e) -> {
			sb.append(e.toString());
		});
		return sb.toString();
	}

	/**
	 * Function that updates the data of an EscuadraDTO type object from the list
	 * 
	 * @return text message
	 */

	@Override
	public String update(int index, EscuadraDTO newData) {
		if (index < 0) {
			return "Positions cannot be negative";
		}
		if (index >= listaEscuadras.size()) {
			return "The index has exceeded the size of the list, current size: " + listaEscuadras.size() + " data";
		}
		listaEscuadras.set(index, newData);
		return "Squad updated successfully";
	}

	/**
	 * Function that deletes an object from the list
	 * 
	 * @return text message
	 */
	@Override
	public String delete(int index) {
		if (index < 0) {
			return "Positions cannot be negative";
		}
		if (index >= listaEscuadras.size()) {
			return "The index has exceeded the size of the list, current size: " + listaEscuadras.size() + " data";
		}
		listaEscuadras.remove(index);
		return "Squad at index " + index + " deleted successfully";

	}
	
	
	/**
	 * Searches for the position of a squad in the list based on the provided identifier.
	 *
	 * @param id The identifier of the squad to find.
	 * @return The index of the squad if found, or -1 if not found.
	 */
	public int buscarPosicion(String id) {

	    int index = -1;

	    for (int i = 0; i < listaEscuadras.size(); i++) {
	        /**
	         * Iterates through the list of squads and checks if the name of the squad at the current position
	         * matches the given identifier. If a match is found, assigns the current index to the variable 'index'.
	         */
	        if (listaEscuadras.get(i).getNombreEscuadra().equals(id))
	            index = i;
	    }

	    return index;

	}


	/**
	 * Function that adds a user type to the squad
	 */
	@Override
	public void agregarUsuario(int idxEsc, UsuarioDTO u) {
		if (u instanceof CiclistaDTO)
			listaEscuadras.get(idxEsc).getListaCiclistas().add((CiclistaDTO) u);
	}

	/**
	 * Gets the list of squads
	 * 
	 * @return listaEscuadras
	 */
	public ArrayList<EscuadraDTO> getListaEscuadras() {
		return listaEscuadras;
	}

	/**
	 * Sets the list of squads
	 * 
	 * @param listaEscuadras
	 */
	public void setListaEscuadras(ArrayList<EscuadraDTO> listaEscuadras) {
		this.listaEscuadras = listaEscuadras;
	}

	/**
	 * Gets the data
	 * 
	 * @return data
	 */
	public String getData() {
		return data;
	}

	/**
	 * Sets the data
	 * 
	 * @param data
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * Gets the file name
	 * 
	 * @return
	 */
	public String getNOMBRE_ARCHIVO() {
		return NOMBRE_ARCHIVO;
	}

	/**
	 * Sets the file name
	 * 
	 * @return
	 */
	public String getNOMBRE_ARCHIVO_SERIALIZADO() {
		return NOMBRE_ARCHIVO_SERIALIZADO;
	}

}
