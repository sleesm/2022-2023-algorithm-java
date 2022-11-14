package IOPractice;
import java.util.Scanner;

class Main11721 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		for(String s : sc.next().split("")) {
			System.out.print(s);
			if(num % 10 == 9) {
				System.out.println();
			}
			num++;
		}
		sc.close();
	}
}
