#include <stdio.h>

int main() {
	int N;
	scanf_s("%d", &N);
	int winner[1001] = { 0 };
	winner[1] = 1; //1은 상근
	winner[2] = 0; //0은 창영
	winner[3] = 1;
	winner[4] = 1;
	for (int i = 5; i <= N; i++) {
		if (winner[i - 1] == 0 || winner[i - 3] == 0 || winner[i - 4] == 0)
			winner[i] = 1;
		
	}
	if (winner[N] == 1)
		printf("SK");
	else 
		printf("CY");
	return 0;
}