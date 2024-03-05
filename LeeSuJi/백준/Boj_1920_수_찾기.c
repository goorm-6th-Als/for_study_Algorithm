#include <stdio.h>

int main() {
	int N, M = 0;
	int A[100000] = { 0 };
	int B[100000] = { 0 };
	
	scanf_s("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf_s("%d", &A[i]);
	}
	scanf_s("%d", &M);
	for (int i = 0; i < M; i++) {
		scanf_s("%d", &B[i]);
	}

	int C[100000] = { 0 };

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (A[i] == B[j]) {
				C[i] = 1;
			}
		}
	}
	for (int i = 0; i < N; i++) {
		printf("%d\n", C[i]);
	}
	return 0;
}