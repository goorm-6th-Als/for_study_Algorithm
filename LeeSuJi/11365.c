#include <stdio.h>

int main() {
	char key[500] = { '\0' };
	scanf("%c", &key);
	int newline = 0;
	for (int i = 0; i < 500; i++) {
		if (key[i] != '\n')
			continue;
		else if (key[i] == '\n') {
			for (int j = i; j > newline; j--) {
				printf("%c", key[i]);
				newline = i + 1;
			}
		}
		else if (key[i] == 'E'&&key[i + 1] == 'N'&&key[i + 2] == 'D') {
			printf("%s", 'END');
			break;
		}
	}
	return 0;
}