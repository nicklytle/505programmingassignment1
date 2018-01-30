import java.util.ArrayList;
import java.util.Scanner;

public abstract class Sorter {
	
	static ArrayList<Integer> integerList;
	static Scanner in;
	static int numItems;
	static double runtime = 0.0;
	static int numComparisons = 0;
	static double startTime;
	static double endTime;

	public abstract void sort();
	
	public static void read(){
		in = new Scanner(System.in);
		numItems = Integer.parseInt(in.nextLine());
		for(int i = 0; i < numItems; i++){
			integerList.add(in.nextInt());
		}
		in.close();
	}
	
	public static void write(ArrayList<Integer> integerList){
		for(Integer g: integerList){
			System.out.println(g.toString());
		}
		System.err.println("runtime,"+((int)runtime/100));
		System.err.println("comparisons,"+numComparisons);
	}
	
}