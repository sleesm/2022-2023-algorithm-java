package DFSBFSPractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main음료수얼려먹기2 {

	private static boolean check(int x, int y, int n, int m) {
		if (x < 0 || y < 0 || x >= n || y >= m) {
			return false;
		}
		return true;
	}

	private static boolean bfs(int x, int y, int[][] map, boolean[][] visited) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		int[][] list = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		boolean check = false;

		while (!q.isEmpty()) {
			int[] nxy = q.poll();
			if (map[nxy[0]][nxy[1]] == 0 && !visited[nxy[0]][nxy[1]]) {
				visited[nxy[0]][nxy[1]] = true;
				check = true;
				for (int[] dxy : list) {
					int nx = nxy[0] + dxy[0];
					int ny = nxy[1] + dxy[1];
					if (check(nx, ny, map.length, map[0].length)) {
						q.offer(new int[] { nx, ny });
					}
				}
			}
		}
		return check;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		boolean[][] visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (bfs(i, j, map, visited))
					count++;
			}
		}

		System.out.println(count);
	}

}
