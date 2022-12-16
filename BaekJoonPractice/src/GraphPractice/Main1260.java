package GraphPractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/***
 * BFS/DFS
 */
class Main1260 {

	static int n;
	static int m;
	static int[][] map;
	static boolean[] check;
	
	private static void dfs(int start) {
		check[start] = true;
		System.out.print(start + " ");
		
		for(int i = 1; i< n+1; i++) {
			if(map[start][i] == 1 && !check[i])
				dfs(i);
		}
	}
	
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		check[start] = true;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			System.out.print(tmp + " ");
			
			for(int i = 1; i< n+1; i++) {
				if(map[tmp][i] == 1 && !check[i]) {
					check[i] = true;
					q.offer(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int v = sc.nextInt();
		
		map = new int[n+1][n+1];
		check = new boolean[n+1];
		
		for(int i = 0; i< m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = map[y][x] = 1; 
		}
		sc.close();
		
		dfs(v);
		
		System.out.println();
		check = new boolean[n+1];
		
		bfs(v);
	}

}
