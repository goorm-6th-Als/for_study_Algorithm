#include <stdio.h>

int main() {
	int A = 0;
	int B = 0;
	scanf_s("%d %d", &A, &B);
	int sum = 0;

	while (B > A) {
		if (B % 2 == 0) {
			B = B / 2;
		}
		else {
			if (B % 10 == 1)
				B = B / 10;
			else
				break;
		}
		sum++;
	}
	if (B == A)
		printf("%d", sum + 1);
	else
		printf("-1");
	return 0;
}