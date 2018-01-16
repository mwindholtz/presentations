package banker;
public class Print {

	public static void printMatrixWithLabel(
		String label,
		int[][] matrix) {
		System.out.println(label);
		System.out.println("    A B C D E F G H");
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("P" + (i + 1) + ": ");
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void printVectorWithLabel(
		String label,
		int[] vector) {
		System.out.println(label);
		System.out.print("    ");
		for (int i = 0; i < vector.length; i++) {
			System.out.print(vector[i] + " ");
		}
		System.out.println();
		System.out.println();
	}

	public static void printState() {
		printMatrixWithLabel("Claimed", Banker.claim);
		printMatrixWithLabel("Assigned", Banker.assign);
		printVectorWithLabel("Available", Banker.available);
	}
}
