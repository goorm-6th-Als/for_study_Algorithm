import java.io.*;
import java.util.*;

public class BOJ_1654_랜선_자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        long max = 0;
        long result = 0;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        result = binarySearch(arr, N, max);
        System.out.println(result);
    }

    public static long binarySearch(int[] arr, int N, long max) {
        long min = 1;
        long mid = 0;
        long result = 0; // result = N개를 만들 수 있는 최대 길이

        while (min <= max) {
            mid = (min + max) / 2;
            long cnt = 0;

            for (int num : arr) {
                cnt += num / mid; // cnt = 만들어지는 랜선의 수
            }

            if (cnt < N) {
                max = mid - 1;
            } else {
                min = mid + 1;
                result = mid;
            }
        }
        return result;
    }
}
