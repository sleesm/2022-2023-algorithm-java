package GraphPractice;

import java.util.Scanner;

class Main사이클판명 {

	private static int findParent(int[] parent, int i) {
		if(parent[i] == i)
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
		int[] parent = new int[v+1];
		for(int i = 1; i<= v; i++) {
			parent[i] = i;
		}
		
		boolean check = false;
		for(int i = 0; i< e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			union(parent, a, b);
			if(findParent(parent, a) == findParent(parent,b))
				check = true;
		}
		sc.close();
		
		if(check)
			System.out.println("사이클 발생");
		else
			System.out.println("사이클 발생 안함");
		
	}

}
