import java.io.*;
import java.util.*;

public class Main { // Boj_2110_공유기 설치
    public static int N, C; // 집, 공유기 개수
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        // 최소 거리를 기준으로 늘려가면?
        // 개수가 C를 만족하면서 가장 크면 정답.
        int low = 1;
        int high = arr[arr.length - 1];
        while (low <= high) {
            int mid = (low + high) / 2;
            int now = 0; // 무조건 0은 포함
            int cnt = 1;
            for (int i = 0; i < N; i++) {
                if (arr[i] - arr[now] >= mid) {
                    cnt ++;
                    now = i;
                }
            }
            // cnt 가 C보다 같거나 크다면 왼쪽 땡기기
            // 만족하기 직전까지 찾음
            if( cnt >= C){
                low = mid +1;
            }else{
                high = mid -1;
            }

        }
        System.out.println(low - 1);
    }
}