import java.io.*;
import java.util.*;

public class Main { // goorm_1회차_막대 도형
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int [] arr = new int [N];

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 2 * N + arr[0] + arr[N-1];

        for(int i = 0; i<N-1; i++){
           int now =  arr[i];
           int next = arr[i+1];
           if(now > next){
               answer += now - next;
           }else if(next > now){
               answer += next -now;
           }
        }

        System.out.println(answer);

    }
}