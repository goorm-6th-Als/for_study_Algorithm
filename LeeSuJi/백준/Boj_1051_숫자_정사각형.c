#include <stdio.h>

int main() {
	int N = 0;
	int M = 0;
	scanf_s("%d %d", &N, &M);
	int box[50][50] = { 0 };
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf_s("%1d", &box[i][j]);
		}
	}

	int large = 0;
	for (int i = 0; i < N - 1; i++) {
		for (int j = 0; j < M - 1; j++) {
			for (int k = 1; i + k < N && j + k < M; k++) {
				if (box[i][j] == box[i][j + k] && box[i][j + k] == box[i + k][j + k] && box[i + k][j + k] == box[i + k][j] && box[i + k][j] == box[i][j]) {
					if ((k + 1)*(k + 1) > large)
						large = (k + 1)*(k + 1);
				}
			}
		}
	}
	if (large == 0)
		large = 1;
	printf("%d", large);
	return 0;
}