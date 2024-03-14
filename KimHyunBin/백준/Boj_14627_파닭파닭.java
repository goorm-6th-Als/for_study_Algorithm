import java.io.*;
import java.util.*;

public class Main { // Boj_14627_파닭파닭
    public static int S,C;
    public static long [] g_Onion;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        long sum = 0;
        g_Onion = new long [S];
        for(int i = 0; i<S; i++){
            int temp = Integer.parseInt(br.readLine());
            g_Onion[i] = temp;
            sum += temp;
        }

        long low = 1;
        long high = 1000000000;
        long mid = (low + high)/ 2;
        long result = 0;
        int g_Onion_cnt = 0;
        // 크기를 mid 로 나누어 개수가 맞을때까지 반복.
        while(low <= high){
            mid = (low + high)/ 2;
            g_Onion_cnt = 0;
            for(int i = 0; i<S; i++){
                g_Onion_cnt += g_Onion[i] / mid;
            }
            // 개수가 맞고 mid 가 최대값까지 탐색
            if(g_Onion_cnt >= C){
                result = Math.max (result, mid);
                low = mid + 1;
            }else{
                high = mid - 1;
            }

        }
        // 남는 파 -> 라면에 쏚 ^<^
        System.out.println(sum - (result * C));
    }
}