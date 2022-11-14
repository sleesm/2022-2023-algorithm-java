package IOPractice;
import java.util.Scanner;

class Main11022 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[][] result = new int[3][num];
		for (int i = 0; i < num; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			result[0][i] = a;
			result[1][i] = b;
			result[2][i] = a + b;
		}
		scanner.close();
		for (int j = 0; j < num; j++) {
			System.out.println("Case #" + (j + 1) + ": " + result[0][j] +" + "+ result[1][j] + " = " + result[2][j]);
		}
	}
}
