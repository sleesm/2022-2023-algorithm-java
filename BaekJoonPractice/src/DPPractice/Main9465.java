package DPPractice;

import java.util.Scanner;

class Main9465 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] answer = new int[t];
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[][] nums = new int[2][n+1];
			
			for (int j = 0; j < 2; j++) {
				for (int k = 1; k <= n; k++) {
					nums[j][k] = sc.nextInt();
				}
			}
			
			int[][] d = new int[2][n+1];
			d[0][1] = nums[0][1];
			d[1][1] = nums[1][1];
			
			for (int j = 2; j <= n; j++) {
				d[0][j] = nums[0][j] + Math.max(d[1][j - 1], d[1][j - 2]);
				d[1][j] = nums[1][j] + Math.max(d[0][j - 1], d[0][j - 2]);
			}

			answer[i] = Math.max(d[0][n], d[1][n]);
		}
		sc.close();

		for (int i = 0; i < t; i++)
			System.out.println(answer[i]);
	}
}
