#include <stdio.h>

//dfs 사용

int map[300][300];
int visited[300][300];

int dfs(int sx,int sy, int N, int M) {
	if (sx >= M || sy >= N || map[sx][sy] == 0 || visited[sx][sy] == 2) {
		return 0; // 범위 벗어나거나, 벽이거나, 이미 방문했으면 종료
	}
	if (sx == M - 1 && sy == N - 1) {
		return 1; // 목적지 도착
	}

	visited[sx][sy] = 2; // 방문한 곳 2로 표시
	return dfs(sx + 1, sy, N, M) || dfs(sx, sy + 1, N, M); // 남쪽 동쪽 이동
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