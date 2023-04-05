package GraphPractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main13460 {

	private static int n, m;
	private static char[][] map;
	private static Ball red, blue;
	private static int[][] move = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	private static boolean[][][][] visited;
	private static int result = -1; // 둘다 구멍에 들어가는 경우만 나오는 경우를 대비한 초기

	static class Ball {
		int x;
		int y;
		int count;

		Ball(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

	private static void bfs() {
		Queue<Ball> redQ = new LinkedList<>();
		Queue<Ball> blueQ = new LinkedList<>();
		redQ.offer(red);
		blueQ.offer(blue);
		visited[red.x][red.y][blue.x][blue.y] = true;

		while (!redQ.isEmpty() && !blueQ.isEmpty()) {
			Ball nowRed = redQ.poll();
			Ball nowBlue = blueQ.poll();

			if (nowRed.count > 10) {
				result = -1;
				return;
			}

			//o을 만난 경우는 다 여기서 처리!
			//둘 다 O를 만난 경우, 하나만 O인 경우 모두 포함
			if (map[nowBlue.x][nowBlue.y] == 'O')
				continue;
			if (map[nowRed.x][nowRed.y] == 'O') {
				result = nowRed.count;
				return;
			}

			for (int i = 0; i < 4; i++) {

				//기울여서 이동 - #이거나 O일 때까지
				int rX = nowRed.x;
				int rY = nowRed.y;
				while (true) {
					rX += move[i][0];
					rY += move[i][1];
					if (map[rX][rY] == 'O')
						break;
					else if (map[rX][rY] == '#') {
						rX -= move[i][0];
						rY -= move[i][1];
						break;
					}
				}

				int bX = nowBlue.x;
				int bY = nowBlue.y;
				while (true) {
					bX += move[i][0];
					bY += move[i][1];
					if (map[bX][bY] == 'O')
						break;
					else if (map[bX][bY] == '#') {
						bX -= move[i][0];
						bY -= move[i][1];
						break;
					}
				}

				//둘이 위치가 같은 경우 + O가 아닌 경우 : 현재 거리로부터 가까운 게 먼저 와 있어야 함
				if (rX == bX && rY == bY && map[rX][rY] != 'O') {
					double diffR = Math.abs(nowRed.x - rX) + Math.abs(nowRed.y - rY);
					double diffB = Math.abs(nowBlue.x - bX) + Math.abs(nowBlue.y - bY);

					//red가 이동을 더 적게 하면 더 가까이 있다는 뜻
					if (diffR < diffB) {
						bX -= move[i][0];
						bY -= move[i][1];
					} else {
						rX -= move[i][0];
						rY -= move[i][1];
					}
				}

				//queue에 넣기
				//둘의 위치가 다른 경우 + O인 경우
				if (!visited[rX][rY][bX][bY]) {
					visited[rX][rY][bX][bY] = true;
					redQ.add(new Ball(rX, rY, nowRed.count + 1));
					blueQ.add(new Ball(bX, bY, nowBlue.count + 1));
				}
			}

		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new char[n][m];
		visited = new boolean[n][m][n][m];

		for (int i = 0; i < n; i++) {
			String tmp = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = tmp.charAt(j);
				if (tmp.charAt(j) == 'R') {
					red = new Ball(i, j, 0);
					map[i][j] = '.';
				}
				if (tmp.charAt(j) == 'B') {
					blue = new Ball(i, j, 0);
					map[i][j] = '.';
				}

			}
		}
		sc.close();

		bfs();
		System.out.println(result);
	}

}
