package SearchPractice;

import java.util.Scanner;

class Main부품찾기2 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int n = Integer.parseInt(sc.nextLine().trim());
		 String s1 = sc.nextLine();
		 int m = Integer.parseInt(sc.nextLine().trim());
		 String[] list = sc.nextLine().split(" ");
		 sc.close();
		 
		 for(int i = 0; i< m; i++) {
			 if(s1.contains(list[i]))
				 System.out.println("yes");
			 else
				 System.out.println("no");
		 }
		 
	}

}
