/**
 * package to store classes that handle application exceptions
 */
package co.edu.unbosque.util.exceptions;
/**
 * Class where the exception of mistyping the name can be handled.
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class InvalidNameExceptionS extends Exception {

	/**
	 * Function that will return a text message for name exceptions.
	 */
	public InvalidNameExceptionS() {
		super("Some character cannot have numbers");

	}
	

}
