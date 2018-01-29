import java.util.ArrayList;
import java.util.Scanner;

public abstract class Sorter {
	
	static ArrayList<Integer> integerList;
	static Scanner in;
	static int numItems;
	static 
	
	public static void main(String[] args){
		System.out.println("Hello World");
		integerList = new ArrayList<Integer>();
		read();
		write();
	}
	
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
	}
	
}