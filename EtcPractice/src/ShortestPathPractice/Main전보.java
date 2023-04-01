package ShortestPathPractice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 플로이드 워셜 알고리즘 사용
 */
class Main전보 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int c = sc.nextInt();
		int[][] dist = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			dist[i][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			dist[a][b] = Math.min(dist[a][b], sc.nextInt());
		}
		sc.close();

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if (dist[i][k] == Integer.MAX_VALUE)
					continue;
				for (int j = 1; j <= n; j++) {
					if (dist[k][j] == Integer.MAX_VALUE)
						continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		int count = 0;
		int distance = 0;
		for (int i = 1; i <= n; i++) {
			if (i == c)
				continue;
			if (dist[c][i] > 0 && dist[c][i] != Integer.MAX_VALUE) {
				count++;
				distance = Math.max(distance, dist[c][i]);
			}
		}

		System.out.println(count + " " + distance);
	}

}
