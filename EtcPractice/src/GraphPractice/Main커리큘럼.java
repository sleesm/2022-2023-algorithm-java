package GraphPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main커리큘럼 {

	private static int[] topologicalSort(ArrayList<Integer>[] list, int[] timecost, int[] indegree) {
		Queue<Integer> q = new LinkedList<>();
		int[] result = new int[timecost.length];
		for(int i = 1; i< indegree.length; i++) {
			result[i] = timecost[i];
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i : list[now]) {
				result[i] = Math.max(result[i], result[now] + timecost[i]);
				indegree[i]--;
				if(indegree[i] == 0) {
					q.offer(i);
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine().trim());
		int[] timecost = new int[n + 1];
		int[] indegree = new int[n + 1];
		ArrayList<Integer>[] list = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			String[] s = sc.nextLine().split(" ");
			timecost[i + 1] = Integer.parseInt(s[0]);
			for (int j = 1; j < s.length; j++) {
				int tmp = Integer.parseInt(s[j]);
				if (tmp != -1) {
					indegree[i + 1]++;
					list[tmp].add(i+1); //부모가 자식들을 가지고 있어야 함!
				}else continue;
			}
		}
		sc.close();
		
		int[] result = topologicalSort(list, timecost, indegree);
		for(int i = 1; i<= n; i++) {
			System.out.println(result[i]);
		}
		
	}

}
