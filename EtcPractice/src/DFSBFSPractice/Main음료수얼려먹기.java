package DFSBFSPractice;

import java.util.Scanner;

/**
 * DFS
 * ����� ��� �Ա�
 */
class Main���������Ա� {

	private static int[][] map;
	private static int n, m;
	private static int[][] dxy = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	
	private static boolean dfs(int x, int y) {
		if(x < 1 || y < 0 || x >= n || y >= m)
			return false;
		if(map[x][y] == 0) {
			map[x][y] = 1;
			for(int i = 0; i< 4; i++)
				dfs(x + dxy[i][0], y + dxy[i][1]); 
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		for(int i = 0; i< n; i++)
			for(int j = 0; j<m; j++)
				map[i][j] = sc.nextInt();
		sc.close();
		
		int result= 0;
		for(int i = 0; i< n; i++)
			for(int j = 0; j<m; j++) {
				if(dfs(i,j))
					result++;
			}
		System.out.println(result);
	}

}
