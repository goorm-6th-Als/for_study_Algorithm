package baekjoon;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Boj_20291_파일_정리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String,Integer> extension = new HashMap<>();
        int n = parseInt(st.nextToken());
        String file;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            file = st.nextToken();
            //file = br.readLine().split("\\.")[1];
            extension.put(file, extension.getOrDefault(file, 0)+1);
        }
        List<String> sort = new ArrayList<>(extension.keySet());
        Collections.sort(sort);
        for(String fileName : sort){
            bw.append(fileName).append(" ").append(extension.get(fileName)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }



}
