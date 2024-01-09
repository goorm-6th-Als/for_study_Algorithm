#include <stdio.h>

int main() {
	struct class
	{
		char name[30];
		float num;
		char grade[3];
	}CH;
	for (int i = 0; i < 20; i++) {
		scanf("%s %f %s", &CH.name[i], &CH.num, &CH.grade);
	}
	int sum = 0;
	for(int i=0;i<20;i++){
		if (grade[i] == 'F' || 'P')
			continue;
		else {
			
		}
}