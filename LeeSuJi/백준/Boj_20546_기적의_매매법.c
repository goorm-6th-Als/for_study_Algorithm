#include <stdio.h>

int main() {
	int money = 0;
	scanf_s("%d", &money);
	int MD[14] = { 0 };
	for (int i = 0; i < 14; i++) {
		scanf_s("%d", &MD[i]);
	}

	//자산: 현금 + 1월 14일의 주가 X 주식 수

	//준현
	int Jmoney = money;
	int Jstock = 0;

	for (int i = 0; i < 14; i++) {
		while (Jmoney - MD[i] >= 0) {
			Jmoney = Jmoney - MD[i];
			Jstock++;
		}
	}

	//성민
	int Smoney = money;
	int Sstock = 0;

	for (int i = 3; i < 14; i++) {
		if ((MD[i - 3] > MD[i - 2]) && (MD[i - 2] > MD[i - 1]) && (MD[i - 1] > MD[i])) {
			while (Smoney - MD[i] >= 0) {
				Smoney = Smoney - MD[i];
				Sstock++;
			}
		}
		else if ((MD[i - 3] < MD[i - 2]) && (MD[i - 2] < MD[i - 1]) && (MD[i - 1] < MD[i])) {
			while (Sstock > 0) {
				Smoney = Smoney + MD[i];
				--Sstock;
			}
		}
	}

	char BNP[4] = "BNP";
	char TIMING[7] = "TIMING";
	char SAME[9] = "SAMESAME";
	if (Jmoney + MD[13] * Jstock > Smoney + MD[13] * Sstock)
		printf("%s", BNP);
	else if (Jmoney + MD[13] * Jstock == Smoney + MD[13] * Sstock)
		printf("%s", SAME);
	else
		printf("%s", TIMING);
	return 0;
}