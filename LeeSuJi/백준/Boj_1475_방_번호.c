#include <stdio.h>

int main() {
	int N = 0;
	scanf_s("%d", &N);

	int setNum = 1; //�ʿ��� ��Ʈ�� ����
	int num[10] = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}; // 0~9���� �ִ� �ϳ��� ��Ʈ�� 1�� �ʱ�ȭ
	
	while (N != 0) {
		int r = N % 10;
		if (r == 6) {
			if (num[6] == 0) {
				if (num[9] >= 1)
					num[9] = num[9] - 1;
				else {
					setNum++;		//�� ��Ʈ �߰�
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
		if (num[r] >= 1) //�ش� ���ڰ� �ִٸ�
			num[r] = num[r] - 1;	//�ϳ� ��
		else {			//�ش� ���ڰ� ���ٸ�
			setNum++;		//�� ��Ʈ �߰�
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