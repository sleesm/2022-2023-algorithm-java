package ImplementationPractice;

import java.util.ArrayList;
import java.util.Scanner;

class Main싸움땅 {

	private static int n;
	private static ArrayList<Integer>[][] gunMap;
	private static int[][] player;
	private static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	private static int currentPlayer;
	private static int otherIdx;
	private static boolean isFirstMove;

	private static boolean checkPlayer(int x, int y) {
		for (int i = 0; i < player.length; i++) {
			if (i != currentPlayer && x == player[i][0] && y == player[i][1]) {
				otherIdx = i;
				return true;
			}
		}
		return false;
	}

	private static void comparePlayer(int[] win, int[] lose, int diff) {
		isFirstMove = false;
		int x = win[0];
		int y = win[1];

		// 진 사람
		gunMap[x][y].add(lose[4]);
		lose[4] = 0;
		int[] xy = move(lose);
		lose[0] = xy[0];
		lose[1] = xy[1];

		// 이긴 사람
		win[5] += diff;
		int gun = win[4];
		int max = 0;// gunMap[x][y].get(0);
		for (int i : gunMap[x][y]) {
			max = Math.max(max, i);
		}
		if (gun < max) {
			win[4] = max;
			gunMap[x][y].remove(Integer.valueOf(max));
			if (gun != 0)
				gunMap[x][y].add(gun);
		}
	}

	private static int[] move(int[] p) {
		int x = p[0];
		int y = p[1];
		int d = p[2];

		x += dir[d][0];
		y += dir[d][1];

		// 결투에서 진 플레이어가 이동 중 플레이어를 또 만날 때
		if (!isFirstMove) {
			int tmpx = x;
			int tmpy = y;
			while (checkPlayer(tmpx, tmpy) || (tmpx <= 0 || tmpx > n || tmpy <= 0 || tmpy > n)) {
				p[2] = (p[2] + 1) % 4;
				tmpx = p[0] + dir[p[2]][0];
				tmpy = p[1] + dir[p[2]][1];
				if (tmpx < 0 || tmpx >= n || tmpy < 0 || tmpy >= n)
					continue;
			}

			int gun = p[4];
			int max = 0;// gunMap[tmpx][tmpy].get(0);
			for (int i : gunMap[tmpx][tmpy]) {
				max = Math.max(max, i);
			}
			if (gun < max) {
				p[4] = max;
				gunMap[tmpx][tmpy].remove(Integer.valueOf(max));
				if (gun != 0)
					gunMap[tmpx][tmpy].add(gun);
			}
			x = tmpx;
			y = tmpy;
		} else {
			// 범위 밖
			if (x <= 0 || x > n || y <= 0 || y > n) {
				p[2] = (p[2] + 2) % 4;
				x = p[0] + dir[p[2]][0];
				y = p[1] + dir[p[2]][1];
			}
		}

		return new int[] { x, y };
	}

	private static void game(int[] p) {

		// 1단계 이동
		isFirstMove = true;
		int[] xy = move(p);
		p[0] = xy[0];
		p[1] = xy[1];

		// 2딘계
		int gun = p[4];
		if (!checkPlayer(xy[0], xy[1])) {
			int max = 0;// gunMap[xy[0]][xy[1]].get(0);
			for (int i : gunMap[xy[0]][xy[1]]) {
				max = Math.max(max, i);
			}
			if (gun < max) {
				p[4] = max;
				gunMap[xy[0]][xy[1]].remove(Integer.valueOf(max));
				if (gun != 0)
					gunMap[xy[0]][xy[1]].add(gun);
			}

		} else {

			int totalP = p[3] + p[4];
			int totalO = player[otherIdx][3] + player[otherIdx][4];
			if (totalP < totalO) {
				comparePlayer(player[otherIdx], p, totalO - totalP);
			} else if (totalP == totalO) {
				if(p[3] < p[4])
					comparePlayer(player[otherIdx], p, 0);
				else
					comparePlayer(p, player[otherIdx], 0);
			} else {
				comparePlayer(p, player[otherIdx], totalP - totalO);
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		gunMap = new ArrayList[n + 1][n + 1];
		player = new int[m][6]; // 4:가지고 있는 총의 공격량 5 : 포인트

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				gunMap[i][j] = new ArrayList<>();
				gunMap[i][j].add(sc.nextInt());
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 4; j++)
				player[i][j] = sc.nextInt();
			player[i][4] = 0;
			player[i][5] = 0;
		}
		sc.close();

		for (int i = 0; i < k; i++) {
			for (int j = 0; j < m; j++) {
				currentPlayer = j;
				game(player[j]);
			}
		}

		for (int i = 0; i < m; i++) {
			System.out.print(player[i][5] + " ");
		}
	}

}
