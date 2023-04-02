package GraphPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class MainŬ�罺Į {

	private static int findParent(int[] parent, int i) {
		if (parent[i] == i)
			return parent[i];
		return findParent(parent, parent[i]);
	}

	private static void union(int[] parent, int a, int b) {
		a = findParent(parent, a);
		b = findParent(parent, b);
		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		int[] parent = new int[v + 1];
		for (int i = 1; i <= v; i++) {
			parent[i] = i;
		}

		int[][] list = new int[e][3];

		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			list[i] = new int[] { a, b, cost };
		}
		sc.close();

		Arrays.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}

		});

		int result = 0;
        for (int i = 0; i < e; i++) {
            if (findParent(parent, list[i][0]) != findParent(parent, list[i][1])) {
            	result += list[i][2];
                union(parent, list[i][0], list[i][1]);
            }
        }

		System.out.println(result);
	}

}
