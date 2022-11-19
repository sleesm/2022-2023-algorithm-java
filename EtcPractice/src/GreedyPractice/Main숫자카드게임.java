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
		int[] mins = new int[n];

		for (int i = 0; i < n; i++) {
			int tmp = 101;
			for (int j = 0; j < m; j++) {
				card[i][j] = sc.nextInt();
				tmp = Math.min(card[i][j], tmp);
			}
			mins[i] = tmp;
		}
		sc.close();

		int result = 0;
		for (int i : mins)
			result = Math.max(i, result);

		System.out.println(result);
	}
}
