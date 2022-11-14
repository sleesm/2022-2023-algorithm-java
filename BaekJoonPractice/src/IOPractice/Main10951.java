package IOPractice;
import java.util.ArrayList;
import java.util.Scanner;

class Main10951 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(sc.hasNextInt()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list.add(a+b);
		}
		for(int i : list) {
			System.out.println(i);
		}
		sc.close();
	}
}
