//Boj 2563 »öÁ¾ÀÌ
#include <stdio.h>

int main() {
	int n = 0;
	scanf_s("%d", &n);
	int paper[100][100] = { 0 };
	int left = 0;
	int bottom = 0;
	for (int i = 0; i < n; i++) {
		scanf_s("%d %d", &left, &bottom);
		for (int j = left; j < left + 10; j++) {
			for (int k = bottom; k > bottom - 10; k--) {
				if (paper[j][k] == 0)
					paper[j][k] = 1;
			}
		}
	}
	int area = 0;
	for (int i = 0; i < 100; i++) {
		for (int j = 0; j < 100; j++) {
			if (paper[i][j] == 1)
				area++;
		}
	}
	printf("%d", area);
	return 0;
}