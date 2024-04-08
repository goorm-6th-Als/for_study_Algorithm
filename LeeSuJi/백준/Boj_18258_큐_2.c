#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_SIZE 2000000

typedef struct {
	int front;
	int back;
	int data[MAX_SIZE];
} Queue;

void push(Queue* q, int x) {
	q->data[q->back] = x;
	q->back = (q->back + 1) % MAX_SIZE;
}

int pop(Queue* q) {
	if (q->front == q->back) {
		return -1; // 큐가 비어있음
	}

	int result = q->data[q->front];
	q->front = (q->front + 1) % MAX_SIZE;
	return result;
}

int size(Queue* q) {
	return (q->back - q->front + MAX_SIZE) % MAX_SIZE;
}

int empty(Queue* q) {
	return q->front == q->back ? 1 : 0;
}

int front(Queue* q) {
	return empty(q) ? -1 : q->data[q->front];
}

int back(Queue* q) {
	return empty(q) ? -1 : q->data[(q->back - 1 + MAX_SIZE) % MAX_SIZE];
}

int main() {
	int N;
	scanf("%d", &N);

	Queue q;
	q.front = 0;
	q.back = 0;

	for (int i = 0; i < N; i++) {
		char command[10];
		scanf("%s", command);

		if (strcmp(command, "push") == 0) {
			int x;
			scanf("%d", &x);
			push(&q, x);
		}
		else if (strcmp(command, "pop") == 0) {
			printf("%d\n", pop(&q));
		}
		else if (strcmp(command, "size") == 0) {
			printf("%d\n", size(&q));
		}
		else if (strcmp(command, "empty") == 0) {
			printf("%d\n", empty(&q));
		}
		else if (strcmp(command, "front") == 0) {
			printf("%d\n", front(&q));
		}
		else if (strcmp(command, "back") == 0) {
			printf("%d\n", back(&q));
		}
	}

	return 0;
}
