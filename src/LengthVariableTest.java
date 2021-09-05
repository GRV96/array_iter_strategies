/**
 * This class tests whether processing a 1-dimensional array is faster if a
 * variable stores the array's length.
 * @author Guyllaume Rousseau
 */
public final class LengthVariableTest {

	private static final int ITERATION_COUNT = 100000;

	/**
	 * Calculates the sum of all integers in a 1-dimensional array. The
	 * array's length is not stored in a variable.
	 * @param array - a 1-dimensional integer array
	 * @return the sum of the numbers from the given array
	 */
	private static int arraySumNoLengthVar(int[] array) {
		int sum = 0;

		for(int i=0; i<array.length; i++) {
			sum += array[i];
		}

		return sum;
	}

	/**
	 * Calculates the sum of all integers in a 1-dimensional array. A variable
	 * stores the array's length.
	 * @param array - a 1-dimensional integer array
	 * @return the sum of the numbers from the given array
	 */
	private static int arraySumWithLengthVar(int[] array) {
		int sum = 0;
		int length = array.length;

		for(int i=0; i<length; i++) {
			sum += array[i];
		}

		return sum;
	}

	public static void main(String[] args) {
		long startTime = 0;
		long endTime = 0;
		int[] testArray = IntArrays.makeRandIntArray(100, 0, 100);

		startTime = System.nanoTime();
		for(int i=0; i<ITERATION_COUNT; i++) {
			// The returned value is not important.
			arraySumNoLengthVar(testArray);
		}
		endTime = System.nanoTime();
		System.out.println("Execution time with no length variable: "
				+ (double) (endTime-startTime)/1000 + " microseconds");

		startTime = System.nanoTime();
		for(int i=0; i<ITERATION_COUNT; i++) {
			// The returned value is not important.
			arraySumWithLengthVar(testArray);
		}
		endTime = System.nanoTime();
		System.out.println("Execution time with a length variable: "
				+ (double) (endTime-startTime)/1000 + " microseconds");
	}
}
