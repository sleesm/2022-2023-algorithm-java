package SortPractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main�������Ʒ��� {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer[] list = new Integer[n];
		for(int i = 0; i<n; i++) {
			list[i] = sc.nextInt();
		}
		sc.close();
		
		//int[] �� reversOrder() ��� �Ұ�
		Arrays.sort(list, Collections.reverseOrder());
		
		for(int i : list) {
			System.out.println(i);
		}
	}

}
