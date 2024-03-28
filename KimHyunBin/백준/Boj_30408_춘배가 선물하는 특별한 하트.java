import java.io.*;
import java.util.*;

public class Main { //Boj_30408_춘배가 선물하는 특별한 하트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        Set<Long> set = new HashSet<>();
        set.add(N);

        boolean flag = (N % 2 == 0) ? false : true; // 홀수 판단
        while (N > 1) {
            if (flag) { // 홀수가 나온 경우
                N /= 2;
                Long temp = N;
                set.add(temp);
                set.add(temp + 1);
            }else{ // 한번도 홀수가 안나오는 경우
                if (N % 2 == 0) {
                    N /= 2;
                    Long temp = N;
                    set.add(temp);
                } else if (N % 2 == 1) {
                    flag = true;
                    N = (N-1)/ 2;
                    Long temp = N;
                    set.add(temp);
                    set.add(temp + 1);
                }
            }
        }

        if(set.contains(M)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}