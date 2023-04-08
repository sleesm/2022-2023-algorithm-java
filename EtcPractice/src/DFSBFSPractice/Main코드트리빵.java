package DFSBFSPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main코드트리빵 {

	static int n;
	static int m;
	static int[][] map;
	static int[][] dest;
	static int[][] player;

	static int[][] dir = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

	private static int[][] bfs(int[] start) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		int[][] dist = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++)
				dist[i][j] = Integer.MAX_VALUE;
		}
		dist[start[0]][start[1]] = 0;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dir[i][0];
				int ny = now[1] + dir[i][1];

				if (nx <= 0 || nx > n || ny <= 0 || ny > n)
					continue;
				if (dist[nx][ny] != Integer.MAX_VALUE || map[nx][ny] == -1)
					continue;

				dist[nx][ny] = dist[now[0]][now[1]] + 1;
				q.add(new int[] { nx, ny });
			}
		}
		return dist;
	}

	private static void init(int t) {

		int[][] dist = bfs(dest[t]);

		int min = Integer.MAX_VALUE;
		int[] result = new int[2];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] != 1)
					continue;
				if (min > dist[i][j]) {
					result[0] = i;
					result[1] = j;
					min = dist[i][j];
				} else if (min == dist[i][j]) {
					if (result[0] > i) {
						result[0] = i;
						result[1] = j;
					} else if (result[0] == i) {
						if (result[1] > j) {
							result[0] = i;
							result[1] = j;
						}
					}
				}
			}
		}

		player[t] = result;
		map[result[0]][result[1]] = -1;
	}

	private static boolean arrive(int t) {
		if (player[t][0] == dest[t][0] && player[t][1] == dest[t][1])
			return true;
		return false;
	}

	private static void move(int t) {
		if (arrive(t))
			return;

		int[][] dist = bfs(dest[t]);

		int min = Integer.MAX_VALUE;
		int minIdx = -1;
		for (int i = 0; i < 4; i++) {
			int nx = player[t][0] + dir[i][0];
			int ny = player[t][1] + dir[i][1];
			if (nx <= 0 || nx > n || ny <= 0 || ny > n)
				continue;
			if (min > dist[nx][ny]) {
				min = dist[nx][ny];
				minIdx = i;
			}
		}
		player[t][0] += dir[minIdx][0];
		player[t][1] += dir[minIdx][1];

	}

	private static boolean allDone() {
		for (int i = 1; i <= m; i++) {
			if (!arrive(i))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n + 1][n + 1]; // 0 : 빈칸 , 1: 베이스 캠프, -1: 못 지나감
		dest = new int[m + 1][2]; // 편의점 위치 저장
		player = new int[m + 1][2]; // x, y 값 저장

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i <= m; i++) {
			dest[i][0] = sc.nextInt();
			dest[i][1] = sc.nextInt();
		}
		sc.close();

		int t = 0;
		while (!allDone()) {
			t++;
			// 1. 한 칸씩 이동
			// 2. 이미 간 편의점 막기
			for (int i = 1; i < t && i <= m; i++) {
				move(i);
				if (arrive(i)) {
					int x = dest[i][0];
					int y = dest[i][1];
					map[x][y] = -1;
				}
			}

			// 3. 베이스 캠프로 이동
			if (t <= m) {
				init(t);
			}
		}

		System.out.println(t);
	}

}
