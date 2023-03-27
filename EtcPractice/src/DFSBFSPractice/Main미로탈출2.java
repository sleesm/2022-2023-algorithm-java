package DFSBFSPractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class MainπÃ∑Œ≈ª√‚2 {

	private static int bfs(int x, int y, int[][] map, boolean[][] visited) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		
		int[][] dxy = {{-1,0}, {1, 0}, {0, -1} , {0, 1}};
		int n = map.length;
		int m = map[0].length;
		
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			for(int i = 0; i< 4; i++) {
				int nx = xy[0] + dxy[i][0];
				int ny = xy[1] + dxy[i][1];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >=m)
					continue;
				if(map[nx][ny] == 0 || visited[nx][ny])
					continue;
				
				map[nx][ny] = map[xy[0]][xy[1]] + 1;
				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}
		}
		return map[n-1][m-1];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		
		for(int i = 0; i< n; i++) {
			for(int j = 0; j< m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		visited[0][0] = true;
		
		System.out.println(bfs(0,0, map, visited));
		
		for(int i = 0; i< n; i++) {
			for(int j = 0; j< m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
