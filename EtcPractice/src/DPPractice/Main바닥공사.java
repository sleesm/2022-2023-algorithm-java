package DPPractice;

import java.util.Scanner;

/**
 * ���̳��� ���α׷���
 * �ٴڰ���
 */
class Main�ٴڰ��� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int[] dp = new int[1001];
		
		dp[0]= 1;
		dp[1] = 3;
		for(int i = 2; i<n; i++) {
			dp[i] = (dp[i-1] + dp[i-2] * 2 ) % 796796; 
		}
		
		System.out.print(dp[n-1]);
	}
}
