package DPPractice;

import java.util.Scanner;

class Main9095 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] nums = new int[t];
		for(int i = 0; i<t; i++) {
			nums[i] = sc.nextInt();
		}
		sc.close();
		
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 4; i < 11; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		for(int i = 0; i< t; i++) {
			System.out.println(dp[nums[i]]);
		}
	}
}