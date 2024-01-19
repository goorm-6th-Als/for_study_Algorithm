#include <stdio.h>

int main() {
	int N = 0;
	double num[10000] = { 0.0000 };
	scanf_s("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf_s("%lf", &num[i]);
	}

	double large = num[0]; //가장 큰 값

	for (int i = 0; i < N; i++) {
		double result = num[i];
		if (result > large)
			large = result;
		for (int j = i + 1; j < N; j++) {
			result = result * num[j];
			if (result > large) {
				large = result;
			}
		}
	}

	printf("%.3f", large);
	return 0;
}