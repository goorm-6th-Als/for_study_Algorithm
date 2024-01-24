#include <stdio.h>

// 숫자에 "666"이 포함되어 있는지 확인하는 함수
int has666(int num) {
	while (num > 0) {
		if (num % 1000 == 666) {
			return 1; // 찾았으면 1을 반환
		}
		num /= 10;
	}
	return 0; // 찾지 못했으면 0을 반환
}

int main() {
	int n;
	scanf_s("%d", &n);

	int count = 0;
	int num = 665; // 665 다음부터 검사 시작

	while (count < n) {
		num++;
		if (has666(num)) {
			count++;
		}
	}

	printf("%d\n", num);

	return 0;
}
