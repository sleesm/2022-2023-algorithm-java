package DPPractice;

import java.util.Scanner;

class Main3067 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i< t; i++) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for(int j = 0; j<n; j++) {
				nums[j] = sc.nextInt();
			}
			int m = sc.nextInt();
			
			int[] dp = new int[m+1];
			dp[0] = 1;
			for(int j: nums) {
				for(int k = j; k<=m; k++) {
					dp[k] += dp[k-j];
				}
			}
			System.out.println(dp[m]);
		}
		sc.close();
	}
}
