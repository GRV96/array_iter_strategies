/**
 * This class tests whether processing a 2-dimension array is faster if the
 * outer loop keeps a reference to the subarray being processed.
 * @author Guyllaume Rousseau
 */
public class SubarrayReferenceStrategy {

	private static final int ITERATION_COUNT = 100;
	private static final int NUMBER_TO_ADD = 53;

	/**
	 * Adds a number to all elements in a 2-dimension array. The outer loop
	 * does not keep a reference to the subarrays.
	 * @param array - a 2-dimension array that contains integers
	 * @param numToAdd - added to every element in array
	 */
	private static void addToArrayNoRef(int[][] array, int numToAdd) {
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				array[i][j] += numToAdd;
			}
		}
	}

	/**
	 * Adds a number to all elements in a 2-dimension array. The outer loop
	 * keeps a reference to the subarrays.
	 * @param array - a 2-dimension array that contains integers
	 * @param numToAdd - added to every element in array
	 */
	private static void addToArrayWithRef(int[][] array, int numToAdd) {
		for(int i=0; i<array.length; i++) {
			int[] subarray = array[i];
			for(int j=0; j<subarray.length; j++) {
				subarray[j] += numToAdd;
			}
		}
	}

	public static void main(String[] args) {
		long timing = System.nanoTime();

		for(int i=1; i<=ITERATION_COUNT; i++) {
			int[][] array = {
					{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
					{11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
					{21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
					{31, 32, 33, 34, 35, 36, 37, 38, 39, 40}};
			addToArrayNoRef(array, NUMBER_TO_ADD);
		}

		System.out.println("Execution time with no references: "
				+ (System.nanoTime() - timing) + " ns");

		timing = System.nanoTime();

		for(int i=1; i<=ITERATION_COUNT; i++) {
			int[][] array = {
					{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
					{11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
					{21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
					{31, 32, 33, 34, 35, 36, 37, 38, 39, 40}};
			addToArrayWithRef(array, NUMBER_TO_ADD);
		}

		System.out.println("Execution time with references: "
				+ (System.nanoTime() - timing) + " ns");
	}
}
