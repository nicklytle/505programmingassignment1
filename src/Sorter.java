import java.util.ArrayList;
import java.util.Scanner;

public abstract class Sorter {
	
	static ArrayList<Integer> integerList;
	static Scanner in;
	static int numItems;
	static double runtime = 0.0;
	static int numComparisons = 0;
	
	public abstract void sort();
	
	public static void read(){
		in = new Scanner(System.in);
		numItems = Integer.parseInt(in.nextLine());
		for(int i = 0; i < numItems; i++){
			integerList.add(in.nextInt());
		}
		in.close();
	}
	
	public static void write(){
		for(Integer g: integerList){
			System.out.println(g.toString());
		}
		System.out.println();
	}
	
}