#include <stdio.h>

int main() {
	int N, K, L;
	scanf_s("%d %d %d", &N, &K, &L);

	int arr[100000] = { 0 };
	for (int i = 0; i < N; i++) {
		arr[i] = 1; //N���� �����鿡�� 1 �ο�
	}

	arr[K - 1] = 2; //�迡�� 2
	arr[L - 1] = 2; //�ӿ��� 2

	int round = 1; //1������� ����
	int meet = 0;

	while (N > 1) {
		for (int i = 0; i < N; i=i+2) {
			if (i+1==N) { //�������ϴ� ���
				arr[i / 2] = arr[i];
			}
			else if (arr[i] >= arr[i + 1]) {
				if (arr[i] == 2 && arr[i + 1] == 2) {
					meet = 1;
					break;
				}
				arr[i / 2] = arr[i];
			}
			else if (arr[i + 1] > arr[i]) {
				arr[i / 2] = arr[i + 1];
			}

		}
		if (meet == 1)
			break;
		if (N % 2 == 0)
			N = N / 2;
		else
			N = N / 2 + 1;
		round++;

		if (N < 2)
			round = -1;
	}
	printf("%d", round);
	return 0;
}