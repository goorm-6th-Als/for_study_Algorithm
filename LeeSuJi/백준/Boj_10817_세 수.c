#include <stdio.h>

int main() {
	int a, b, c;
	scanf("%d %d %d", &a, &b, &c);
	int first, second, third;
	if (a > b) {
		first = a;
		second = b;
	}
	else if (a == b) {
		first = a;
		second = b;
	}
	else {
		first = b;
		second = a;
	}
	if (c > first) {
		third = second;
		second = first;
		first = c;
	}
	else if (c == first) {
		third = second;
		second = first;
		first = c;
	}
	else {
		if (c > second) {
			third = second;
			second = c;
		}
		else
			third = c;
	}
	printf("%d", second);
	return 0;
}
