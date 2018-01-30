import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortUtility extends Sorter {

	@Override
	public void sort() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		Comparator<Integer> comp = new Counter();
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(5);
		arr.add(4);
		arr.add(3);
		arr.add(2);
		// arr.add(1);
		Collections.sort(arr, comp);
		System.out.println(arr);
		System.out.println(Sorter.numComparisons);

	}

}