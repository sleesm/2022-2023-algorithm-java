package IOPractice;
import java.util.Scanner;

class Main1924 {

	public static void main(String[] args) {
		int[] mon = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] day = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.close();
		
		if (x < 1 || x > 12 || mon[x - 1] < y)
			return;
		
		int sum = 0;
		for(int i = 0; i < x; i++) {
			if(i == x-1) {
				sum += y;
			}else {
				sum += mon[i];
			}
		}
		
		System.out.println(day[sum%7]);

	}
}
