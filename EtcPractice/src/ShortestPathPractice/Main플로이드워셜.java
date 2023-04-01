package ShortestPathPractice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 플로이드 워셜 알고리즘 단방향
 */
class Main플로이드워셜 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] graph = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(graph[i], Integer.MAX_VALUE);
			graph[i][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int c = sc.nextInt();
			graph[x][y] = Math.min(graph[x][y], c);
		}
		sc.close();

		for (int k = 1; k <= n; k++)
			for (int i = 1; i <= n; i++) {
				if (graph[i][k] == Integer.MAX_VALUE)
					continue;
				for (int j = 1; j <= n; j++) {
					if (graph[k][j] == Integer.MAX_VALUE)
						continue;
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (graph[i][j] == Integer.MAX_VALUE)
					System.out.print("INF ");
				else
					System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}

}
