#include <stdio.h>

int main() {
	int T;
	scanf_s("%d", &T);
	
	for (int i = 0; i < T; i++) {
		int N, M;
		scanf_s("%d %d", &N, &M);
		int AP[10000][2] = { 0 };
		for (int j = 0; j < M; j++) {
			scanf_s("%d %d", &AP[j][0], &AP[j][1]);
		}
		printf("%d\n", N - 1);
	}
	return 0;
}