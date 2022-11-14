package IOPractice;
import java.util.ArrayList;
import java.util.Scanner;

class Main10953 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		for(int i = 0; i< num; i++) {
			String str = sc.next();
			int sum = 0;
			for(String s : str.split(",")) {
				sum += Integer.parseInt(s); 
			}
			list.add(sum);
		}
		for(int i : list) {
			System.out.println(i);
		}
		sc.close();
	}
}
