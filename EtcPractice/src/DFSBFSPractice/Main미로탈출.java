package DFSBFSPractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * BFS
 * πÃ∑Œ ≈ª√‚
 */
class MainπÃ∑Œ≈ª√‚ {

	
	private static int[][] map;
	private static int n,m;
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	
	private static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int tx = tmp[0];
			int ty = tmp[1];

			for(int i = 0; i< 4; i++) {
				int nx = tx + dx[i];
				int ny = ty + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if(map[nx][ny] == 0 || visited[nx][ny])
					continue;
				
				map[nx][ny] = map[tx][ty] + 1;
				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny});
				
			}
		}
		return map[n-1][m-1];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		visited = new boolean[n][m];
		map = new int[n][m];
		for(int i = 0; i< n; i++)
			for(int j =0; j< m; j++)
				map[i][j] = sc.nextInt();
		sc.close();

		visited[0][0] = true;
		System.out.println(bfs(0,0));
	}

}
