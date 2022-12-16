package ImplementationPractice;

import java.util.Scanner;

/***
 * 달팽이
 */
class Main1913 {

	private static int[][] map;

	private static void create(int n) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		int currentX = n / 2;
		int currentY = n / 2;

		int count = 0;
		int max = 1;
		int change = 0;
		int limit = 0;

		for (int i = 1; i <= n * n; i++) {
			map[currentX][currentY] = i;

			currentX += dx[change % 4];
			currentY += dy[change % 4];
			count++;

			if (count == max) {
				count = 0;
				change++;
				limit++;
			}

			if (limit == 2) {
				max++;
				limit = 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		sc.close();
		map = new int[n][n];

		create(n);

		// 시간초과 방지
        StringBuilder sb = new StringBuilder();
        
		int[] result = new int[2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(map[i][j] + " ");
				if (map[i][j] == x) {
					result[0] = i + 1;
					result[1] = j + 1;
				}
			}
			sb.append("\n");
		}
		sb.append(result[0] + " " + result[1]);
		System.out.print(sb);
	}
}
