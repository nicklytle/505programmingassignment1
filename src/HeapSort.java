import java.util.ArrayList;
import java.util.Comparator;

public class HeapSort extends Sorter {
	static int heapSize = 0;

	public static void heapSort(ArrayList<Integer> integerList) {
		buildHeap(integerList);
		for (int i = integerList.size() - 1; i >= 0; i--) {
			heapSize--;
			Integer first = integerList.get(0);
			Integer index = integerList.get(i);
			integerList.set(0, index);
			integerList.set(i, first);
			MaxHeapify(0, integerList);
		}
	}

	public static void main(String[] args) {
//		ArrayList<Integer> arr = new ArrayList<Integer>();
//		arr.add(4);
//		arr.add(3);
//		arr.add(-100);
//		arr.add(8);
//		arr.add(0);
//		arr.add(2);
//		arr.add(-8);
//		arr.add(1);
//
//		integerList = arr;
		read();
		startTime = System.nanoTime();
		heapSort(integerList);
		endTime = System.nanoTime();
		runtime = endTime - startTime;
		write(integerList);
	}

	public static void buildHeap(ArrayList<Integer> integerList) {
		heapSize = integerList.size();
		int j = (int) Math.floor(integerList.size() / 2);
		for (int i = (int) Math.floor(integerList.size() / 2); i >= 0; i--) {
			MaxHeapifybutWithoutComparisons(i, integerList);
		}
	}

	public static void MaxHeapify(int index, ArrayList<Integer> integerList) {
		int li = 2 * index;
		int ri = 2 * index + 1;
		int switchindex = index;
		Integer left = Integer.MIN_VALUE;
		Integer right = Integer.MIN_VALUE;
		Integer inV = integerList.get(index);
		Integer max = inV;
		if (li <= heapSize) {
			left = integerList.get(2 * index);
		}
		if (ri <= heapSize) {
			right = integerList.get((2 * index) + 1);
		}
		if (li <= heapSize && comp.compare(left, max) > 0) {
			max = left;
			switchindex = li;
		}
		if (ri <= heapSize && comp.compare(right, max) > 0) {
			max = right;
			switchindex = ri;
		}
		if (switchindex != index) {
			integerList.set(index, max);
			integerList.set(switchindex, inV);
			MaxHeapify(switchindex, integerList);
		}

	}

	public static void MaxHeapifybutWithoutComparisons(int index, ArrayList<Integer> integerList) {
		int li = 2 * index;
		int ri = 2 * index + 1;
		int switchindex = index;
		Integer left = Integer.MIN_VALUE;
		Integer right = Integer.MIN_VALUE;
		Integer inV = integerList.get(index);
		Integer max = inV;
		if (li <= heapSize - 1) {
			left = integerList.get(2 * index);
		}
		if (ri <= heapSize - 1) {
			right = integerList.get((2 * index) + 1);
		}
		if (left > max) {
			max = left;
			switchindex = li;
		}
		if (right > max) {
			max = right;
			switchindex = ri;
		}
		if (switchindex != index) {
			integerList.set(index, max);
			integerList.set(switchindex, inV);
			MaxHeapifybutWithoutComparisons(switchindex, integerList);
		}

	}
}