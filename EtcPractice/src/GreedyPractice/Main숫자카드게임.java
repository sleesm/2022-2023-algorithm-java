package GreedyPractice;

import java.util.Scanner;

/***
 * �׸��� 
 * ���� ī�� ���� 
 * 2019 ���� ������� �ڵ� �׽�Ʈ
 */
class Main����ī����� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] card = new int[n][m];

		int result = 1;
		for (int i = 0; i < n; i++) {
			int tmp = 10001;
			for (int j = 0; j < m; j++) {
				card[i][j] = sc.nextInt();
				tmp = Math.min(card[i][j], tmp);
			}
			result = Math.max(result, tmp);
		}
		sc.close();

		System.out.println(result);
	}
}
