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
	return 0; //일치하는 값이 없을 경우
}

void quick_sort(int arr[], int low, int high) {
	if (low < high) {
		int pivot = arr[high];
		int i = low - 1;

		//피벗보다 작은 원소를 피벗 앞으로 이동
		for (int j = low; j <= high - 1; j++) {  
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		int temp = arr[i + 1]; //피벗을 올바른 위치로 이동
		arr[i + 1] = arr[high];
		arr[high] = temp;

		int pi = i + 1; //피벗의 위치

		//피벗을 기준으로 왼쪽, 오른쪽 부분을 각각 재귀적으로 정렬
		quick_sort(arr, low, pi - 1);
		quick_sort(arr, pi + 1, high);
	}
}

int main() {
	int T, N, M;
	scanf_s("%d", &T);


	while (T--) {
		scanf_s("%d", &N); //note1 배열 생성
		int*note1 = (int*)malloc(N * sizeof(int));
		for (int i = 0; i < N; i++) {
			scanf_s("%d", &note1[i]);
		}

		scanf_s("%d", &M); //note2 배열 생성
		int*note2 = (int*)malloc(M * sizeof(int));
		for (int i = 0; i < M; i++) {
			scanf_s("%d", &note2[i]);
		}

		quick_sort(note1, 0, N - 1); //note1 배열 오름차순 정렬


		for (int i = 0; i < M; i++) { //M번 반복
			int result = binary_search(note1, 0, N - 1, note2[i]);
			printf("%d\n", result);
		}
	}
}