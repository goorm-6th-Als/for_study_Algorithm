#include <stdio.h>

//dfs ���

int map[300][300];
int visited[300][300];

int dfs(int sx,int sy, int N, int M) {
	if (sx >= M || sy >= N || map[sx][sy] == 0 || visited[sx][sy] == 2) {
		return 0; // ���� ����ų�, ���̰ų�, �̹� �湮������ ����
	}
	if (sx == M - 1 && sy == N - 1) {
		return 1; // ������ ����
	}

	visited[sx][sy] = 2; // �湮�� �� 2�� ǥ��
	return dfs(sx + 1, sy, N, M) || dfs(sx, sy + 1, N, M); // ���� ���� �̵�
}

int main() {
	int N, M;
	scanf_s("%d %d", &N, &M);
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			scanf_s("%d", &map[i][j]);
		}
	}
	int result = dfs(0, 0, N, M);
	
	if (result == 1)
		printf("Yes");
	else
		printf("No");
	return 0;
}