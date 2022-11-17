package GreedyPractice;

import java.util.Scanner;

class Main2875 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		sc.close();

		int result = 0;
		while (n >= 2 && m >= 1 && n + m > k + 2) {
			n -= 2;
			m -= 1;
			result++;
		}
		System.out.println(result);
	}
}
