package SortPractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main위에서아래로 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer[] list = new Integer[n];
		for(int i = 0; i<n; i++) {
			list[i] = sc.nextInt();
		}
		sc.close();
		
		//int[] 는 reversOrder() 사용 불가
		Arrays.sort(list, Collections.reverseOrder());
		
		for(int i : list) {
			System.out.println(i);
		}
	}

}
