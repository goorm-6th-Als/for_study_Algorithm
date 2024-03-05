import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main { // Boj_2776_암기왕
    public static int [] arr;
    public static int N;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= T; tc ++){ // 이걸 빼먹네
            sb = new StringBuilder();
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int now = Integer.parseInt(st.nextToken());
                int low = 0;
                int high = N-1;
                find(low,high,now);
            }
            System.out.print(sb);
        }

    }
    public static void find (int low, int high, int num){
        int mid;
        while(low <= high){
            mid = (high + low) / 2;

            if(arr[mid] == num){
                sb.append("1" + "\n");
                return;
            }else if(num < arr[mid]){
                high = mid -1;
            }else {
                low = mid + 1;
            }
        }
        sb.append("0" + "\n");
    }
}