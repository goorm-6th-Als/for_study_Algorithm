//Boj 1748 �� �̾� ���� 1

#include <stdio.h>
int main() {
	int N;
	scanf_s("%d", &N);
	long long int sum = 0;
	int num = 10;
	int result = 1; //�ڸ���
	for (int i = 1; i <= N; i++) {
		if (i == num) {
			num = num * 10;
			result++;
		}
		sum = sum + result;
	}
	printf("%lld", sum);
	return 0;
}