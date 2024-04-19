import java.io.*;
import java.util.*;

public class BOJ_1182_부분수열의_합 {
    static int N, S;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0, 0);

        if (S == 0) {
            System.out.println(answer - 1);
        } else {
            System.out.println(answer);
        }
    }

    public static void DFS(int depth, int sum) {
        if (depth == N) {
            if (sum == S) answer++;
            return;
        }
        // 원소의 두 경로, 포함과 비포함
        DFS(depth + 1, sum + arr[depth]);
        DFS(depth + 1, sum);
    }
}
