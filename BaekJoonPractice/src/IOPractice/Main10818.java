package IOPractice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main10818 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i <n; i++) {
			list.add(sc.nextInt());
		}
		sc.close();
		
		System.out.println(Collections.min(list) +" " + Collections.max(list));
	}
}
