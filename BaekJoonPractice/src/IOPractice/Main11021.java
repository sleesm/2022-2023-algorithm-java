package IOPractice;
import java.util.Scanner;

class Main11021 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] result = new int[num];
		for (int i = 0; i < num; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			result[i] = a + b;
		}
		scanner.close();
		for (int j = 0; j < num; j++) {
			System.out.println("Case #" + (j+1) + ": " + result[j]);
		}
	}
}
