#include <stdio.h>
#include <string.h>
#include <ctype.h>

void swap(char *xp, char *yp) {
	char temp = *xp;
	*xp = *yp;
	*yp = temp;
}

int main() {
	int N = 0;
	scanf_s("%d", &N);
	char num[50][51];
	for (int i = 0; i < N; i++) {
		scanf_s("%s", num[i]);
	}

	//문자열의 길이가 짧은 순으로 정렬
	
	for (int i = 0; i < N - 1; i++) {
		for (int j = 0; j < N - i - 1; j++) {
			if (strlen(num[j]) > strlen(num[j + 1])) {
				swap(num[j], num[j + 1]);
			}
		}
	}

	//문자열의 길이가 같으면 숫자합 비교 작은 수가 앞으로
	for (int i = 0; i < N - 1; i++) {
		for (int j = 0; j < N - i - 1; j++) {
			if (strlen(num[j]) == strlen(num[j + 1])) {
				int sum1 = 0;
				for (int k = 0; num[j][k] != '\0'; k++) {
					if (isdigit(num[j][k])) {
						sum1 += num[j][k];
					}
				}
				int sum2 = 0;
				for (int k = 0; num[j + 1][k] != '\0'; k++) {
					if (isdigit(num[j + 1][k])) {
						sum2 += num[j + 1][k];
					}
				}
				if (sum1 > sum2) {
					swap(num[j], num[j + 1]);
				}
				else if (sum2 > sum1) {
					swap(num[j + 1], num[j]);
				}
				else {
					for (int k = 0; num[j][k] != '\0'; k++) {
						if (num[j][k] > num[j + 1][k])
							swap(num[j], num[j + 1]);
					}
				}
			}
		}
	}
	for (int i = 0; i < N; i++) {
		printf("%s\n", num[i]);
	}
	return 0;
}