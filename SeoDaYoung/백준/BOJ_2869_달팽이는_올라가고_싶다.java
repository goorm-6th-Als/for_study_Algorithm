import java.io.*;
import java.util.*;

public class BOJ_2869_달팽이는_올라가고_싶다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // (V - B) 높이까지 올라간 후 마지막에 A만큼 더 올라감
        int day = (V - B) / (A - B);

        // 나머지가 있다면 하루 더 필요
        if ((V - B) % (A - B) != 0) {
            day++;
        }

        System.out.println(day);
    }
}
