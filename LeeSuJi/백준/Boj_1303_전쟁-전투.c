#pragma warning(disable : 4996)
#include <stdio.h>

int N, M;
int visit[100][100] = { 0 };
int queue[100*100][2];
char map[100][100];
int front, rear;
int dr[4] = { -1, 1, 0, 0 };
int dc[4] = { 0, 0, -1, 1 };

void enqueue(int r, int c) {
	queue[rear][0] = r;
	queue[rear][1] = c;
	rear++;
}

int* dequeue() {
	int*item = queue[front];
	front++;
	return item;
}

int isEmpty() {
	if (front == rear)
		return 1;
	else
		return 0;
}

int bfs(int r, int c) {
	front = 0;
	rear = 0;
	enqueue(r, c);
	visit[r][c] = 1;
	int cnt = 1;

	while (!isEmpty()) {
		int* curr = dequeue();
		r = curr[0];
		c = curr[1];
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
				if (map[r][c] == map[nr][nc]) {
					if (visit[nr][nc] == 0) {
						if (nr < M&&nc < N&&nr >= 0&&nc >= 0) {
							visit[nr][nc] = 1;
							enqueue(nr, nc);
							cnt++;
						}
					}
				}
		}
	}
	return cnt * cnt;
}

int main() {
	scanf("%d %d", &N, &M);
	for (int i = 0; i < M; i++) {
		scanf("%s", map[i]);
	}
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			printf("%c", map[i][j]);
		}
		printf("\n");
	}

	int w = 0;
	int b = 0;
	
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			if (visit[i][j] == 0) {
				if (map[i][j] == 'W') {
					w = w + bfs(i, j);
				}
				else
					b = b + bfs(i, j);
			}
		}
	}
	/*
	printf("\n");
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			printf("%d", visit[i][j]);
		}
		printf("\n");
	}
	*/
	printf("%d %d", w, b);
	return 0;
	

}