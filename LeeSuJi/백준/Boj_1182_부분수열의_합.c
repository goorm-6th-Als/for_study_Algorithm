#include <stdio.h>

int N, S;
int nums[20];
int count = 0;

// index: 현재 처리 중인 원소의 인덱스
void subsetSum(int index, int sum) {
	if (index == N) {
		if (sum == S) {
			count++;
		}
		return; // 모든 원소를 돌면 return
	}
	
	subsetSum(index + 1, sum + nums[index]); // 현재 요소를 sum에 포함
	subsetSum(index + 1, sum); // 현재 요소를 sum에 포함x
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