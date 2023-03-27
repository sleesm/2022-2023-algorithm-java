package DPPractice;

import java.util.Scanner;

public class Main1로만들기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int[] dp = new int[n+1];
		dp[1] = 0;
		int[] list = {2, 3, 5};
		
		for(int i = 2; i<= n; i++) {
			dp[i] = dp[i-1] + 1;
			for(int j : list) {
				if(i%j == 0)
					dp[i] = Math.min(dp[i], dp[i/j] + 1);
			}
		}
		
		System.out.println(dp[n]);
		
	}
}
