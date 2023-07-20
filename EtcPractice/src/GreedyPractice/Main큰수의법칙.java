package GreedyPractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/***
 * 그리디
 * 큰 수의 법칙
 * 2019 국가 교육기관 코딩 테스트
 */
class Main큰수의법칙 {

	/**
	 * change int array to Integer array
	 * sort list with reverse order
	 */
	static int anotherSolution(int n, int m, int k, int[] list) {
		Integer[] tmp = Arrays.stream(list).boxed().toArray(Integer[]::new);
		Arrays.sort(tmp, Collections.reverseOrder());

		int first = tmp[0];
		int second = tmp[1];

		int answer = first * (m - (m / (k + 1))) + second * (m / (k + 1));
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[] list = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(list);
		int first = list[n - 1];
		int second = list[n - 2];

		int sum = 0;
		sum += (int) (second * (m / (k + 1)));
		sum += (int) (first * (m - m / (k + 1)));

		System.out.println(sum);
	}
}
