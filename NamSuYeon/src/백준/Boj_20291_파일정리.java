package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_20291_파일정리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> files = new HashMap<>();
        int size = Integer.parseInt(br.readLine());

        for(int i = 0; i<size; i++) {
            String input = br.readLine().split("\\.")[1];
            files.put(input, files.getOrDefault(input, 0) + 1);
        }

        List<String> keys = new ArrayList<>(files.keySet());

        Collections.sort(keys);

        for(int i = 0; i<keys.size(); i++){
            sb.append(keys.get(i)).append(" ").append(files.get(keys.get(i))).append("\n");
        }

        System.out.print(sb);
    }
}
