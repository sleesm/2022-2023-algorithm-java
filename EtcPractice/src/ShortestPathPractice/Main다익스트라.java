package ShortestPathPractice;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main���ͽ�Ʈ�� {

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
		// ���ٽ����� �켱���� ����
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		q.offer(new Node(k, 0));
		dist[k] = 0;

		while (!q.isEmpty()) {
			Node now = q.poll();

			// visited[] ������� �ʰ� cost�� �湮�� ��� Ȯ��
			if (now.cost > dist[now.v])
				continue;

			for (Node next : list[now.v]) {
				if (dist[next.v] > next.cost + now.cost) {
					dist[next.v] = next.cost + now.cost;
					q.offer(new Node(next.v, dist[next.v]));
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // ��� ����
		int m = sc.nextInt(); // ���� ����
		int k = sc.nextInt(); // ���� ���

		list = new ArrayList[n + 1];
		dist = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < m; i++) {
			int v = sc.nextInt();
			list[v].add(new Node(sc.nextInt(), sc.nextInt()));
		}
		sc.close();

		dijkstra(k);
	}

}
