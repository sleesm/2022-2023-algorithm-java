package ImplementationPractice;

import java.util.Scanner;

/**
 * 그리디 
 * 게임 개발
 */
class Main게임개발 {

	static int n, m;
	static int map[][];
	static int visit[][];

	private static int nextD(int d) {
		if (d == 0)
			return 3;
		return --d;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int d = sc.nextInt();

		map = new int[n][m];
		visit = new int[n][m];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				map[i][j] = sc.nextInt();
		sc.close();

		int[][] go = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		int visitCount = 1;
		int count = 0;
		visit[x][y] = 1;
		while (true) {
			// 방향 바꾸기
			d = nextD(d);
			int dx = x + go[d][0];
			int dy = y + go[d][1];

			// 바꾼 방향 가능한지 체크
			if (visit[dx][dy] == 0 && map[dx][dy] == 0) {
				visitCount++;
				x = dx;
				y = dy;
				visit[x][y] = 1;
				count = 0;
			} else {
				count++;
			}

			// 4방향 모두 간 경우
			if (count == 4) {
				dx = x - go[d][0];
				dy = y - go[d][1];
				if (map[dx][dy] == 0) {
					x = dx;
					y = dy;
					count = 0;
				} else {
					break;
				}
			}
		}

		System.out.println(visitCount);

	}

}
