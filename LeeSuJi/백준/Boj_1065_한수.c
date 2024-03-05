#include <stdio.h>

int main() {
	int N = 0;
	scanf_s("%d", &N);
	int num = 0;
	if (N <= 99)
		num = N;
	if (N > 99) {
		int hund = 0;
		int ten = 0;
		int one = 0;
		for (int i = 111; i <= N; i++) {
			hund = i / 100;
			ten = (i - (hund * 100)) / 10;
			one = i % 10;
			if (hund - ten == ten - one)
				num++;
		}
		num += 99;
	}
	printf("%d", num);
	return 0;
}