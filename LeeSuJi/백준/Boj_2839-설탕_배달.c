#include <stdio.h>

int main() {
	int N;
	scanf_s("%d", &N);
	int sugar[5001][2] = { 0 }; //0 columnÀº 3kg 1 columnÀº 5kg
	sugar[3][0] = 1;
	sugar[5][1] = 1;
	sugar[6][0] = 2;
	sugar[8][0] = 1;
	sugar[8][1] = 1;
	for (int i = 9; i <= N; i++) {
		if (sugar[i - 1][0] > 2) {
			sugar[i][0] = sugar[i - 1][0] - 3;
			sugar[i][1] = sugar[i - 1][1] + 2;
		}
		else if (sugar[i - 1][1] > 0) {
			sugar[i][0] = sugar[i - 1][0] + 2;
			sugar[i][1] = sugar[i - 1][1] - 1;
		}
	
	}
	int result = sugar[N][0] + sugar[N][1];
	if (result == 0)
		printf("-1");
	else
		printf("%d", result);
	return 0;
}