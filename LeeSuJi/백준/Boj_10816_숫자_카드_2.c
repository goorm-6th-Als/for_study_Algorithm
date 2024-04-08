#include <stdio.h>

int main() {
	int N;
	scanf_s("%d", &N);
	int* nums = (int*)malloc(sizeof(int)*N);
	for (int i = 0; i < N; i++) {
		scanf_s("%d", &nums[i]);
	}
	int M;
	scanf_s("%d", &M);
	int* card = (int*)malloc(sizeof(int)*M);
	for (int i = 0; i < M; i++) {
		scanf_s("%d", &card[i]);
	}

	for (int i = 0; i < M; i++) {
		int result = 0;
		for (int j = 0; j < N; j++) {
			while (card[i] == nums[j]) {
				result++;
				nums[j] = nums[N - 1];
				N--;
				if (j == N) break;
			}
		}
		printf("%d ", result);
	}
	return 0;
}