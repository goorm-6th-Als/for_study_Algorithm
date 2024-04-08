#include <stdio.h>

// ���ڿ� "666"�� ���ԵǾ� �ִ��� Ȯ���ϴ� �Լ�
int has666(int num) {
	while (num > 0) {
		if (num % 1000 == 666) {
			return 1; // ã������ 1�� ��ȯ
		}
		num /= 10;
	}
	return 0; // ã�� �������� 0�� ��ȯ
}

int main() {
	int n;
	scanf_s("%d", &n);

	int count = 0;
	int num = 665; // 665 �������� �˻� ����

	while (count < n) {
		num++;
		if (has666(num)) {
			count++;
		}
	}

	printf("%d\n", num);

	return 0;
}
