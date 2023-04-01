package ShortestPathPractice;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 다익스트라 알고리즘 사용
 */
class Main전보2 {

	static class Node {
		int v;
		int cost;

		Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
	}

	static ArrayList<Node>[] list;
	static int[] dist;

	static void dijkstra(int k) {
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		q.offer(new Node(k, 0));
		dist[k] = 0;

		while (!q.isEmpty()) {
			Node now = q.poll();

			if (now.cost > dist[now.v])
				continue;

			for (Node next : list[now.v]) {
				if (dist[next.v] > now.cost + next.cost) {
					dist[next.v] = now.cost + next.cost;
					q.offer(new Node(next.v, dist[next.v]));
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int c = sc.nextInt();

		list = new ArrayList[n + 1];
		dist = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(new Node(b, sc.nextInt()));
		}
		sc.close();

		dijkstra(c);

		int count = 0;
		int distance = 0;
		for (int i = 1; i <= n; i++) {
			if (dist[i] > 0 && dist[i] != Integer.MAX_VALUE) {
				count++;
				distance = Math.max(distance, dist[i]);
			}
		}

		System.out.println(count + " " + distance);
	}

}
