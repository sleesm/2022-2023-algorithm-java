package DFSBFSPractice;

import java.util.*;

class Solution퍼즐조각채우기 {

	private int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	private int n = 0;
	private ArrayList<int[][]> game, tab;

	private void bfs(int x, int y, int[][] map, int sign, boolean[][] visited) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		visited[x][y] = true;
		ArrayList<int[]> list = new ArrayList<>();
		list.add(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dir[i][0];
				int ny = now[1] + dir[i][1];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;
				if (map[nx][ny] == sign && !visited[nx][ny]) {
					visited[nx][ny] = true;
					list.add(new int[] { nx, ny });
					q.offer(new int[] { nx, ny });
				}
			}
		}

		int minX = 51, minY = 51;
		int maxX = -1, maxY = -1;
		for (int[] tmp : list) {
			minX = Math.min(minX, tmp[0]);
			minY = Math.min(minY, tmp[1]);
			maxX = Math.max(maxX, tmp[0]);
			maxY = Math.max(maxY, tmp[1]);
		}

		int[][] rect = new int[maxX - minX + 1][maxY - minY + 1];
		for (int[] tmp : list) {
			rect[tmp[0] - minX][tmp[1] - minY] = 1;
		}

		if (sign == 0)
			game.add(rect);
		else
			tab.add(rect);
	}

	private boolean rotate(int[][] currentGame, int[][] currentTable) {
		if (Arrays.deepEquals(currentGame, currentTable))
			return true;

		for (int t = 0; t < 3; t++) {
			int[][] tmp = new int[currentTable[0].length][currentTable.length];
			for (int i = 0; i < tmp.length; i++) {
				for (int j = 0; j < tmp[0].length; j++) {
					tmp[i][j] = currentTable[tmp[0].length - j - 1][i];
				}
			}
			if (Arrays.deepEquals(currentGame, tmp))
				return true;
			currentTable = tmp;
		}
		return false;
	}

	private int checkCount(int gameIdx, int tabIdx, boolean[] visitedTab) {
		int[][] currentGame = game.get(gameIdx);
		int[][] currentTable = tab.get(tabIdx);

		if (!rotate(currentGame, currentTable))
			return 0;

		int count = 0;
		for (int i = 0; i < currentGame.length; i++) {
			for (int j = 0; j < currentGame[0].length; j++) {
				if (currentGame[i][j] == 1)
					count++;
			}
		}
		visitedTab[tabIdx] = true;
		return count;
	}

	public int solution(int[][] game_board, int[][] table) {
		int answer = 0;
		n = game_board.length;
		game = new ArrayList<>();
		tab = new ArrayList<>();

		int count = 2;
		boolean[][] visitedGame = new boolean[n][n];
		boolean[][] visitedTable = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (game_board[i][j] == 0 && !visitedGame[i][j])
					bfs(i, j, game_board, 0, visitedGame);
				if (table[i][j] == 1 && !visitedTable[i][j])
					bfs(i, j, table, 1, visitedTable);
			}
		}

		boolean[] visitedTab = new boolean[tab.size()];
		for (int i = 0; i < game.size(); i++) {
			for (int j = 0; j < tab.size(); j++) {
				if (!visitedTab[j]) {
					int tmp = checkCount(i, j, visitedTab);
					answer += tmp;
					if (tmp > 0)
						break; // 다음 table 해야하니까!
				}
			}
		}

		return answer;
	}
}