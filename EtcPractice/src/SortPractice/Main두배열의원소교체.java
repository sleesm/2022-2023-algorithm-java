package SortPractice;

import java.util.Arrays;
import java.util.Scanner;

class Main두배열의원소교체 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] alist = new int[n];
		int[] blist = new int[n];
		
		for(int i = 0; i< n; i++) {
			alist[i] = sc.nextInt();
		}
		for(int i = 0; i< n; i++) {
			blist[i] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(alist);
		Arrays.sort(blist);
		
		for(int i = 0; i< k; i++) {
			if(alist[i] < blist[n-1-i])
				alist[i] = blist[n-1-i];
		}
		
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += alist[i];
		}
		System.out.println(sum);
	}

}
