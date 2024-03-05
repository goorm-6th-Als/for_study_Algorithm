#include <stdio.h>
#include <math.h>

int main() {
	int N, L, R;
	scanf_s("%d %d %d", &N, &L, &R);
	int A[50][50] = { 0 };
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			scanf_s("%d", &A[i][j]);
		}
	}
	
	int day = 0;
	while (1) {
		int B[50][50] = { 0 };
		int u = 0;
		int large = 0;
		int o = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j < N - 1) {
					if (abs(A[i][j] - A[i][j + 1]) >= L && abs(A[i][j] - A[i][j + 1]) <= R) {
						if (i == 0) {
							if (j == 0) {
								u = large + 1;
							}
							else {
								if (B[i][j - 1] == 0)
									u=large+1;
							}
						}
						else {
							if (j == 0) {
								if (B[i - 1][j] == 0)
									u=large+1;
							}
							else {
								if (B[i][j - 1] == 0 && B[i - 1][j] == 0)
									u=large+1;
								else if (B[i][j] != 0) {
									u = B[i][j];
								}
							}
						}
						if (u > large)
							large = u;
						B[i][j] = u;
						B[i][j + 1] = u;
						o = 1;
						
					}
				}
				if (i < N - 1) {
					if (abs(A[i][j] - A[i + 1][j]) >= L && abs(A[i][j] - A[i + 1][j]) <= R) {
						if (i == 0) {
							if (j == 0) {
								if (B[i][j] == 0)
									u++;
							}
							else {
								if (B[i][j - 1] == 0&&B[i][j]==0)
									u++;
							}
						}
						else {
							if (j == 0) {
								if (B[i + 1][j] == 0 && B[i][j] == 0) {
									u++;
								}
							}
							else {
								if (B[i - 1][j] == 0 && B[i][j - 1] == 0 && B[i][j] == 0) {
									u++;
								}
							}
						}
						B[i][j] = u;
						B[i + 1][j] = u;
						o = 1;
						
					}
				}
				
			}
		}
		if (o == 0) break;

		for (int i = 1; i <= u; i++) {
			int sum = 0;
			int num = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (B[j][k] == u ) {
						sum += A[j][k];
						num++;
					}
				}
			}
			sum = (sum / num);
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (B[j][k] == u) {
						A[j][k] = sum;
					}
				}
			}
		}
		day++;
	}
	printf("%d", day);
	return 0;
}