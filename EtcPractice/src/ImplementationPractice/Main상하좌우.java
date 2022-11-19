package ImplementationPractice;

import java.util.Scanner;

/**
 * 그리디 
 * 상하좌우
 */
class Main상하좌우 {
	private static int n;
	private static int x = 1;
	private static int y = 1;
	
	private static boolean check(int i) {
		if(i<1 || i>n)
			return false;
		return true;
	}
	
	private static void goTrip(String s) {
		switch (s) {
		case "L":
			if (check(y - 1))
				y--;
			break;
		case "R":
			if (check(y + 1))
				y++;
			break;
		case "U":
			if (check(x - 1))
				x--;
			break;
		case "D":
			if (check(x + 1))
				x++;
			break;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		while(sc.hasNext()) {
			goTrip(sc.next());
		}
		sc.close();
		
		System.out.println(x + " " + y);
	}

}
