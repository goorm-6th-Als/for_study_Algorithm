import java.io.*;
import java.util.*;

public class BOJ_20291_파일_정리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>(); // 확장자 개수 저장
        ArrayList<String> arr = new ArrayList<>(); // 확장자 목록 저장

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            String extension = st.nextToken();

            if (!map.containsKey(extension)) {
                arr.add(extension);
                map.put(extension, 1);
            } else {
                map.put(extension, map.get(extension) + 1);
            }
        }
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();

        for (String str : arr) {
            sb.append(str).append(' ').append(map.get(str)).append('\n');
        }
        System.out.println(sb);
    }
}
