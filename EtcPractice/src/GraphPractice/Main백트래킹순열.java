package GraphPractice;

class Main��Ʈ��ŷ���� {

	// ���������� ���� ���ϱ�
	static public void backtracking(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		// ���� �������� ���� ��� �κ�
		if (depth == r) {
			print(output, r);
			return;
		} else {
			for (int i = 0; i < n; i++) {
				if (visited[i] == false) {
					visited[i] = true; // �湮 üũ
					output[depth] = arr[i]; // depth�� output�� �ε��� �������Ѵ�. - ������ ��ġ ��ȭ
					backtracking(arr, output, visited, depth + 1, n, r);
					visited[i] = false;// ���󺹱� �߿�!
				}
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

		// �ߺ� x -> �湮 üũ
		boolean[] visited = new boolean[n];

		// �Է� �迭, �̾Ƴ� ���ҵ� �迭, �湮 �迭, depth, n, r)
		backtracking(arr, output, visited, 0, n, r);

	}

}
