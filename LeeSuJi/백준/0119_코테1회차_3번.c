// 22869 징검다리 건너기 (small)

#include <stdio.h>
#include <math.h>

int main() {
	int N, K = 0;
	scanf_s("%d %d", &N, &K);

	int A[5000] = { 0 };
	for (int i = 0; i < N; i++) {
		scanf_s("%d", &A[i]);
	}

	int result = 0; //0:실패 1:성공
	int i = 0;
	int j = i + 1;

	while (i < N - 1) {
		j = i + 1;
		while (j < N) {
			int strength = (j - i)*(1 + abs(A[i] - A[j]));
			if (strength <= K) {
				i = j;
				break;
			}
			j++;
		}
		if (i == N - 1) {
			result = 1;
			break;
		}
		else if (j == N && i != N - 1) {
			result = 0;
			break;
		}
		
	}

	char result1[4] = "YES";
	char result0[3] = "NO";

	if (result == 0)
		printf("%s", result0);
	else
		printf("%s", result1);
	return 0;
}