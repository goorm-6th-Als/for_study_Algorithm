package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_17219_비밀번호찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int addressOfSite = Integer.parseInt(st.nextToken());
        int findPasswordByAddress = Integer.parseInt(st.nextToken());
        Map<String, String> datas = new HashMap<>();

        for (int i = 0; i < addressOfSite; i++) {
            st = new StringTokenizer(br.readLine());
            datas.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < findPasswordByAddress; i++) {
            sb.append(datas.get(br.readLine())).append("\n");
        }

        System.out.println(sb);
    }
}
