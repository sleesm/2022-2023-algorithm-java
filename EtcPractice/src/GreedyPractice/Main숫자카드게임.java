package GreedyPractice;

import java.util.Scanner;

/***
 * 그리디 
 * 숫자 카드 게임 
 * 2019 국가 교육기관 코딩 테스트
 */
class Main숫자카드게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int result = 1;
		for (int i = 0; i < n; i++) {
			int tmp = 10001;
			for (int j = 0; j < m; j++) {
				tmp = Math.min(sc.nextInt(), tmp);
			}
			result = Math.max(result, tmp);
		}
		sc.close();

		System.out.println(result);
	}
}
