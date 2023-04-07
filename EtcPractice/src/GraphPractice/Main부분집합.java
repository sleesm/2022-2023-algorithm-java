package GraphPractice;

import java.util.ArrayList;

class Main�κ����� {

	static void subset(int[] arr, boolean[] selected, int depth) {
		if(depth == arr.length) {
			print(arr, selected);
			return;
		}
		selected[depth] = true;
		subset(arr, selected, depth + 1);
		selected[depth] = false;
		subset(arr, selected, depth + 1);
	}
	
	static void subsuetUsingIntArray(int[] arr, int[] selected, int depth, int sIdx) {
		if(depth == arr.length) {
			ArrayList<Integer> list = new ArrayList<>();
			for(int i = 0; i< sIdx; i++) {
				list.add(selected[i]);
			}
			System.out.print(list);
			return;
		}
		
		subsuetUsingIntArray(arr, selected, depth + 1, sIdx);
		selected[sIdx] = arr[depth];
		subsuetUsingIntArray(arr, selected, depth + 1, sIdx + 1);
	}
	
	static void print(int[] arr, boolean[] selected) {
		for (int i = 0; i < selected.length; i++)
			if(selected[i])
				System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		// ����� n���� �� 
		int[] arr = { 1, 2, 3 };

		boolean[] selected = new boolean[ arr.length];
		int[] select = new int[arr.length];

		// �Է� �迭, ���� ������ �����ϴ� �迭, depth
		subset(arr, selected,  0);
		
		// �Է� �迭, �κ� ���� �����ϴ� �迭, depth, select�� �ε��� ��
		subsuetUsingIntArray(arr, select, 0, 0);
	}

}
