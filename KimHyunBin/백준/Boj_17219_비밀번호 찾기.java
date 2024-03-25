import java.io.*;
import java.util.*;

public class Main { // Boj_17219_비밀번호 찾기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> pwd = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String code = st.nextToken();
            pwd.put(name, code);
        }

        for (int i = 0; i < M; i++) {
            String find = br.readLine();
            sb.append(pwd.get(find)).append("\n");
        }

        System.out.println(sb);
    }
}