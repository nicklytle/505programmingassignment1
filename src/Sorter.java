import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

//Abstract Class for Sorting Algorithms. Each 
public abstract class Sorter {
	
	static ArrayList<Integer> integerList;
	static Scanner in;
	static int numItems;
	static double runtime = 0.0;
	static int numComparisons = 0;
	static double startTime;
	static double endTime;
	static Comparator<Integer> comp = new Counter();

	
	public static void read(){
		in = new Scanner(System.in); // read in from Standard Input
		integerList = new ArrayList<Integer>(); //instantiate list
		numItems = Integer.parseInt(in.nextLine());//read number of items
		for(int i = 0; i < numItems; i++){ //for number of items
			integerList.add(in.nextInt());//add item to list
		}
		in.close();
	}
	
	public static void write(ArrayList<Integer> integerList){
		for(Integer g: integerList){
			System.out.println(g.toString());
		}
		//Print to Standard Error the runtime (expressed in milliseconds) and the number of comparisons
		System.err.println("runtime = "+((int)runtime/1000000));
		System.err.println("comparisons = "+numComparisons);
	}
	
}