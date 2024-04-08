//Boj 2579 계단 오르기
#include <stdio.h>

int main() {
	int n = 0;
	scanf_s("%d", &n);
	int score[301] = { 0 };
	
	for (int i = 1; i < n+1; i++) {
		scanf_s("%d", &score[i]);
	}

	int sum = 0; //총점
	int cur = 0; //현재 위치
	int visit[301] = { 0 };
	visit[0] = 1;

	while (cur < n) {
		if (cur == 0) {
			if (score[3] <= score[4]) {
				visit[1] = 1;
				sum = sum + score[1];
				cur = 1;
			}
			else {
				visit[2] = 1;
				sum = sum + score[2];
				cur = 2;
			}
			continue;
		}
		if (cur + 2 == n) {
			sum = sum + score[cur + 2];
			cur = cur + 2;
		}
		
		else if (score[cur + 1] >= score[cur + 2] ) {
			if (visit[cur - 1] == 0) {
				visit[cur + 1] = 1;
				sum = sum + score[cur + 1];
				cur = cur + 1;
			}
			
		}
		else if (score[cur + 1] < score[cur + 2]) {
			visit[cur + 2] = 1;
			sum = sum + score[cur + 2];
			cur = cur + 2;
		}
	}
	printf("%d", sum);
	return 0;
}
