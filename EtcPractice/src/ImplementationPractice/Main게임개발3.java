package ImplementationPractice;

import java.util.Scanner;

class Main게임개발3 {
	static int[][] dxy = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int d = sc.nextInt();

		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		sc.close();

		boolean[][] visited = new boolean[n][m];
		int nd = d;
		int cnt = 1;
		while (true) {
			nd = d + 1;

			for (int i = 0; i < 3; i++) {
				int nx = x + dxy[nd % 4][0];
				int ny = y + dxy[nd % 4][1];

				if (map[nx][ny] == 0 && !visited[nx][ny]) {
					x = nx;
					y = ny;
					visited[nx][ny] = true;
					cnt++;
					break;
				}

				nd++;
			}

			if (nd - 4 == d) {
				int nx = x - dxy[nd % 4][0];
				int ny = y - dxy[nd % 4][1];

				if (map[nx][ny] == 1)
					break;
				cnt++;
				d = nd;
			}
		}

		System.out.println(cnt);
	}
}
