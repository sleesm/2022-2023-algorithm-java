package GraphPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main위상정렬 {

	private static int v;
	private static int e;
	private static ArrayList<Integer>[] list;
	private static int[] indegree;
	
	private static void topologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i<= v; i++) {
			if(indegree[i] == 0)
				q.offer(i);
		}
		
		while(!q.isEmpty()){
			int now = q.poll();
			System.out.print(now + " ");
			for(int i : list[now]) {
				indegree[i]--;
				if(indegree[i] == 0)
					q.offer(i);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		e = sc.nextInt();
		list = new ArrayList[v + 1];
		indegree = new int[v + 1];

		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			indegree[b] += 1;
		}
		sc.close();
		
		topologicalSort();
	}

}
