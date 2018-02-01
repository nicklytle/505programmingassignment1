import java.util.ArrayList;
import java.util.Comparator;

public class InsertionSort extends Sorter {


	public static void main(String[] args) {
//		ArrayList<Integer> arr = new ArrayList<>();
//		arr.add(5);
//		arr.add(4);
//		arr.add(3);
//		arr.add(2);
//		integerList = arr;
		// arr.add(1);
		read();
		startTime = System.nanoTime();
		ArrayList<Integer> sorted = insertionSort(integerList);
		endTime = System.nanoTime();
		runtime = endTime-startTime;
		write(sorted);

}

	/**
	 * Recursively takes one element of a list at a time and sorts it
	 * 
	 * @param L
	 *            An unsorted list of Integers
	 * @return the list L in sorted order
	 */
	public static ArrayList<Integer> insertionSort(ArrayList<Integer> L) {
		/**
		 * If L is empty, our work is done. Otherwise, take the first element of the
		 * list and then insert it into a sorted list (the recursive call to
		 * insertionSort).
		 */
		if (L.size() == 0) {
			return L;
		} else {
			ArrayList<Integer> rest = new ArrayList<>(L.subList(1, L.size()));
			return insert(L.get(0), insertionSort(rest));
		}
	}

	/**
	 * Finds the proper position of an integer into a sorted list.
	 * 
	 * @param i
	 *            The Integer to place.
	 * @param l
	 *            The sorted list to place the Integer into
	 * @return The sorted list with the Integer.
	 */
	public static ArrayList<Integer> insert(Integer i, ArrayList<Integer> l) {
		ArrayList<Integer> sorted = new ArrayList<>();
		/**
		 * If the list is empty, then we can return a list with simply i. If the integer
		 * is smaller than the first element of the list, then it will be inserted in
		 * the first position in the list. If the first element of the list is smaller
		 * than the integer, then the first element of the list will take the first
		 * position of the new list and insert will be called again on the integer and
		 * the remaining list.
		 */
		if (l.size() == 0 || l.size() == 1) {
			sorted.add(i);
		} else if (comp.compare(i, l.get(0)) <= 0) {
			sorted.add(i);
			sorted.addAll(l);
		} else {
			sorted.add(l.get(0));
			ArrayList<Integer> rest = new ArrayList<>(l.subList(1, l.size()));
			sorted.addAll(insert(i, rest));
		}
		return sorted;
	}

}