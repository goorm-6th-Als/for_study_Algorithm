package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_19583_싸이버개강총회 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> set = new HashSet<>();

        int startTime = StringToTime(st.nextToken());
        int endTime = StringToTime(st.nextToken());
        int finishTime = StringToTime(st.nextToken());

        String input = null;
        int count = 0;

        while((input = br.readLine()) != null){
            st = new StringTokenizer(input);
            int nTime = StringToTime(st.nextToken());
            String name = st.nextToken();

            if (nTime <= startTime) {
                set.add(name);
            }

            if (endTime <= nTime && nTime <= finishTime) {
                if(set.contains(name)) {
                    set.remove(name);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static int StringToTime(String str) {
        StringTokenizer st = new StringTokenizer(str, ":");
        return Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
    }
}
