package GreedyPractice;

import java.util.Arrays;
import java.util.Scanner;

class Main11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
		}
		sc.close();

		Arrays.sort(p);
		int[] sum = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++)
				sum[i] += p[j];
		}

		int result = 0;
		for (int i : sum) {
			result += i;
		}

		System.out.print(result);
	}
}