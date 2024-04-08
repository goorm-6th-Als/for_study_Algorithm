import java.io.*;
import java.util.*;

public class BOJ_19583_싸이버개강총회 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();
        HashSet<String> set = new HashSet<>();
        int ans = 0;

        String str;
        while ((str = br.readLine()) != null) {
            String[] arr = str.split(" ");

            if (arr[0].compareTo(S) <= 0) {
                set.add(arr[1]);
            } else if (arr[0].compareTo(E) >= 0 && arr[0].compareTo(Q) <= 0) {
                if (set.contains(arr[1])) {
                    ans++;
                    set.remove(arr[1]);
                }
            }
        }
        System.out.println(ans);
    }
}