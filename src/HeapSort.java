import java.util.ArrayList;

/**
 * @author bpjanos, nalytle
 * 
 *         A class to implement heapsort. It is based off of pseudocode found in
 *         Introduction to Algorithms, 3rd e by Cormen.
 *
 */
public class HeapSort extends Sorter {
	static int heapSize = 0; // The size of the heap, tracked as elements are removed

	/**
	 * Reads in the input, tracks the runtime, and writes the results.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		read();
		startTime = System.nanoTime();
		heapsort(integerList);
		endTime = System.nanoTime();
		runtime = endTime - startTime;
		write(integerList);
	}

	/**
	 * Constructs the heap and runs the heapsort algorithm.
	 * 
	 * @param sort
	 *            The list to be sorted
	 */
	public static void heapsort(ArrayList<Integer> sort) {
		buildHeap(sort);
		/*
		 * This loop starts at the largest value possible so the root is selected and
		 * moved in front of the sorted elements. Since this undoes heap property,
		 * maxHeapify is called to restore it.
		 */
		for (int i = sort.size() - 1; i >= 0; i--) {
			int temp = sort.get(0);
			sort.set(0, sort.get(i));
			sort.set(i, temp);
			heapSize--;
			maxHeapify(sort, 0);
		}
	}

	/**
	 * Builds the heap out of the initial provided list.
	 * 
	 * @param sort
	 *            The list to be sorted
	 */
	public static void buildHeap(ArrayList<Integer> sort) {
		heapSize = sort.size();
		for (int i = (int) Math.floor(sort.size() / 2 - 1); i >= 0; i--) {
			maxHeapify(sort, i);
		}
	}

	/**
	 * Heapifies a subtree with root at index i of sort.
	 * 
	 * @param sort
	 *            The list to be sorted
	 * @param i
	 *            The index of the root of the subtree
	 */
	public static void maxHeapify(ArrayList<Integer> sort, int i) {
		/*
		 * The largest number is initialized as the root and the left and right indices
		 * are set.
		 */
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		/*
		 * The larger of the root, left child, and right child is set to the largest.
		 */
		if (left < heapSize && comp.compare(sort.get(left), sort.get(largest)) > 0) {
			largest = left;
		}
		if (right < heapSize && comp.compare(sort.get(right), sort.get(largest)) > 0) {
			largest = right;
		}

		/*
		 * If the largest is not the root, then the subtree must be recursively
		 * heapified.
		 */
		if (largest != i) {
			int temp = sort.get(i);
			sort.set(i, sort.get(largest));
			sort.set(largest, temp);
			maxHeapify(sort, largest);
		}
	}
}