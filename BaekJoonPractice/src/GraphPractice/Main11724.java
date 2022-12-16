package GraphPractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/***
 * BFS/DFS
 * 연결 요소 개수 구하기
 */
class Main11724 {
	
	static int n;
	static int m;
	static int[][] map;
	static boolean[] check;
	
	private static void bfs(int start) {
		if(check[start])
			return;
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i = 1; i<= n; i++) {
				if(map[tmp][i] ==1 & !check[i]) {
					check[i] = true;
					q.offer(i);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n+1][n+1];
		check = new boolean[n+1];

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = map[y][x] = 1;
		}
		sc.close();

		int count = 0;
		for(int i = 1; i<= n; i++) {
			if(!check[i]) {
				bfs(i);
				count++;
			}
		}
		System.out.print(count);
	}

}
