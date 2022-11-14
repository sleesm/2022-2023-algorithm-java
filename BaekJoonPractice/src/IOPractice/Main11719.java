package IOPractice;
import java.util.ArrayList;
import java.util.Scanner;

class Main11719 {
	// 11718
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		while(sc.hasNext()) {
			list.add(sc.nextLine());
		}
		for(String s : list) {
			System.out.println(s);
		}
		sc.close();
	}
}
