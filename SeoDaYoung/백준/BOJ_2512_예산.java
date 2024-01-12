import java.io.*;
import java.util.*;

public class BOJ_2512_예산 {
    static int n;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 지방의 수
        n = Integer.parseInt(br.readLine()); 
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0; // 모든 예상 요청의 합
        int high = 0; // 가장 큰 예상 요청 값

        for (int i=0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            high = Math.max(high, arr[i]);
        }

        // 총 예산 입력
        int max = Integer.parseInt(br. readLine()); 

        //모든 예산 요청 합이 총 예산 이하인 경우 가장 큰 요청 값 출력 후 종료
        if (sum <= max) {
            System.out.println(high-1);
            return;
        }

        int low = 1; // 이분 탐색을 위한 시작점과 끝점 초기화

        //이분 탐색 실행
        while (low < high - 1) {
            int mid = (low + high) / 2;

            // 상한액(mid)을 기준으로 각 지방의 배정 예산 합 계산
            if (f(mid) > max) {
                high = mid; // 상한액을 낮게 설정하여 다시 탐색
            } else {
                low = mid; // 상한액을 높게 설정하여 다시 탐색
            }
            
        }

        System.out.println(low);
    }

        // 상한액을 기준으로 각 지방의 배정 예산 합 계산
        static int f(int h) {
            int total = 0;
            for (int i=0; i<n; i++) {
                total += Math.min(arr[i], h);
            }
            return total;
    }
}
