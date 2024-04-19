#include <stdio.h>

int N, S;
int nums[20];
int count = 0;

// index: ���� ó�� ���� ������ �ε���
void subsetSum(int index, int sum) {
	if (index == N) {
		if (sum == S) {
			count++;
		}
		return; // ��� ���Ҹ� ���� return
	}
	
	subsetSum(index + 1, sum + nums[index]); // ���� ��Ҹ� sum�� ����
	subsetSum(index + 1, sum); // ���� ��Ҹ� sum�� ����x
}

int main() {
	scanf_s("%d %d", &N, &S);
	for (int i = 0; i < N; i++) {
		scanf_s("%d", &nums[i]);
	}

	subsetSum(0, 0);

	if (S == 0) {
		count--;
	}

	printf("%d", count);
	return 0;
}