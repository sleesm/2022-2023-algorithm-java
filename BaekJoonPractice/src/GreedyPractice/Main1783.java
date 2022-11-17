package GreedyPractice;

import java.util.Scanner;

class Main1783 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.close();

		int count = 1; // n==1
		if (n == 2)
			count = Math.min((m + 1) / 2, 4);
		else if (n > 2) {
			if (m < 7)
				count = Math.min(m, 4);
			else
				count = m - 2;
		}
		System.out.println(count);
	}
}
