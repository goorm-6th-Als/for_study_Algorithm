import java.util.*;
import java.io.*;

public class BOJ_1920_수_찾기 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        // 결과를 저장하는 StringBuilder
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 이진탐색으로 M개의 수가 N개의 정수 배열에 존재하는지 확인
            
            // 찾는 값이 존재하지 않으면 False, 존재하면 True 리턴
            // (이진탐색을 당할 배열, 찾는 값)
            int in = Arrays.binarySearch(arr, num); 

            if (in < 0) { 
                sb.append(0 + "\n");
            } else { 
                sb.append(1 + "\n");
            }
        }
        System.out.println(sb);
    }
}
