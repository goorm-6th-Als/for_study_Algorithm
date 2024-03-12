import java.io.*;
import java.util.*;

public class BOJ_14627_파닭파닭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken()); // 파의 개수
        int C = Integer.parseInt(st.nextToken()); // 주문 받은 파닭의 수
        int[] chicken = new int[S];
        long sum = 0;

        for (int i = 0; i < S; i++) {
            chicken[i] = Integer.parseInt(br.readLine());
            sum += chicken[i]; // 파의 전체 길이
        }
        long left = 1;
        long right = 1000000000;

        while (left <= right) {
            long mid = (left + right) / 2;
            int cnt = 0; // 현재 길이로 만들 수 있는 파닭 수

            for (int i = 0; i < S; i++) {
                cnt += chicken[i] / mid;
            }
            if (cnt >= C) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(sum - right * (long) C);
    }
}
