#include <stdio.h>

int binary_search(int arr[], int low, int high, int target) {
	while (low <= high) {
		int mid = low + (high - low) / 2;

		if (arr[mid] == target) {
			return 1;
		}
		else if (arr[mid] < target) {
			low = mid + 1;
		}
		else {
			high = mid - 1;
		}
	}
	return 0; //��ġ�ϴ� ���� ���� ���
}

void quick_sort(int arr[], int low, int high) {
	if (low < high) {
		int pivot = arr[high];
		int i = low - 1;

		//�ǹ����� ���� ���Ҹ� �ǹ� ������ �̵�
		for (int j = low; j <= high - 1; j++) {  
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		int temp = arr[i + 1]; //�ǹ��� �ùٸ� ��ġ�� �̵�
		arr[i + 1] = arr[high];
		arr[high] = temp;

		int pi = i + 1; //�ǹ��� ��ġ

		//�ǹ��� �������� ����, ������ �κ��� ���� ��������� ����
		quick_sort(arr, low, pi - 1);
		quick_sort(arr, pi + 1, high);
	}
}

int main() {
	int T, N, M;
	scanf_s("%d", &T);


	while (T--) {
		scanf_s("%d", &N); //note1 �迭 ����
		int*note1 = (int*)malloc(N * sizeof(int));
		for (int i = 0; i < N; i++) {
			scanf_s("%d", &note1[i]);
		}

		scanf_s("%d", &M); //note2 �迭 ����
		int*note2 = (int*)malloc(M * sizeof(int));
		for (int i = 0; i < M; i++) {
			scanf_s("%d", &note2[i]);
		}

		quick_sort(note1, 0, N - 1); //note1 �迭 �������� ����


		for (int i = 0; i < M; i++) { //M�� �ݺ�
			int result = binary_search(note1, 0, N - 1, note2[i]);
			printf("%d\n", result);
		}
	}
}