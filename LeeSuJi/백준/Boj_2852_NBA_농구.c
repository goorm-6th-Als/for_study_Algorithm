#include <stdio.h>

int main() {
	int N = 0;
	scanf_s("%d", &N);

	int goal[100][4] = { 0 };
	for (int i = 0; i < N; i++) {
		scanf_s("%d %d:%d", &goal[i][0], &goal[i][1], &goal[i][2]);
	}

	int score1 = 0;
	int min1 = 0;
	int sec1 = 0;
	int score2 = 0;
	int min2 = 0;
	int sec2 = 0;
	for (int i = 0; i < N; i++) {
		if (goal[i][0] == 1)
			score1++;
		else
			score2++;

	}
	printf("%d:%d\n%d:%d", min1, sec1, min2, sec2);
	return 0;
}

//10:30  630  12:20  740   110 = 1Ка 50УЪ