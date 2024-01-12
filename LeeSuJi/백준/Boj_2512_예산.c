#include <stdio.h>

int main() {
	int N; //지방의 수
	int request[10000] = { 0 }; //각 지방의 예산요청
	long long int M; //총 예산

	scanf_s("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf_s("%d", &request[i]);
	}
	scanf_s("%lld", &M);

	int sum_of_request = 0;
	for (int i = 0; i < N; i++) {
		sum_of_request += request[i];
	}

	int fixed[10000] = { 0 };
	long long int remain = M;
	long long int large;
	if (sum_of_request <= M) {
		//배정된 예산들 중 최댓값 출력
		for (int i = 0; i < N; i++) {
			fixed[i] = request[i];
		}
		
	}
	else {
		int avg = M / N;
		int n = N;
		for (int i = 0; i < N; i++) {
			if (request[i] <= avg) {
				fixed[i] = request[i];
				remain = remain - request[i];
				n--;
			}
		}
		avg = remain / n;
		for (int i = 0; i < N; i++) {
			if (fixed[i] == 0) {
				fixed[i] = avg;
			}
		}
	}
	large = fixed[0];
	for (int i = 1; i < N; i++) {
		if (fixed[i] > large) {
			large = fixed[i];
		}
	}
	printf("%lld", large);
	return 0;
}