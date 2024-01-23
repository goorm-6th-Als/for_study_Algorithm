#include <stdio.h>

int main() {
	int height[9] = { 0 };
	for (int i = 0; i < 9; i++) {
		scanf_s("%d", &height[i]);
	}

	//일곱 난쟁이의 키의 합이 100

	int sum = 0;
	for (int i = 0; i < 9; i++) {
		sum += height[i];
	}

	int rem = sum - 100; //sum에서 100을 뺀 나머지
	int fake1 = 9;
	int fake2 = 9;

	//가짜 난쟁이 찾기
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

	//오름차순 정렬
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