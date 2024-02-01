#include <stdio.h>

int main() {
	int N = 0;
	scanf_s("%d", &N);

	int num = 0;
	int nums[1000] = { 0 };
	nums[0] = N;

	while (N > 1) {
		if (N % 3 == 0) {
			N = N / 3;
		}
		else if (N % 2 == 0) {
			N = N / 2;
		}
		else {
			N = N - 1;
		}
		num++;
		nums[num] = N;
	}
	printf("%d\n", num);
	for (int i = 0; i <= num; i++) {
		printf("%d ", nums[i]);
	}
}