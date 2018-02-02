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
		ArrayList<Integer> test = new ArrayList<>();
		test.add(5);
		test.add(4);
		test.add(3);
		test.add(2);
		// read();
		integerList = test;
		startTime = System.nanoTime();
		mergesort(integerList, 0, integerList.size() - 1);
		endTime = System.nanoTime();
		runtime = endTime - startTime;
		write(integerList);
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
		 * If the first element of one list is less than the first element of the other
		 * list, then the smaller element is added to the sorted master list and the
		 * merge function is called on the remaining values in the list with the smaller
		 * element and the entire list containing the larger first element.
		 */
		ArrayList<Integer> rest = new ArrayList<>();
		ArrayList<Integer> l = new ArrayList<>();
		if (comp.compare(L1.get(0), L2.get(0)) > 0) {
			rest.addAll(L2.subList(1, L2.size()));
			l.add(L2.get(0));
			l.addAll(merge(L1, rest));
			return l;
		} else {
			rest.addAll(L1.subList(1, L1.size()));
			l.add(L1.get(0));
			l.addAll(merge(rest, L2));
			return l;
		}
	}

	public static void mergesort(ArrayList<Integer> sort, int left, int right) {
		if (left < right) {
			int mid = (int) Math.floor((left + right) / 2);
			mergesort(sort, left, mid);
			mergesort(sort, mid + 1, right);
			mergeIt(sort, left, mid, right);
		}
	}

	public static void mergeIt(ArrayList<Integer> sort, int left, int mid, int right) {
		int lSize = mid - left + 1;
		int rSize = right - mid;

		ArrayList<Integer> L = new ArrayList<>();
		ArrayList<Integer> R = new ArrayList<>();

		for (int i = 0; i < lSize; i++) {
			L.add(sort.get(left + i));
		}
		L.add(Integer.MAX_VALUE);
		for (int j = 0; j < rSize; j++) {
			R.add(sort.get(mid + j + 1));
		}
		R.add(Integer.MAX_VALUE);

		int i = 0, j = 0;
		for (int k = left; k <= right; k++) {
			if (comp.compare(L.get(i), R.get(j)) <= 0) {
				sort.set(k, L.get(i));
				i++;
			} else {
				sort.set(k, R.get(j));
				j++;
			}
		}
	}

}