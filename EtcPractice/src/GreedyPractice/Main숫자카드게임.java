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
