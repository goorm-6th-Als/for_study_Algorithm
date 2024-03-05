import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // Boj_7795_먹을 것인가 먹힐 것인가
    public static int[] arr_A, arr_B;
    public static int A, B, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            answer = 0;
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            arr_A = new int[A];
            arr_B = new int[B];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < A; i++) {
                arr_A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < B; i++) {
                arr_B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr_B); // B 집단 오름차순 정렬

            for (int i = 0; i < A; i++) {
                int low = 0;
                int high = B - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (arr_A[i] > arr_B[mid]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                answer += low; // arr_A[i]보다 작은 arr_B 요소들의 수
            }
            System.out.println(answer);
        }
    }
}