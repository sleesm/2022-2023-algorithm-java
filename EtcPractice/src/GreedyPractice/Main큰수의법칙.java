package GreedyPractice;

import java.util.Arrays;
import java.util.Scanner;

/***
 * �׸���
 * ū ���� ��Ģ
 * 2019 ���� ������� �ڵ� �׽�Ʈ
 */
class Mainū���ǹ�Ģ {

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
