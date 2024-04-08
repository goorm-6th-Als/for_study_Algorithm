import java.io.*;

public class BOJ_1065_한수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int hund=0;
        int ten=0;
        int one = 0;

        for (int i=1; i<=n; i++) {
            if (i/100 == 0) 
            cnt++;
             else if (i/1000 == 0) {
                hund = i/100;
                ten = (i%100)/10;
                one = i%10;

                if (hund-ten == ten-one) 
                cnt++;
                
            }
        }
        System.out.println(cnt);
    }
}
