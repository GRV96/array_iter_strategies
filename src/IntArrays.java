import java.lang.Math;

/**
 * The functions provided in this class allow to generate and use
 * 1-dimensional and 2-dimensional arrays of integers.
 * @author Guyllaume Rousseau
 */
public final class IntArrays {

	/**
	 * Creates a 1-dimensional array of random integers.
	 * @param size - the array's size
	 * @param minimum - the minimal value of the array's elements, inclusive
	 * @param maximum - the maximal value of the array's elements, inclusive
	 * @return a 1-dimensional array of random integers
	 */
	public static int[] makeRandIntArray(int size,
			int minimum, int maximum) {
		int[] randArray = new int[size];

		for(int i=0; i<size; i++) {
			randArray[i] = randInt(minimum, maximum);
		}

		return randArray;
	}

	/**
	 * Creates a 2-dimensional array of random integers.
	 * @param iSize - the size of index i's dimension
	 * @param jSize - the size of index j's dimension
	 * @param minimum - the minimal value of the array's elements, inclusive
	 * @param maximum - the maximal value of the array's elements, inclusive
	 * @return a 2-dimensional array of random integers
	 */
	public static int[][] make2dRandIntArray(int iSize, int jSize,
			int minimum, int maximum) {
		int[][] randArray = new int[iSize][];

		for(int i=0; i<iSize; i++) {
			randArray[i] = makeRandIntArray(jSize, minimum, maximum);
		}

		return randArray;
	}

	/**
	 * Prints the content of a 1-dimensional integer array on one line in the
	 * console.
	 * @param array - the 1-dimensional array to print
	 * @param separator - the String that will separate the array's values
	 */
	public static void printIntArrayOneLine(int[] array, String separator) {
		String line = "";
		int length = array.length;

		if(length > 0) {
			line += array[0];

			for(int i=1; i<length; i++) {
				line += separator + array[i];
			}
		}

		System.out.println(line);
	}

	/**
	 * Prints the content of a 2-dimensional integer array in the console.
	 * Index i identifies the lines; index j identifies the columns.
	 * @param array - the 2-dimensional array to print
	 * @param separator - the String that will separate the array's values on
	 * the same line
	 */
	public static void print2dIntArray(int[][] array, String separator) {
		for(int i=0; i<array.length; i++) {
			printIntArrayOneLine(array[i], separator);
		}
	}

	/**
	 * Generates a random integer within the specified bounds.
	 * @param minimum - the random integer's minimal value, inclusive
	 * @param maximum - the random integer's maximal value, inclusive
	 * @return a random integer
	 */
	private static int randInt(int minimum, int maximum) {
		return minimum +
			(int) Math.floor((maximum - minimum + 1) * Math.random());
	}
}
