package GraphPractice;

import java.util.Scanner;

class Main¼­·Î¼Ò {

	private static int findParent(int[] parents, int i) {
		if (parents[i] == i)
			return parents[i];
		return findParent(parents, parents[i]);
	}

	private static void union(int[] parents, int a, int b) {
		a = findParent(parents, a);
		b = findParent(parents, b);
		if (a < b)
			parents[b] = a;
		else
			parents[a] = b;
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		int[] parents = new int[v + 1];
		for (int i = 1; i <= v; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			union(parents, a, b);
		}
		sc.close();

		for (int i = 1; i <= v; i++) {
			System.out.print(findParent(parents, i) + " ");
		}
		System.out.println();
		for (int i = 1; i <= v; i++) {
			System.out.print(parents[i] + " ");
		}
	}

}
