#include <stdio.h>

int main() {
	int T = 0;
	int k, n;
	int mem[15][14];
	for (int i = 0; i < 14; i++) {
		mem[0][i] = i+1;
	}
	for (int i = 1; i < 15; i++) {
		for (int j = 0; j < 14; j++) {
			if (j == 0)
				mem[i][j] = 1;
			else
				mem[i][j] = mem[i - 1][j] + mem[i - 1][j - 1];
		}
	}
	scanf_s("%d", &T);
	for (int i = 0; i < T; i++) {
		scanf_s("%d %d", &k, &n);
		printf("%d\n", mem[k][n]);
	}
}