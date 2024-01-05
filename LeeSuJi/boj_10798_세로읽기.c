#include <stdio.h>
#define MAX_SIZE 15

char str_read[5][MAX_SIZE];
int main() {
	int i, j;
	for (i = 0; i < 5; i++) {
		scanf("%s", str_read[i]);
	}
	for (j = 0; j < MAX_SIZE; j++) {
		for (i = 0; i < 5; i++) {
			if (str_read[i][j] == NULL)
				continue;
			else
				printf("%c", str_read[i][j]);
		}
	}
	printf("\n");
	return 0;
}
