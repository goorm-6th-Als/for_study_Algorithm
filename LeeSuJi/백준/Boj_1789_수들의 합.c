#include <stdio.h>

int main() {
	long long int S;
	long long int sum = 0;
	int N = 0;
	scanf_s("%lld", &S);
	for (int i = 1; i < S+1; i++) {
		sum = sum + i;
		N++;
		if (sum == S)
			break;
		else if (S - sum < i + 1) {
			sum = sum - i;
			N--;
			continue;
		}
	}
	printf("%d", N);
	return 0;
}
