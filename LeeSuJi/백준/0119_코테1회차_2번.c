// 1798 ������ ��

#include <stdio.h>

int main() {
	long int S = 0;
	scanf_s("%ld", &S);

	int N = 0; //N���� �ڿ���
	long int sum = 0; //n���� �ڿ����� ��
	int i = 1;

	while (sum < S) {
		if (S - sum - i > i || S - sum - i == 0) {
			N++;
			sum = sum + i;
		}
		i++;
	}

	printf("%d", N);
	return 0;
}