#include <stdio.h>

//ÆÈ(¿Þ¿À)Çã¸®´Ù¸®(¿Þ¿À)
int main() {
	int N = 0;
	scanf_s("%d", &N);
	int heart_X = 0;
	int heart_Y = 0;
	char c[1000][1000];

	
	
	for (int i = 0; i < N; i++) {        //c¹è¿­¿¡ ÀÔ·Â¹Þ±â
		for (int j = 0; j < N; j++) {
			scanf_s(" %c", &c[i][j]);
		}
	}
	
	for (int row =0; row < N; row++){
		for (int column = 0; column < N; column++) {
			if (c[row][column] == '*') {
				heart_X = row + 1;
				heart_Y = column;
				break;
			}
		}
		if (heart_X == row + 1)
			break;
	}

	int left_arm = 0;
	int right_arm = 0;
	int body = 0;
	int left_leg = 0;
	int right_leg = 0;

	for (int column = 0; column < heart_Y; column++) {
		if (c[heart_X][column] == '*')
			left_arm++;
	}
	for (int column = heart_Y + 1; column < N; column++) {
		if (c[heart_X][column] == '*')
			right_arm++;
	}
	for (int row = heart_X + 1; row < N; row++) {
		if (c[row][heart_Y] == '*')
			body++;
	}
	int body_X = heart_X + body;
	int body_Y = heart_Y;
	
	for (int row = body_X + 1; row < N; row++) {
		if (c[row][body_Y - 1] == '*')
			left_leg++;
	}
	for (int row = body_X + 1; row < N; row++) {
		if (c[row][body_Y + 1] == '*')
			right_leg++;
	}
	printf("%d %d\n%d %d %d %d %d", heart_X+1, heart_Y+1, left_arm, right_arm, body, left_leg, right_leg);
	
	return 0;
}