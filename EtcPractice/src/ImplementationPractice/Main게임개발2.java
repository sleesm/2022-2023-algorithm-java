package ImplementationPractice;

import java.util.Scanner;

class Main게임개발2 {

	static int[][] map;
	static boolean[][] visited;

	static boolean check(int x, int y, int n, int m) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		if(!visited[x][y]) {
			visited[x][y] = true;
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		map = new int[n][m];
		visited = new boolean[n][m];

		int x = sc.nextInt();
		int y = sc.nextInt();
		int d = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		sc.close();

		int[][] dxy = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int count = 1;
		int dcount = 0;

		visited[x][y] = true;
		
		while (true) {
			if (d == 0)
				d = 3;
			else
				d--;
			
			int nx = x + dxy[d][0];
			int ny = y + dxy[d][1];
			
			dcount++;
			if (check(nx, ny, n, m) && map[nx][ny] == 0) {
				x = nx;
				y = ny;
				dcount = 0;
				count++;
			}
			
			if(dcount == 4) {
				nx = x - dxy[d][0];
				ny = y - dxy[d][1];
				if (map[nx][ny] == 0) {
					x = nx;
					y = ny;
					dcount = 0;
				} else {
					break;
				}

			}
		}
		
		System.out.println(count);
	}

}
