package GreedyPractice;

import java.util.Scanner;

/**
 * �׸��� 
 * 1�� �� ������
 * 2018 E ��� �˰��� ��ȸ
 */
class Main1�̵ɶ����� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		
		int count = 0;
		while(true) {
			if(n % k == 0)
				n = n/k;
			else
				n--;
			count++;
			if(n < k)
				break;
		}
		count += (n-1);
		
		System.out.println(count);
	}
}
