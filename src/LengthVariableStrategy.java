
public final class LengthVariableStrategy {

	private static final int ITERATION_COUNT = 1000;

	private static int arraySumNoLengthVar(int[] array) {
		int sum = 0;

		for(int i=0; i<array.length; i++) {
			sum += array[i];
		}

		return sum;
	}

	private static int arraySumWithLengthVar(int[] array) {
		int sum = 0;
		int length = array.length;

		for(int i=0; i<length; i++) {
			sum += array[i];
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] testArray = IntArrays.makeRandIntArray(100, 0, 100);

		long startTime = System.nanoTime();
		for(int i=0; i<ITERATION_COUNT; i++) {
			arraySumNoLengthVar(testArray);
		}
		long endTime = System.nanoTime();
		System.out.println("Execution time with no length variable: "
				+ (double) (endTime-startTime)/1000 + " microseconds");

		startTime = System.nanoTime();
		for(int i=0; i<ITERATION_COUNT; i++) {
			arraySumWithLengthVar(testArray);
		}
		endTime = System.nanoTime();
		System.out.println("Execution time with a length variable: "
				+ (double) (endTime-startTime)/1000 + " microseconds");
	}
}
