#include <stdio.h>

int main() {
	int N; //������ ��
	int request[10000] = { 0 }; //�� ������ �����û
	long long int M; //�� ����

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
		//������ ����� �� �ִ� ���
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