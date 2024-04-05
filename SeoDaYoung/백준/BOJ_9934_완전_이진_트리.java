import java.io.*;
import java.util.*;

public class BOJ_9934_완전_이진_트리 {
    static int K;
    static int[] arr; // 총 노드 개수 저장
    static List<ArrayList<Integer>> list; // 층(depth)별 노드 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());
        arr = new int[(int) Math.pow(2, K) - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            list.add(new ArrayList<>());
        }

        search(0, arr.length - 1, 0);

        for (int i = 0; i < K; i++) {
            for (int j : list.get(i)) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void search(int start, int end, int depth) {
        if (depth == K) { // 현재 깊이가 트리의 깊이(K)와 같아지면 반환
            return;
        }
        int mid = (start + end) / 2; // Root, 현재 탐색 범위의 중간 인덱스
        list.get(depth).add(arr[mid]); // list에 층별 노드 저장

        search(start, mid - 1, depth + 1); // Left (시작 ~ (중간 - 1))
        search(mid + 1, end, depth + 1); // Right ((중간 + 1) ~ 끝)
    }
}
