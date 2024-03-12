import java.io.*;
import java.util.*;

public class Main { // Boj_2792_보석 상자
    public static int N, M;
    public static int[] gem;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 아이들
        M = Integer.parseInt(st.nextToken()); // 보석 종류
        gem = new int[M];
        for (int i = 0; i < M; i++) {
            int temp = Integer.parseInt(br.readLine());
            gem[i] = temp;
        }

        long low = 1;
        long high = 1_000_000_000;
        long mid = 0;
        int gem_cnt = 0;
        // 보석 수 % 사람 != 0 이면 + 1 을 해줘야함.
        while (low <= high) {
            mid = (low + high) / 2;
            gem_cnt = 0;
            for (int i = 0; i < M; i++) {
                long temp = gem[i] / mid;
                if (gem[i] % mid != 0) {
                    gem_cnt += temp + 1;
                } else {
                    gem_cnt += temp;
                }
            }
            // 개수 맞추고 최소값이므로 low 값이 정답.
            if (gem_cnt <= N) {
                high = mid - 1;
            } else{
                low = mid + 1;
            }

        }
        System.out.println(low);
    }
}