/**
 * BubbleSort
 * @package co.edu.unbosque.util.sort
 */

package co.edu.unbosque.util.sort;

import java.util.ArrayList;

import co.edu.unbosque.model.CiclistaDTO;
/** Esta clase proporciona métodos de todos los metodos para ordenar ArrayLists de Double e Integer
* utilizando el algoritmo de ordenamiento de BubbleSort.
* 
* @author Juan Diego Triana
* @author Gabriel Ruiz 
* @author Juan Guarnizo
*/
public class BubbleSort {

	/**
	 * Sorts an ArrayList of Doubles in ascending order usesndo el algoritmo de
	 * ordenamiento de burbuja.
	 * 
	 * @param lista The ArrayList of Doubles to sort.
	 * @return The ordered ArrayList of Doubles.
	 */
	public static ArrayList<Double> bubbleSortDouble(ArrayList<Double> lista) {
		ArrayList<Double> listaSorted = new ArrayList<>(lista);

		int n = listaSorted.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (listaSorted.get(j) > listaSorted.get(j + 1)) {
					double temp = listaSorted.get(j);
					listaSorted.set(j, listaSorted.get(j + 1));
					listaSorted.set(j + 1, temp);
				}
			}
		}
		return listaSorted;
	}

	/**
	 * Sorts an ArrayList of Integers in ascending order using the bubble sort
	 * algorithm.
	 *
	 * @param list The ArrayList of Integers to sort.
	 * @return The ordered ArrayList of Integers.
	 */
	public static ArrayList<Integer> bubbleSortInt(ArrayList<Integer> lista) {
		ArrayList<Integer> listaSorted = new ArrayList<>(lista);

		int n = listaSorted.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (listaSorted.get(j) > listaSorted.get(j + 1)) {
					int temp = listaSorted.get(j);
					listaSorted.set(j, listaSorted.get(j + 1));
					listaSorted.set(j + 1, temp);
				}
			}
		}
		return listaSorted;
	}
/**
 * sort function for times
 * @param arr
 */
	public static void bubbleSortOrdenarTiempos(CiclistaDTO[] arr) {
		int n = arr.length;
		boolean swapped;
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - 1 - i; j++) {
				if (arr[j].getTiempoAcumulado() > arr[j + 1].getTiempoAcumulado()) {
					// Intercambiar los elementos
					CiclistaDTO temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			// Si no hubo intercambios, la lista ya está ordenada
			if (!swapped) {
				break;
			}
		}
	}

}