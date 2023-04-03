package GraphPractice;

import java.util.Scanner;

class MainÆÀ°á¼º {

	private static int findParent(int[] parent, int i) {
		if(parent[i] == i)
			return parent[i];
		return findParent(parent, parent[i]);
	}
	
	private static void union(int[] parent, int a, int b) {
		a = findParent(parent, a);
		b = findParent(parent, b);
		if(a<b)
			parent[b] = a;
		else
			parent[a] = b;
	}
	
	private static void check(int[] parent, int a, int b) {
		if(parent[a] == parent[b])
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] parent = new int[n+1];
		
		for(int i = 0; i<= n; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i< m; i++) {
			int sign = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(sign == 0)
				union(parent, a, b);
			else
				check(parent, a, b);
		}
		sc.close();
	}

}
