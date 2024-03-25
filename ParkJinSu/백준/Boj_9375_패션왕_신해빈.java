package baekjoon;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Boj_9375_패션왕_신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st;
        int n = parseInt(br.readLine());
        int m;
        int answer;
        String type;
        Map<String, Integer>  fashion;

        for (int i = 0; i < n; i++) {
            answer=1;
            m = parseInt(br.readLine());
            fashion = new HashMap<>();
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                type = st.nextToken();
                fashion.put(type, fashion.getOrDefault(type, 1)+1);
            }
            List<String> keys = new ArrayList<>(fashion.keySet());
            for (String key : keys) {
                answer *= fashion.get(key);
            }
            bw.append(--answer+"\n");
        }






        bw.flush();
        bw.close();
        br.close();

    }




}
