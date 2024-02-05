import java.io.*;
import java.util.*;

public class Main { // Boj_18258_큐 2
	// 리스트로 구현도 가능, 코드가 길어서 덱으로 변경
    static class ListQueue {
        private List<Integer> list;
        private int head;

        public ListQueue() {
            list = new ArrayList<>();
            head = 0;
        }

        public void push(int value) {
            list.add(value);
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(head++);
        }

        public int size() {
            return list.size() - head;
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        public int front() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(head);
        }

        public int back() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ListQueue queue = new ListQueue();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int input = 0; input < N; input++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch (s) {
                case "push":
                    queue.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(queue.pop()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(queue.front()).append("\n");
                    break;
                case "back":
                    sb.append(queue.back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}