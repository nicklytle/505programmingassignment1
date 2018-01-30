import java.util.ArrayList;
import java.util.Comparator;

public class HeapSort extends Sorter {
static int heapSize = 0;
static Comparator<Integer> comp = new Counter();

	@Override
	public void sort() {
	}
	
	public static void heapSort(ArrayList<Integer> integerList){
		startTime = System.nanoTime();
		buildHeap(integerList);
		for(int i = integerList.size()-1; i >=0; i-- ){
			heapSize--;
			Integer first = integerList.get(0);
			Integer index = integerList.get(i);
			integerList.set(0,index);
			integerList.set(i, first);
			MaxHeapify(0, integerList);
		}
		endTime = System.nanoTime();
		runtime = endTime-startTime;
	}
	
	public static void main(String[] args){
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(5);
		arr.add(4);
		arr.add(3);
		arr.add(-100);
		arr.add(8);
		arr.add(0);
		arr.add(3);
		arr.add(-8);
		// arr.add(1);
		heapSort(arr);
		// Worst case should be nlgn comparisons, which looks like it checks out
		write(arr);
	}

	
	public static void buildHeap(ArrayList<Integer> integerList){
		heapSize = integerList.size();
		int j = (int) Math.floor(integerList.size()/2);
		for(int i = (int) Math.floor(integerList.size()/2); i >= 0; i--){
			MaxHeapify(i,integerList);
		}
	}
	
	public static void MaxHeapify(int index,ArrayList<Integer> integerList){
		int li = 2*index;
		int ri = 2*index + 1;
		int switchindex = index;
		Integer left = Integer.MIN_VALUE;
		Integer right = Integer.MIN_VALUE;
		Integer inV = integerList.get(index);
		Integer max = inV;
		if(li<=heapSize-1){left = integerList.get(2*index);}
		if(ri<=heapSize-1){right = integerList.get((2*index)+1);}
		if(comp.compare(left,max)>0){
			max = left;
			switchindex = li;
		}
		if(comp.compare(right,max)>0){
			max = right;
			switchindex = ri;
		}
		if(switchindex!=index){
			integerList.set(index,max);
			integerList.set(switchindex, inV);
			MaxHeapify(switchindex,integerList);
		}

	}
}