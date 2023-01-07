package DPPractice;

import java.util.Scanner;

class Main11055 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i< n; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		
		int[] dp = new int[n];
		dp[0] = a[0];
		
		int result = a[0];
		for(int i = 1; i< n; i++) {
			dp[i] = a[i];
			int tmp = 0;
			for(int j = i-1; j>=0; j--) {
				if(a[i] > a[j]) {
					tmp = Math.max(tmp, dp[j]);
				}
			}
			dp[i] += tmp;
			result = Math.max(dp[i], result);
		}
		
		System.out.println(result);
	}

}
