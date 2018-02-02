import java.util.ArrayList;

/**
 * @author bpjanos, nalytle
 * 
 *         A class to implement mergesort. It is based off of pseudocode found
 *         in the CSC 505 class notes.
 *
 */
public class MergeSort extends Sorter {

	/**
	 * Reads in the input, tracks the runtime, and writes the results.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		read();
		startTime = System.nanoTime();
		ArrayList<Integer> a = mergeSort(integerList);
		endTime = System.nanoTime();
		runtime = endTime - startTime;
		write(a);
	}

	/**
	 * Uses a recursive merge sort to sort a list of integers.
	 * 
	 * @param L
	 *            An ArrayList of integers
	 * @return An ArrayList of the integers from L in sorted order
	 */
	public static ArrayList<Integer> mergeSort(ArrayList<Integer> L) {
		/*
		 * If the list is empty or contains only one element, our job is done. If the
		 * list contains more than one element, we continuously divide the list in half
		 * until they consist of one or no elements and merge them together in sorted
		 * order.
		 */
		if (L.size() == 0 || L.size() == 1) {
			return L;
		} else {
			ArrayList<Integer> firstHalf = new ArrayList<>(L.subList(0, L.size() / 2));
			ArrayList<Integer> secondHalf = new ArrayList<>(L.subList(L.size() / 2, L.size()));
			return merge(mergeSort(firstHalf), mergeSort(secondHalf));
		}
	}

	/**
	 * Merges two sorted lists together in sorted order.
	 * 
	 * @param L1
	 *            A sorted list of integers to be merged.
	 * @param L2
	 *            A sorted list of integers to be merged.
	 * @return A sorted list containing the values of L1 and L2.
	 */
	public static ArrayList<Integer> merge(ArrayList<Integer> L1, ArrayList<Integer> L2) {
		// If one of the lists are empty, we only need to return the other list.
		if (L1.size() == 0) {
			return L2;
		} else if (L2.size() == 0) {
			return L1;
		}

		/*
		 * While there are still elements left in both lists: If the first element of
		 * one list is less than the first element of the other list, then the smaller
		 * element is added to the sorted master list and removed from its split list.
		 */
		ArrayList<Integer> rest = new ArrayList<>();
		ArrayList<Integer> l = new ArrayList<>();
		while (L1.size() > 0 && L2.size() > 0) {
			if (comp.compare(L1.get(0), L2.get(0)) <= 0) {
				l.add(L1.remove(0));
			} else {
				l.add(L2.remove(0));
			}
		}
		/*
		 * If one list is empty, we append the contents of the other list.
		 */
		while (!L1.isEmpty()) {
			l.add(L1.remove(0));
		}

		while (!L2.isEmpty()) {
			l.add(L2.remove(0));
		}

		return l;

	}

}