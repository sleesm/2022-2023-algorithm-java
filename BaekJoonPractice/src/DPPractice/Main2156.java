package DPPractice;

import java.util.Scanner;

class Main2156 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		int[] dp = new int[n+1];
		
		dp[1] = arr[1];
		if(n > 1) {
			dp[2] = arr[1] + arr[2];
		}
		
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(arr[i] + arr[i - 1] + dp[i - 3], arr[i] + dp[i - 2]));
		}
		
		System.out.println(dp[n]);
	}
}
