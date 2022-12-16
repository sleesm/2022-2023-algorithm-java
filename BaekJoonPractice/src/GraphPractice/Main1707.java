package GraphPractice;

import java.util.ArrayList;
import java.util.Scanner;

/***
 * 이분 그래프
 */
class Main1707 {
	static int[] v;
	static int[] e;

	/***
	 * @param color -> 0 : no visit 1: visit 1st group 2: visit 2nd group
	 */
	private static void dfs(ArrayList<Integer>[] list, int[] color, int start, int status) {	
		color[start] = status;
		for (int node : list[start]) {
			if (color[node] == 0) {
				dfs(list, color, node, 3-status);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		boolean [] result = new boolean[k];

		for (int j = 0; j < k; j++) {
			int v = sc.nextInt();
			int e = sc.nextInt();
			ArrayList<Integer>[] list = new ArrayList[v+1]; 
			int[] color = new int[v+1];
			
			for(int i = 1; i<= v; i++) {
				list[i] = new ArrayList<Integer>();
			}
			
			for (int i = 0; i < e; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				list[x].add(y);
				list[y].add(x);
			}

			
			for (int i = 1; i <= v; i++) {
				if (color[i] == 0) {
					dfs(list,color, i, 1);
				}
			}
			
			result[j] = true;
			for(int i = 1; i<= v; i++) {
				for(int node : list[i]) {
					if(color[node] == color[i])
						result[j] = false;
				}
			}
		}
		sc.close();
		
		for(int i = 0; i< k; i++) {
			if (result[i])
				System.out.println("YES");
			else
				System.out.println("NO");				
		}
	}
}
