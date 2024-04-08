#include <stdio.h>

int main() {
	int state[3][4] = { 0 };
	for (int i = 0; i < 3; i++) {
		scanf_s("%d %d %d %d", &state[i][0], &state[i][1], &state[i][2], &state[i][3]);
	}
	for (int j = 0; j < 3; j++) {
		int sum = 0;
		for (int k = 0; k < 4; k++) {
			sum += state[j][k];
		}
		if (sum == 3)
			printf("%c", 'A');
		else if (sum == 2)
			printf("%c", 'B');
		else if (sum == 1)
			printf("%c", 'C');
		else if (sum == 0)
			printf("%c", 'D');
		else
			printf("%c", 'E');
		printf("\n");
	}
	return 0;
}