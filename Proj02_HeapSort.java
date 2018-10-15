
public class Proj02_HeapSort implements Proj01_Sort{
	
	private boolean debug;
	
	public Proj02_HeapSort(boolean debug) {
		this.debug = debug;
		
	}
	/**
	 * this function uses the MaxHeap to sort an array of values
	 * @param - an array of unsorted values of type Comparable 
	 */
	public void sort(Comparable[] arr) {
		Proj02_MaxHeap heap = new Proj02_MaxHeap(false, arr);
		Comparable temp;
		for(int i = arr.length - 1; i >= 0; i--) {
			arr[i] = heap.removeMax();
		}
	
	}
	
	private void printArray(Comparable[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}

