#include <stdio.h>

int main() {
	int T = 0;
	scanf_s("%d", &T);

	int n[499][13] = { 0 }; //0:n 1~10:��ǥ�� 11:�ִٵ�ǥ�ڹ�ȣ 12: ���ݼ�����
	int sorted[499][11] = { 0 };
	
	for (int i = 0; i < T; i++) {
		scanf_s("%d", &n[i][0]);
		for (int j = 1; j < n[i][0] + 1; j++) {
			scanf_s("%d", &n[i][j]);
		}
	}

	int large = 0; //������ �� �ʿ�
	

	//sorted�� �� �ű��
	for (int i = 0; i < T; i++) {
		for (int j = 1; j < n[i][0]+1; j++) {
			sorted[i][j] = n[i][j];
		}
	}
	
	

	for (int i = 0; i < T; i++) {
		int sum = 0; //���ݼ� ���� �� �ʿ�
		for (int j = 1; j < 11; j++) {
			for (int k = 1; k < 11 - j; k++) { 
				if (sorted[i][k] > sorted[i][k + 1]) { //�������� ����
					large = sorted[i][k];
					sorted[i][k] = sorted[i][k + 1];
					sorted[i][k + 1] = large;
				}
			}
		}
		if (sorted[i][10] == sorted[i][9]) {
			n[i][11] = 0; //�ִٵ����� ����
		}
		else if (sorted[i][10] > sorted[i][9]) {
			for (int j = 1; j < 11; j++) {
				if (sorted[i][10] == n[i][j]) { //�ִٵ����� ��ȣ�� 11���� ����
					n[i][11] = j;
					break; 
				}
			}
			for (int j = 1; j < n[i][0] + 1; j++) {
				sum += n[i][j];
			}
			if (sorted[i][10] > sum / 2)
				n[i][12] = 1;
		}
		if (n[i][11] == 0) {
			printf("no winner\n");
		}
		else if (n[i][11] != 0 && n[i][12] == 1)
			printf("majority winner %d\n", n[i][11]);
		else
			printf("minority winner %d\n", n[i][11]);
	}
	return 0;
}