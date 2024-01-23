#include <stdio.h>

int main() {
	int T = 0;
	scanf_s("%d", &T);

	int n[499][13] = { 0 }; //0:n 1~10:득표수 11:최다득표자번호 12: 과반수여부
	int sorted[499][11] = { 0 };
	
	for (int i = 0; i < T; i++) {
		scanf_s("%d", &n[i][0]);
		for (int j = 1; j < n[i][0] + 1; j++) {
			scanf_s("%d", &n[i][j]);
		}
	}

	int large = 0; //정렬할 때 필요
	int sum = 0; //과반수 구할 때 필요

	//sorted에 값 옮기기
	for (int i = 0; i < T; i++) {
		for (int j = 1; j < n[i][0]+1; j++) {
			sorted[i][j] = n[i][j];
		}
	}

	for (int i = 0; i < T; i++) {
		for (int j = 1; j < 11; j++) {
			for (int k = 1; k < 11 - j; k++) { 
				if (sorted[i][k] > sorted[i][k + 1]) { //오름차순 정렬
					large = sorted[i][k];
					sorted[i][k] = sorted[i][k + 1];
					sorted[i][k + 1] = large;
				}
			}
		}
		if (sorted[i][10] == sorted[i][9]) {
			n[i][11] = 0; //최다득점자 없음
		}
		else if (sorted[i][10] > sorted[i][9]) {
			for (int j = 1; j < 11; j++) {
				if (sorted[i][10] == n[i][j]) { //최다득점자 번호를 11번에 저장
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