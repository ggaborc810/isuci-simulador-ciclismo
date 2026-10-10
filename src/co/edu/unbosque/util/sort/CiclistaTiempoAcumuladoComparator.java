/**
 * package where we will find classes of ordering systems
 */
package co.edu.unbosque.util.sort;

import java.util.Comparator;

import co.edu.unbosque.model.CiclistaDTO;

/**
 * Class comparator
* 
* @autor Juan Diego Triana Mejía
* @autor Juan David Guarnizo Martínez
* @autor Gabriel Alejandro Ruiz Cruz
*/
public class CiclistaTiempoAcumuladoComparator implements Comparator<CiclistaDTO> {

    /**
     * Compares two CiclistaDTO objects based on their accumulated time.
     * @param o1 The first CiclistaDTO object.
     * @param o2 The second CiclistaDTO object.
     * @return A negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     */
    @Override
    public int compare(CiclistaDTO o1, CiclistaDTO o2) {
        return Double.compare(o1.getTiempoAcumulado(), o2.getTiempoAcumulado());
    }
}
