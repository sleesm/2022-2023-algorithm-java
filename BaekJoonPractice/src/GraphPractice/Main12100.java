package GraphPractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main12100 {

	static int n;
	static int[][] map;
	static int[][] direct = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
	static int result = 0;

	private static void move(int[][] map, int d) {
		boolean[][] visited = new boolean[n][n];

		// 상, 좌
		if (d == 0 || d == 2) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 0)
						continue;
					int x = i;
					int y = j;
					int nx = i + direct[d][0];
					int ny = j + direct[d][1];

					int tmp = map[i][j];
					map[i][j] = 0;

					while (true) {

						if (nx < 0 || nx >= n || ny < 0 || ny >= n)
							break;

						if (map[nx][ny] != 0) {
							if (map[nx][ny] == tmp && !visited[nx][ny]) {
								x = nx;
								y = ny;
								visited[nx][ny] = true;
							}
							break;
						} else {
							x = nx;
							y = ny;
							nx += direct[d][0];
							ny += direct[d][1];
						}

					}
					map[x][y] += tmp;
				}
			}
		} else { // 하, 우
			for (int i = n - 1; i >= 0; i--) {
				for (int j = n - 1; j >= 0; j--) {
					if (map[i][j] == 0)
						continue;
					int x = i;
					int y = j;
					int nx = i + direct[d][0];
					int ny = j + direct[d][1];

					int tmp = map[i][j];
					map[i][j] = 0;

					while (true) {

						if (nx < 0 || nx >= n || ny < 0 || ny >= n)
							break;

						if (map[nx][ny] != 0) {
							if (map[nx][ny] == tmp && !visited[nx][ny]) {
								x = nx;
								y = ny;
								visited[nx][ny] = true;
							}
							break;
						} else {
							x = nx;
							y = ny;
							nx += direct[d][0];
							ny += direct[d][1];
						}

					}
					map[x][y] += tmp;
				}
			}
		}
	}

	private static void bfs() {
		Queue<int[][]> q = new LinkedList<>();
		q.offer(map);

		int count = 0;
		while (!q.isEmpty()) {
			int q_len = q.size();
			for (int t = 0; t < q_len; t++) {
				int[][] map = q.poll();

				for (int d = 0; d < 4; d++) {
					int[][] newMap = new int[n][n];
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++)
							newMap[i][j] = map[i][j];
					}

					move(newMap, d);

					q.offer(newMap);
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							result = Math.max(result, newMap[i][j]);
						}
					}

				}

			}
			count++;
			if (count >= 5) {
				return;
			}
		}
	}

	private static void dfs(int[] arr, int depth) {
		if (depth == 5) {
			int[][] newMap = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					newMap[i][j] = map[i][j];
			}

			int[] newArr = arr.clone();
			for (int d : newArr) {
				move(newMap, d);
				
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						result = Math.max(result, newMap[i][j]);
					}
				}
			}
			return;
		}

		// 방향 4개 중에 5번 뽑음
		for (int i = 0; i < 4; i++) {
			arr[depth] = i;
			dfs(arr, depth + 1);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		sc.close();

		bfs();
//		dfs(new int[5], 0);
		System.out.println(result);
	}

}
