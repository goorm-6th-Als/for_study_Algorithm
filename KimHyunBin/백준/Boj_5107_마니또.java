import java.io.*;
import java.util.*;

public class Main { // Boj_5107_마니또

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int Tc = Integer.parseInt(br.readLine());
        int tc = 1;

        while (Tc != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(tc).append(" ");

            Map<String, String> map = new HashMap<>();
            Set<String> set = new HashSet<>();
            int answer = 0;

            for (int i = 0; i < Tc; i++) {
                st = new StringTokenizer(br.readLine());
                String from = st.nextToken();
                String to = st.nextToken();
                map.put(from, to);
                set.add(from);
            }

            for (String start : set) {
                String end = map.get(start);
                // 시작부터 연결된거 쭉 확인.
                while (end != null && !end.equals(start)) {
                    end = map.get(end);
                }
                // 고리가 완성 되었다면
                if (end != null && end.equals(start)) {
                    answer++;
                    map.remove(start);
                }
            }
            sb.append(answer);
            System.out.println(sb);
            tc ++;
            Tc = Integer.parseInt(br.readLine());
        }
    }
}