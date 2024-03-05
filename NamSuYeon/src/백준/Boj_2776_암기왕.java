package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.util.Arrays.binarySearch;

public class Boj_2776_암기왕 {
    static Integer[] Narr;
    static Integer[] Marr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int j = 0; j < T; j++) {
            int N = Integer.parseInt(br.readLine());
            Narr = new Integer[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                Narr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(Narr);

            int M = Integer.parseInt(br.readLine());
            Marr = new Integer[M];
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < M; i++){

                int left = 0, right = N-1, val = Integer.parseInt(st.nextToken());
                boolean find = false;

                while (left <= right){
                    int mid = (left + right)/ 2;

                    if(Narr[mid] == val){
                        find = true;
                        break;
                    }
                    else if(Narr[mid] < val){
                        left = mid + 1;
                    }else {
                        right = mid -1;
                    }
                }
                if (find){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
