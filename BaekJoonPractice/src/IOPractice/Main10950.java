package IOPractice;
import java.util.Scanner;


class Main10950 {
	
	// 10950
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] result = new int[num];
		for(int i = 0; i< num; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			result[i] = a+b;
		}
		scanner.close();
		for (int i : result) {
			System.out.println(i);
		}
	}
}
