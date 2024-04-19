import java.io.*;
import java.util.*;

public class Main { // Boj_1182_부분수열의 합
    static int N, M, answer;
    static int[] arr;
 // 연속적이어야 하는줄..
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        logic(0,0, false);
        System.out.println(answer);
    }

    public static void logic(int idx, int sum, boolean flag) {
        if (idx == N) {
            if (sum == M && flag) {
                answer++;
            }
            return;
        }

        logic(idx + 1, sum + arr[idx], true);
        logic(idx + 1, sum, flag);
    }
}