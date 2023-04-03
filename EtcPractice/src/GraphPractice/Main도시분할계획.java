package GraphPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main도시분할계획 {

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
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] parent = new int[n + 1];
		int[][] list = new int[m][3];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			list[i] = new int[] { a, b, c };
		}
		sc.close();
		
		Arrays.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[2] - b[2];
			}
		});

		int result = 0;
		int maxCost = 0;
		for (int i = 0; i < m; i++) {
			if (findParent(parent, list[i][0]) != findParent(parent, list[i][1])) {
				union(parent, list[i][0], list[i][1]);
				result += list[i][2];
				maxCost = Math.max(list[i][2], maxCost);
			}
		}

		System.out.println(result - maxCost);

	}

}
