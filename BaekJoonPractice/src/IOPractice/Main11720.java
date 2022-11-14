package IOPractice;
import java.util.Scanner;

class Main11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		if(len > 100 || len < 0) {
			sc.close();
			return;
		}
		int sum = 0;
		for(String s : sc.next().split("")) {
			sum+= Integer.parseInt(s);
		}
		System.out.println(sum);
		sc.close();
	}
}
