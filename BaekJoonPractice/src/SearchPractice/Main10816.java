package SearchPractice;

import java.util.Arrays;
import java.util.Scanner;

class Main10816 {

	private static int lower(int m, int[] array) {
		int left = 0;
		int right = array.length;
		int mid;
		while(left < right) {
			mid = left + (right- left)/2;
			if(m <= array[mid]) {
				right = mid;
			}else {
				left = mid + 1;
			}
		}
		return left;
	}
	
	private static int upper(int m, int[] array) {
		int left = 0;
		int right = array.length;
		int mid;
		while(left < right) {
			mid = left + (right- left)/2;
			if(m < array[mid]) {
				right = mid;
			}else {
				left = mid + 1;
			}
		}
		return left;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] narray = new int[n];
		for(int i = 0; i< n; i++) {
			narray[i] = sc.nextInt();
		}
		Arrays.parallelSort(narray);
		
		
		int m = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< m; i++) {
			int tmp = sc.nextInt();
			sb.append((upper(tmp, narray) - lower(tmp, narray))).append(" ");
		}
		sc.close();
		System.out.println(sb);
	}

}
