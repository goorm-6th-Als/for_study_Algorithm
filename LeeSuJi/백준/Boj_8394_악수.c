#include <stdio.h>

int main() {
	int n;
	scanf_s("%d", &n);
	int *HS = (int*)malloc((n + 1) * sizeof(int));
	
	HS[1] = 1;
	HS[2] = 2;
	for (int i = 3; i <= n; i++) {
		HS[i] = HS[i - 1] + HS[i - 2];
	}
	printf("%d", HS[n] % 10);
	return 0;
}