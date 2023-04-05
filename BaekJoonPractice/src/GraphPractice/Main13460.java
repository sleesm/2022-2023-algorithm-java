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
	private static int result = -1; // �Ѵ� ���ۿ� ���� ��츸 ������ ��츦 ����� �ʱ�

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

			//o�� ���� ���� �� ���⼭ ó��!
			//�� �� O�� ���� ���, �ϳ��� O�� ��� ��� ����
			if (map[nowBlue.x][nowBlue.y] == 'O')
				continue;
			if (map[nowRed.x][nowRed.y] == 'O') {
				result = nowRed.count;
				return;
			}

			for (int i = 0; i < 4; i++) {

				//��￩�� �̵� - #�̰ų� O�� ������
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

				//���� ��ġ�� ���� ��� + O�� �ƴ� ��� : ���� �Ÿ��κ��� ����� �� ���� �� �־�� ��
				if (rX == bX && rY == bY && map[rX][rY] != 'O') {
					double diffR = Math.abs(nowRed.x - rX) + Math.abs(nowRed.y - rY);
					double diffB = Math.abs(nowBlue.x - bX) + Math.abs(nowBlue.y - bY);

					//red�� �̵��� �� ���� �ϸ� �� ������ �ִٴ� ��
					if (diffR < diffB) {
						bX -= move[i][0];
						bY -= move[i][1];
					} else {
						rX -= move[i][0];
						rY -= move[i][1];
					}
				}

				//queue�� �ֱ�
				//���� ��ġ�� �ٸ� ��� + O�� ���
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
