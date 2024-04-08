import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Boj_14627_닭파닭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long total = 0L;
        int[] arr;
        StringTokenizer st= new StringTokenizer(br.readLine());
        int s,c;
        s = parseInt(st.nextToken()); // 파
        c = parseInt(st.nextToken()); // 닭
        arr = new int[s];
        for (int i = 0; i < s; i++) {
            arr[i] = parseInt(br.readLine());
            total += arr[i];
        }

        int low =1;
        int high = 1000000000;
        int mid;
        int cnt=0; // 소분 된 파

        while(low <= high){
            cnt = 0;
            mid = (low + high)/2;
            for (int i = 0; i < s; i++) {
                cnt += arr[i]/mid;
            }
            if(cnt >= c) low = mid+1;
            else high = mid-1;

        }
        bw.append(total - --low * (long) c +"");

        bw.flush();;
        bw.close();
        br.close();



    }
}