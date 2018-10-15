/* Test_xx.java
 *
 * Tests the student's build-max-heap code, which must build the heap using
 * the standard (bubble-down, starting at the end) algorithm.
 *
 * Author: Russell Lewis
 */



import java.io.PrintWriter;

public class Test_10_buildMaxHeap
{
	public static void main(String[] args)
	{
		// wrap System.out with a PrintWriter
		PrintWriter out = new PrintWriter(System.out);

		Comparable[] data = {53,39,-40,86};

		// just build it, and immediately dump the contents.  There's
		// no other test in this testcase.
		Proj02_MaxHeap heap = new Proj02_MaxHeap(false, data);
		heap.dump(out);

		// this line is printed to allow the grading script to
		// detect, easily, whether all of the tests completed.  Do
		// *NOT* attempt to falsify this line if your tests are
		// broken - that is a violation of the Code of Academic
		// Integrity!

		out.printf("--- TESTCASE TERMINATED ---\n");
		out.close();
	}
}

