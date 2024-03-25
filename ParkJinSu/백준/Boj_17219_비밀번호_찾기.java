package baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Boj_17219_비밀번호_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String,String> pass = new HashMap<>();
        int n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pass.put(st.nextToken(),st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            bw.append(pass.get(br.readLine())).append("\n");
        }


        bw.flush();
        bw.close();
        br.close();

    }



}
