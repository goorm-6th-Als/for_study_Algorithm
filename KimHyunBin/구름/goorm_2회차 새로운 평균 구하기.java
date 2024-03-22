import java.io.*;
import java.util.*;

public class Main { // goorm_2회차 새로운 평균 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // 바꾸는 수

        int sum = 0;
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
            sum += tmp;
        }
        int M = sum / N;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int idx = Integer.parseInt(st.nextToken()) - 1; // 수정할 인덱스
            if (arr[idx] >= M) {
                continue;
            }
            sum += M - arr[idx];
        }
        int answer = sum / N;
        System.out.println(answer);
    }
}