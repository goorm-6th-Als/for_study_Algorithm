import java.io.*;
import java.util.*;

public class Main { // goorm_2회차 앞 뒤 입력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int answer = 0;
        int front_cnt = 1;
        int back_cnt = 1;
        String input = br.readLine();
        for(int i = 0; i<N; i++){
            if(input.charAt(i) == '>'){ // 앞
                back_cnt = 1;
                answer += front_cnt++ ;
            }else if(input.charAt(i) == '<'){ // 뒤
                front_cnt = 1;
                answer -= back_cnt++ ;
            }
//            System.out.println(answer);
        }

        System.out.println(answer);
    }
}