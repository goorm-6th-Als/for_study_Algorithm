#include <stdio.h>

int main() {
	int N = 0;
	scanf("%d", &N);
	int arr[1000] = { 0 };

	for (int i = 0; i < N; i++) { //N°³ÀÇ Á¤¼ö¸¦ arr¿¡ »ðÀÔ
		scanf("%d", &arr[i]);
	}

	int chg;
	for (int i = 0; i < N; i++) {
		for (int j = i + 1; j < N; j++) {
			if (arr[i] > arr[j]) {
				chg = arr[i];
				arr[i] = arr[j];
				arr[j] = chg;
			}
		}
	}

	for (int i = 0; i < N; i++) {
		printf("%d\n", arr[i]);
	}
	return 0;
}
