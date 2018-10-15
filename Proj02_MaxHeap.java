
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Proj02_MaxHeap {
	
	private boolean debug;
	private Comparable[] arr;
	private int size;
	public Proj02_MaxHeap(boolean debug) {
		this.debug = debug;
		this.arr = new Comparable[4];
	}
	
	public Proj02_MaxHeap(boolean debug,Comparable[] arr) {
		this.arr = arr;
		this.debug = debug;
		buildHeap(arr);
	}
	
	/**
	 * 
	 * @param arr
	 */
	public void buildHeap(Comparable[] arr) {
		for(int i = 0; i < arr.length; i++) {
			insert(arr[i]);
		}
	}
	
	/**
	 */
	public Comparable[] getHeap() {
		return this.arr;
	}
	
	
	 /** inserts a new value into the heap 
	 * if the array is full, the code re-allocates
	 * the array and expands it by 2
	 * @param obj - takes a Comparable obj to be inserted 
	 * @throws IOException 
	 */
	public void insert(Comparable obj) {
		//resizes array 
		if(size >= arr.length) {
			Comparable[] newArr = new Comparable[size];
			Comparable[] result = new Comparable[size*2];
			System.arraycopy(arr, 0, result, 0, size);
			System.arraycopy(newArr, 0, result, size, size);
			arr = result;
 		}
		arr[size++] = obj;
		try{bubbleUp(size - 1);}
		catch(IOException io) {
			System.out.println("IO Exception");
		}
	}
	/**
	 * ensures that the element added is in the right place
	 * @param index - the index of the element to be added
	 * @throws IOException 
	 */
	private void bubbleUp(int index) throws IOException {
		if(debug) {
			File file = new File("insert" + arr[index] + ".dot");
			FileWriter writer = new FileWriter(file);
			debug(writer);
			writer.close();
		}
		Comparable temp = arr[index];
		while(index > 0 && temp.compareTo(arr[(index - 1)/2]) > 0) {
			  arr[index] = arr[(index - 1)/2];
	          index = (index - 1)/2;
		}
		arr[index] = temp;
	}
	
	/**
	 * removes the maximum value from the heap
	 * @return the max value, stored in a Comparable obj
	 * check isempty 
	 */
	public Comparable removeMax() {
		Comparable max = arr[0];
        arr[0] = arr[size - 1];
        size--;
		try{ bubbleDown(0);}
		catch(IOException io) {
			System.out.println("IO Exception");
		}
       
		return max;
	}
	
	/**
	 * 
	 * @param index
	 * @throws IOException 
	 */
	private void bubbleDown(int index) throws IOException {
		if(debug) {
			File file = new File("remove" + size + ".dot");
			FileWriter writer = new FileWriter(file);
			debug(writer);
			writer.close();
		}
		 int child;
	     Comparable temp = arr[index];
	     while(2*index + 1 < size){
	         child = maxChild(index);
	         if(temp.compareTo(arr[child]) < 0){
	              arr[index] = arr[child];
	         }else
	              break;
	              
	         index = child;
	     }
	     arr[index] = temp;
	}
	/**
	 * 
	 * @return the index of the larger child 
	 */
	private int maxChild(int i ) {
		int child1 = 2*i + 1;
		int child2 = 2*i + 2;
		if(arr[child1].compareTo(arr[child2]) > 0) {
			return child1;
		}
		else {
			return child2;
		}

	}
	/**
	 * prints out the current contents of the heap
	 * if there are no elements in the heap, a 
	 * blank line will be printed
	 * otherwise, elements will be printed on a single line
	 * with a space in between 
	 * @param pw
	 */
	public void dump(PrintWriter pw) {
		if(size == 0) {
			pw.println();
		}
		else {
			pw.print(arr[0]);
			for(int i = 1; i < size; i++) {
				pw.print(" " + arr[i] );
			}
			pw.println();
		}
	}
	
	private void debug(FileWriter writer) throws IOException{
		writer.write("digraph{\n");
		for(int i = 0; i < arr.length; i++) {
			writer.write("\t" + arr[i] + ";\n");
		}
		for(int i = 0; 2*i + 2 < arr.length; i++) {
			writer.write("\t" +arr[i] + "->" + arr[2*i + 1] + ";\n");
			writer.write( "\t" +arr[i] + "->" + arr[2*i + 2] + ";\n");
		}
		writer.write("}\n");
		
	}
}

