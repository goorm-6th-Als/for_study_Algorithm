#include <stdio.h>

int main() {
	int height[9] = { 0 };
	for (int i = 0; i < 9; i++) {
		scanf_s("%d", &height[i]);
	}

	//�ϰ� �������� Ű�� ���� 100

	int sum = 0;
	for (int i = 0; i < 9; i++) {
		sum += height[i];
	}

	int rem = sum - 100; //sum���� 100�� �� ������
	int fake1 = 9;
	int fake2 = 9;

	//��¥ ������ ã��
	for (int i = 0; i < 8; i++) {
		for (int j = i + 1; j < 9; j++) {
			if (height[i] + height[j] == rem) {
				fake1 = i;
				fake2 = j;
				height[i] = 0;
				height[j] = 0;
				break;
			}
		}
		if (fake1 != 9)
			break;
	}

	//�������� ����
	int large = 0;
	for (int i = 0; i < 8; i++) {
		for (int j = i + 1; j < 9; j++) {
			if (height[i] > height[j]) {
				large = height[i];
				height[i] = height[j];
				height[j] = large;
			}
		}
	}

	for (int i = 2; i < 9; i++) {
		printf("%d\n", height[i]);
	}
	return 0;
}