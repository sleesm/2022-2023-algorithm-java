package DPPractice;

import java.util.Scanner;

class Main1912 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n+1];
		for(int i = 1; i<= n;i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		
		int[] d = new int[n+1];
		int result = a[1];
		for(int i = 1; i <= n; i++) {
			d[i] = Math.max(a[i], d[i-1] + a[i]);
			result = Math.max(result, d[i]);
		}
		System.out.println(result);
	}

}
