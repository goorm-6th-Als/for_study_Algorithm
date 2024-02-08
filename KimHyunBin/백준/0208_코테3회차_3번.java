import java.io.*;
import java.util.*;

public class Main { // Boj_18258_큐 2
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//		StringTokenizer st = new StringTokenizer(br.readLine());

		List<Integer> que = new ArrayList<>();
		int head = 0;
//		N = Integer.parseInt(st.nextToken());

		int N = 2000000;
		for (int input = 0; input < N; input++) {
//			st = new StringTokenizer(br.readLine());
//			String s = st.nextToken();
			String s = "pop";
			int temp = 10;
			switch (s) {
			case "push":
//					que.add(Integer.parseInt(st.nextToken()));
				que.add(temp);
				break;
			case "pop":
				if (que.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(que.get(head++)).append("\n");
					if (head == que.size()) {
						que.clear();
						head = 0;
					}
				}
				break;
			case "size":
				sb.append(que.size()).append("\n");
				break;
			case "empty":
				sb.append(que.isEmpty() ? 1 : 0).append("\n");
				break;
			case "front":
				if (que.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(que.get(head)).append("\n");
				}
				break;
			case "back":
				if (que.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(que.get(que.size() - 1)).append("\n");
				}
				break;
			}

		}
		System.out.println(sb);
	}
}