package ImplementationPractice;

import java.util.Scanner;

class Main»óÇÏÁÂ¿ì2 {

	static int[] dx = {0, 0, -1, 1};
	static int [] dy = {-1, 1, 0, 0};
	static String[] direct = {"L", "R", "U","D"};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = 1, y = 1;
		
		while (sc.hasNext()) {
			String tmp = sc.next();
			int tx = x;
			int ty = y;
			
			for(int i = 0; i< 4; i++) {
				if(direct[i].equals(tmp)) {
					x += dx[i];
					y += dy[i];
				}
			}
			
			if (x < 1 || x > n || y < 1 || y > n) {
				x = tx;
				y = ty;
			}
		}
		sc.close();
		System.out.println(x + " " + y);
	}
}
