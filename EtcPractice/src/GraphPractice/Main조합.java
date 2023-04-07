package GraphPractice;

class Main���� {

	// ���� ���ϱ�
	static public void combination(int[] arr, int[] output, int start, int depth, int n, int r) {
		// ���� �������� ���� ��� �κ�
		if (depth == r) {
			print(output, r);
			return;
		} else {
			for (int i = start; i < n; i++) {
				output[depth] = arr[i];
				combination(arr, output, i + 1, depth + 1, n, r); // start�� ���� i ���� ��������  +1 �Ǵ� �� !!!
			}
		}
	}

	static void print(int[] arr, int r) {
		for (int i = 0; i < r; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		// ����� n���� �� �߿���
		int[] arr = { 1, 2, 3 };
		int n = arr.length;

		// r�� ���� ��
		int r = 3;
		int[] output = new int[r];

		// �Է� �迭, �̾Ƴ� ���ҵ� �迭, start, depth, n, r)
		combination(arr, output, 0, 0, n, r);

	}

}
