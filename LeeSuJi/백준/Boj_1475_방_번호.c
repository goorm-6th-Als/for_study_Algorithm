#include <stdio.h>

int main() {
	int N = 0;
	scanf_s("%d", &N);

	int setNum = 1; //필요한 세트의 개수
	int num[10] = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}; // 0~9까지 있는 하나의 세트를 1로 초기화
	
	while (N != 0) {
		int r = N % 10;
		if (r == 6) {
			if (num[6] == 0) {
				if (num[9] >= 1)
					num[9] = num[9] - 1;
				else {
					setNum++;		//한 세트 추가
					for (int k = 0; k < 10; k++) {
						num[k] = num[k] + 1;
					}
					num[r] = num[r] - 1;
				}
			}
			else {
				num[r] = num[r] - 1;
			}
			N = N / 10;
			continue;
		}
		if (r == 9) {
			if (num[9] == 0) {
				if (num[6] >= 1)
					num[6] = num[6] - 1;
				else {
					setNum++;
					for (int k = 0; k < 10; k++) {
						num[k] = num[k] + 1;
					}
					num[r] = num[r] - 1;
				}
			}
			else {
				num[r] = num[r] - 1;
			}
			N = N / 10;
			continue;
		}
		if (num[r] >= 1) //해당 숫자가 있다면
			num[r] = num[r] - 1;	//하나 뺌
		else {			//해당 숫자가 없다면
			setNum++;		//한 세트 추가
			for (int k = 0; k < 10; k++) {
				num[k] = num[k] + 1;
			}
			num[r] = num[r] - 1;
		}
		N = N / 10;
	}
	printf("%d", setNum);
	return 0;
}