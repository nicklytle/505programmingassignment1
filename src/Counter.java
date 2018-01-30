import java.util.ArrayList;
import java.util.Comparator;

public class Counter implements Comparator<Integer>{
	@Override
	public int compare(Integer num1, Integer num2) {
		Sorter.numComparisons++;
		if(num1 < num2) {
			return -1;
		}
		if(num1 > num2) {
			return 1;
		}
		return 0;
	}
}
