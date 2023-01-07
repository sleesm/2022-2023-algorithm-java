package DPPractice;

import java.util.Scanner;

class Main11053 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i< n; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		
		int[] dp = new int[n];
		dp[0] = 1;
		
		int result = 0;
		for(int i = 0; i< n; i++) {
			dp[i] = 1;
			for(int j = 0; j< i; j++) {
				if(a[j] < a[i] && dp[j] >= dp[i])
					dp[i] = dp[j] + 1;
			}
			result = Math.max(result, dp[i]);
		}
		
		System.out.println(result);
	}
}
