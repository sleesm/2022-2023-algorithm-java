package DFSBFSPractice;

import java.util.*;

class Solution아이템줍기 {

	private String[][] map;
	private int count = 0, total = 0;
	private int targetX = 0, targetY = 0;
	private int startX = 0, startY = 0;

	private void dfs(int x, int y) {
		String tmp = map[x][y];
		if (tmp.equals("LD") || tmp.equals("DL") || tmp.equals("LUX") || tmp.equals("D"))
			y--;
		if (tmp.equals("LU") || tmp.equals("UL") || tmp.equals("LDX") || tmp.equals("L"))
			x--;
		if (tmp.equals("RU") || tmp.equals("UR") || tmp.equals("RDX") || tmp.equals("U"))
			y++;
		if (tmp.equals("RD") || tmp.equals("DR") || tmp.equals("RUX") || tmp.equals("R"))
			x++;
		total++;
		if (x == targetX && y == targetY)
			count = total;
		if (x == startX && y == startY)
			return;
		dfs(x, y);
	}

	private void bfs(int cx, int cy) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { cx, cy });

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			String tmp = map[x][y];
			if (tmp.equals("LD") || tmp.equals("DL") || tmp.equals("LUX") || tmp.equals("D"))
				y--;
			if (tmp.equals("LU") || tmp.equals("UL") || tmp.equals("LDX") || tmp.equals("L"))
				x--;
			if (tmp.equals("RU") || tmp.equals("UR") || tmp.equals("RDX") || tmp.equals("U"))
				y++;
			if (tmp.equals("RD") || tmp.equals("DR") || tmp.equals("RUX") || tmp.equals("R"))
				x++;
			total++;
			if (x == targetX && y == targetY)
				count = total;
			if (x == startX && y == startY)
				break;
			q.offer(new int[] { x, y });
		}
	}

	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		int answer = 0;
		map = new String[51][51];
		for (int i = 1; i < 51; i++) {
			Arrays.fill(map[i], "");
		}
		targetX = itemX;
		targetY = itemY;
		startX = characterX;
		startY = characterY;

		for (int[] xy : rectangle) {
			int lx = xy[0], ly = xy[1], rx = xy[2], ry = xy[3];

			map[lx][ly] = "RDX";
			map[lx][ry] = "RUX";
			map[rx][ly] = "LDX";
			map[rx][ry] = "LUX";

			for (int i = ly + 1; i < ry; i++) {
				map[lx][i] += "U";
				map[rx][i] += "D";
			}

			for (int i = lx + 1; i < rx; i++) {
				map[i][ly] += "L";
				map[i][ry] += "R";
			}
		}

		// dfs(characterX, characterY);
		bfs(characterX, characterY);
		answer = Math.min(count, total - count);
		return answer;
	}
}