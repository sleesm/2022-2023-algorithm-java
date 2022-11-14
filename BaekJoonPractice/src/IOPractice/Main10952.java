package IOPractice;
import java.util.ArrayList;
import java.util.Scanner;


class Main10952 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a==0 && b==0)
				break;
			list.add(a+b);
		}
		for(int i : list) {
			System.out.println(i);
		}
		sc.close();
	}
}
