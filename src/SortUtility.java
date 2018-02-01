import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortUtility extends Sorter {



	public static void main(String[] args) {
//		ArrayList<Integer> arr = new ArrayList<>();
//		arr.add(5);
//		arr.add(4);
//		arr.add(3);
//		arr.add(2);
//		// arr.add(1);
//		integerList = arr;
		read();
		startTime = System.nanoTime();
		Collections.sort(integerList, comp);
		endTime = System.nanoTime();
		runtime = endTime-startTime;
		write(integerList);

	}

}