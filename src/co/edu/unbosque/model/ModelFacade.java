/**
 * model package, is where the attributes are found for the creation of objects, whether cyclists, masseuses or other types of users within the application.
 */

package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.CiclistaDAO;
import co.edu.unbosque.model.persistence.ClasicoManoDAO;
import co.edu.unbosque.model.persistence.ContraRelojDAO;
import co.edu.unbosque.model.persistence.DirectorDeportivoDAO;
import co.edu.unbosque.model.persistence.EmbaladorDAO;
import co.edu.unbosque.model.persistence.EscaladorDAO;
import co.edu.unbosque.model.persistence.EscuadraDAO;
import co.edu.unbosque.model.persistence.GregarioDAO;
import co.edu.unbosque.model.persistence.MasajistaDAO;
import co.edu.unbosque.model.persistence.RodadorDAO;
import co.edu.unbosque.model.persistence.UsuarioDAO;

/**
 * class where DAO classes are instantiated to access their functions in a more
 * organized way
 *
 * @author Juan Diego Triana Mejía
 * @author Juan David Guarnizo Martínez
 * @author Gabriel Alejandro Ruiz Cruz
 */
public class ModelFacade {

	/**
	 * Data Access Object for managing user-related operations.
	 */
	private UsuarioDAO usuarioDAO;

	/**
	 * Data Transfer Object for the currently logged-in user.
	 */
	private UsuarioDTO usuarioLoginDTO;

	/**
	 * List of cyclists.
	 */
	private ArrayList<CiclistaDTO> ciclistas;

	/**
	 * List of masseurs.
	 */
	private ArrayList<MasajistaDTO> masajistas;

	/**
	 * List of "Clasico Mano" cyclists.
	 */
	private ArrayList<ClasicoManoDTO> clasicoManos;

	/**
	 * Data Transfer Object for a user.
	 */
	private UsuarioDTO usuarioDTO;

	/**
	 * Data Transfer Object for a cyclist.
	 */
	private CiclistaDTO ciclistaDTO;

	/**
	 * Data Access Object for managing cyclist-related operations.
	 */
	private CiclistaDAO ciclistaDAO;

	/**
	 * Data Transfer Object for a "Clasico Mano" cyclist.
	 */
	private ClasicoManoDTO clasicoDTO;

	/**
	 * Data Access Object for managing "Clasico Mano" cyclist-related operations.
	 */
	private ClasicoManoDAO clasicoDAO;

	/**
	 * Data Transfer Object for a time trial cyclist.
	 */
	private ContraRelojDTO contrarelojDTO;

	/**
	 * Data Access Object for managing time trial cyclist-related operations.
	 */
	private ContraRelojDAO contrarelojDAO;

	/**
	 * Data Transfer Object for a sports director.
	 */
	private DirectorDeportivoDTO directorDTO;

	/**
	 * Data Access Object for managing sports director-related operations.
	 */
	private DirectorDeportivoDAO directorDAO;

	/**
	 * Data Transfer Object for a sprinter cyclist.
	 */
	private EmbaladorDTO embaladorDTO;

	/**
	 * Data Access Object for managing sprinter cyclist-related operations.
	 */
	private EmbaladorDAO embaladorDAO;

	/**
	 * Data Transfer Object for a climber cyclist.
	 */
	private EscaladorDTO escaladorDTO;

	/**
	 * Data Access Object for managing climber cyclist-related operations.
	 */
	private EscaladorDAO escaladorDAO;

	/**
	 * Data Transfer Object for a team.
	 */
	private EscuadraDTO escuadraDTO;

	/**
	 * Data Access Object for managing team-related operations.
	 */
	private EscuadraDAO escuadraDAO;

	/**
	 * Data Transfer Object for a gregario (domestique) cyclist.
	 */
	private GregarioDTO gregarioDTO;

	/**
	 * Data Access Object for managing gregario cyclist-related operations.
	 */
	private GregarioDAO gregarioDAO;

	/**
	 * Data Transfer Object for a masseur.
	 */
	private MasajistaDTO masajistaDTO;

	/**
	 * Data Access Object for managing masseur-related operations.
	 */
	private MasajistaDAO masajistaDAO;

	/**
	 * Data Transfer Object for a "Rodador" cyclist.
	 */
	private RodadorDTO rodadorDTO;

	/**
	 * Data Access Object for managing "Rodador" cyclist-related operations.
	 */
	private RodadorDAO rodadorDAO;

	public ModelFacade() {

		usuarioDAO = new UsuarioDAO();
		usuarioLoginDTO = new UsuarioDTO();

		ciclistaDAO = new CiclistaDAO(usuarioDAO.getListaUsuarios());
		ciclistas = ciclistaDAO.LlenarListaCiclistas(usuarioDAO.getListaUsuarios());
		escuadraDTO = new EscuadraDTO();
		escuadraDAO = new EscuadraDAO();

		masajistaDAO = new MasajistaDAO(usuarioDAO.getListaUsuarios());
		masajistas = masajistaDAO.LlenarListaMasajistas(usuarioDAO.getListaUsuarios());

		clasicoDAO = new ClasicoManoDAO(usuarioDAO.getListaUsuarios());
		clasicoManos = clasicoDAO.LlenarListaClasicoManos(usuarioDAO.getListaUsuarios());

		// ciclistaDAO = new CiclistaDAO(ciclistaDAO.getListaCiclistas());

//		ciclistaDTO = new CiclistaDTO();
//		ciclistaDAO = new CiclistaDAO(ciclistaDAO.getListaCiclistas());

//		clasicoDTO = new ClasicoManoDTO();
//		clasicoDAO = new ClasicoManoDAO(clasicoDAO.getListaClasicoManos());

//		contrarelojDTO = new ContraRelojDTO();
//		contrarelojDAO = new ContraRelojDAO(contrarelojDAO.getListaContrarelojistas());

//		directorDTO = new DirectorDeportivoDTO();
//		directorDAO = new DirectorDeportivoDAO(directorDAO.getListaDirectoresDeportivos());

//		escaladorDTO = new EscaladorDTO();
//		escaladorDAO = new EscaladorDAO(escaladorDAO.getListaEscaladores());

//		escuadraDTO = new EscuadraDTO();

//		gregarioDTO = new GregarioDTO();
//		gregarioDAO = new GregarioDAO(gregarioDAO.getListaGregarios());

//		masajistaDTO = new MasajistaDTO();
//		masajistaDAO = new MasajistaDAO(masajistaDAO.getListaMajistas());

//		rodadorDTO = new RodadorDTO();
		// rodadorDAO = new RodadorDAO(rodadorDAO.getListaRodador());
	}

	/**
	 * Returns the Data Access Object for managing user-related operations.
	 * 
	 * @return the usuarioDAO
	 */
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	/**
	 * Sets the Data Access Object for managing user-related operations.
	 * 
	 * @param usuarioDAO the usuarioDAO to set
	 */
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	/**
	 * Returns the Data Transfer Object for a user.
	 * 
	 * @return the usuarioDTO
	 */
	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	/**
	 * Sets the Data Transfer Object for a user.
	 * 
	 * @param usuarioDTO the usuarioDTO to set
	 */
	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	/**
	 * Returns the Data Transfer Object for a cyclist.
	 * 
	 * @return the ciclistaDTO
	 */
	public CiclistaDTO getCiclistaDTO() {
		return ciclistaDTO;
	}

	/**
	 * Sets the Data Transfer Object for a cyclist.
	 * 
	 * @param ciclistaDTO the ciclistaDTO to set
	 */
	public void setCiclistaDTO(CiclistaDTO ciclistaDTO) {
		this.ciclistaDTO = ciclistaDTO;
	}

	/**
	 * Returns the Data Access Object for managing cyclist-related operations.
	 * 
	 * @return the ciclistaDAO
	 */
	public CiclistaDAO getCiclistaDAO() {
		return ciclistaDAO;
	}

	/**
	 * Sets the Data Access Object for managing cyclist-related operations.
	 * 
	 * @param ciclistaDAO the ciclistaDAO to set
	 */
	public void setCiclistaDAO(CiclistaDAO ciclistaDAO) {
		this.ciclistaDAO = ciclistaDAO;
	}

	/**
	 * Returns the Data Transfer Object for the currently logged-in user.
	 * 
	 * @return the usuarioLoginDTO
	 */
	public UsuarioDTO getUsuarioLoginDTO() {
		return usuarioLoginDTO;
	}

	/**
	 * Sets the Data Transfer Object for the currently logged-in user.
	 * 
	 * @param usuarioLoginDTO the usuarioLoginDTO to set
	 */
	public void setUsuarioLoginDTO(UsuarioDTO usuarioLoginDTO) {
		this.usuarioLoginDTO = usuarioLoginDTO;
	}

	/**
	 * Returns the Data Transfer Object for a team.
	 * 
	 * @return the escuadraDTO
	 */
	public EscuadraDTO getEscuadraDTO() {
		return escuadraDTO;
	}

	/**
	 * Sets the Data Transfer Object for a team.
	 * 
	 * @param escuadraDTO the escuadraDTO to set
	 */
	public void setEscuadraDTO(EscuadraDTO escuadraDTO) {
		this.escuadraDTO = escuadraDTO;
	}

	/**
	 * Returns the Data Access Object for managing team-related operations.
	 * 
	 * @return the escuadraDAO
	 */
	public EscuadraDAO getEscuadraDAO() {
		return escuadraDAO;
	}

	/**
	 * Sets the Data Access Object for managing team-related operations.
	 * 
	 * @param escuadraDAO the escuadraDAO to set
	 */
	public void setEscuadraDAO(EscuadraDAO escuadraDAO) {
		this.escuadraDAO = escuadraDAO;
	}

	/**
	 * Returns the list of masseurs.
	 * 
	 * @return the masajistas
	 */
	public ArrayList<MasajistaDTO> getMasajistas() {
		return masajistas;
	}

	/**
	 * Sets the list of masseurs.
	 * 
	 * @param masajistas the masajistas to set
	 */
	public void setMasajistas(ArrayList<MasajistaDTO> masajistas) {
		this.masajistas = masajistas;
	}

	/**
	 * Returns the Data Transfer Object for a masseur.
	 * 
	 * @return the masajistaDTO
	 */
	public MasajistaDTO getMasajistaDTO() {
		return masajistaDTO;
	}

	/**
	 * Sets the Data Transfer Object for a masseur.
	 * 
	 * @param masajistaDTO the masajistaDTO to set
	 */
	public void setMasajistaDTO(MasajistaDTO masajistaDTO) {
		this.masajistaDTO = masajistaDTO;
	}

	/**
	 * Returns the Data Access Object for managing masseur-related operations.
	 * 
	 * @return the masajistaDAO
	 */
	public MasajistaDAO getMasajistaDAO() {
		return masajistaDAO;
	}

	/**
	 * Sets the Data Access Object for managing masseur-related operations.
	 * 
	 * @param masajistaDAO the masajistaDAO to set
	 */
	public void setMasajistaDAO(MasajistaDAO masajistaDAO) {
		this.masajistaDAO = masajistaDAO;
	}

	/**
	 * Returns the list of "Clasico Mano" cyclists.
	 * 
	 * @return the clasicoManos
	 */
	public ArrayList<ClasicoManoDTO> getClasicoManos() {
		return clasicoManos;
	}

	/**
	 * Sets the list of "Clasico Mano" cyclists.
	 * 
	 * @param clasicoManos the clasicoManos to set
	 */
	public void setClasicoManos(ArrayList<ClasicoManoDTO> clasicoManos) {
		this.clasicoManos = clasicoManos;
	}

	/**
	 * Returns the Data Transfer Object for a "Clasico Mano" cyclist.
	 * 
	 * @return the clasicoDTO
	 */
	public ClasicoManoDTO getClasicoDTO() {
		return clasicoDTO;
	}

	/**
	 * Sets the Data Transfer Object for a "Clasico Mano" cyclist.
	 * 
	 * @param clasicoDTO the clasicoDTO to set
	 */
	public void setClasicoDTO(ClasicoManoDTO clasicoDTO) {
		this.clasicoDTO = clasicoDTO;
	}

	/**
	 * Returns the Data Access Object for managing "Clasico Mano" cyclist-related
	 * operations.
	 * 
	 * @return the clasicoDAO
	 */
	public ClasicoManoDAO getClasicoDAO() {
		return clasicoDAO;
	}

	/**
	 * Sets the Data Access Object for managing "Clasico Mano" cyclist-related
	 * operations.
	 * 
	 * @param clasicoDAO the clasicoDAO to set
	 */
	public void setClasicoDAO(ClasicoManoDAO clasicoDAO) {
		this.clasicoDAO = clasicoDAO;
	}

	/**
	 * Returns the list of cyclists.
	 * 
	 * @return the ciclistas
	 */
	public ArrayList<CiclistaDTO> getCiclistas() {
		ciclistas = ciclistaDAO.LlenarListaCiclistas(usuarioDAO.getListaUsuarios());
		return ciclistas;
	}

	/**
	 * Sets the list of cyclists.
	 * 
	 * @param ciclistas the ciclistas to set
	 */
	public void setCiclistas(ArrayList<CiclistaDTO> ciclistas) {
		this.ciclistas = ciclistas;
	}

}
