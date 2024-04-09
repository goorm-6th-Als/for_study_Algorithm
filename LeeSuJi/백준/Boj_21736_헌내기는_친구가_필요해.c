#pragma warning(disable : 4996)
#include <stdio.h>

int N, M;
char map[600][601];
int visited[600][600];
int queue[600 * 600][2];
int front, rear;
int dr[] = { -1, 1, 0, 0 };
int dc[] = { 0, 0, -1, 1 };

void enqueue(int r, int c) { // 큐에 푸시
	queue[rear][0] = r;
	queue[rear][1] = c;
	rear++;
}

int* dequeue() { // 큐에서 팝
	int* item = queue[front];
	front++;
	return item;
}

int isEmpty() { // 큐가 비면 0 아니면 1 반환
	return front == rear;
}

int bfs(int r, int c) {
	front = rear = 0;
	enqueue(r, c);
	visited[r][c] = 1;
	int cnt = 0; // 헌내기 만나는 횟수

	while (!isEmpty()) {
		int* curr = dequeue();
		r = curr[0];
		c = curr[1];

		if (map[r][c] == 'P') {
			cnt++; // 헌내기 만남
		}

		for (int i = 0; i < 4; i++) { //사방 확인
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < N&&nc >= 0 && nc < M) { //범위 안에 있고
				if (visited[nr][nc] == 0 && map[nr][nc] != 'X') { // 방문한 적 없고, X가 아니면
					visited[nr][nc] = 1;
					enqueue(nr, nc);
				}
			}
		}
	}
	return cnt;
}

int main() {
	scanf("%d %d", &N, &M);
	int r = 1;
	int c = 2;
	for (int i = 0; i < N; i++) {
		scanf("%s", map[i]);
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (map[i][j] == 'I') {
				r = i;
				c = j;
				break;
			}
		}
	}
	int result = bfs(r, c);
	if (result == 0)
		printf("TT");
	else
		printf("%d", result);
	return 0;
}