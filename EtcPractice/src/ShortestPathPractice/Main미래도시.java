package ShortestPathPractice;

import java.util.Arrays;
import java.util.Scanner;

class Main미래도시 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] dist = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			dist[i][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			dist[a][b] = 1;
			dist[b][a] = 1;
		}

		int x = sc.nextInt();
		int k = sc.nextInt();
		sc.close();

		for (int p = 1; p <= n; p++) {
			for (int i = 1; i <= n; i++) {
				if (dist[i][p] == Integer.MAX_VALUE)
					continue;
				for (int j = 1; j <= n; j++) {
					if (dist[p][j] == Integer.MAX_VALUE)
						continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][p] + dist[p][j]);
				}
			}
		}

		if (dist[1][k] == Integer.MAX_VALUE || dist[k][x] == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dist[1][k] + dist[k][x]);
	}

}
