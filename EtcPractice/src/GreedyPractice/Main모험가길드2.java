package GreedyPractice;

import java.util.Arrays;
import java.util.Scanner;

class Main모험가길드2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] list = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = sc.nextInt();
		}
		sc.close();

		Arrays.parallelSort(list);
		
		int count = 0;
		int result = 0;
		for(int i : list) {
			count++;
			if(count >= i) {
				result++;
				count = 0;
			}
		}
		System.out.println(result);
	}

}
