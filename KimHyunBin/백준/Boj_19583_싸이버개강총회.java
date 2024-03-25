import java.io.*;
import java.util.*;

public class Main { // Boj_19583_싸이버개강총회

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        String e = st.nextToken();
        String f = st.nextToken();

        int s_time = Time(s);
        int e_time = Time(e);
        int f_time = Time(f);

        HashSet<String> before = new HashSet<>();
        HashSet<String> after = new HashSet<>();
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            st = new StringTokenizer(line);
                int time = Time(st.nextToken());
                String name = st.nextToken();
                if (time <= s_time) {
                    before.add(name);
                } else if (e_time <= time && time <= f_time) {
                    if (before.contains(name)) {
                        after.add(name);
                    }
            }
        }
        System.out.println(after.size());
    }

    public static int Time(String s) {
        StringTokenizer st = new StringTokenizer(s, ":");
        int h = Integer.parseInt(st.nextToken()) * 60;
        int m = Integer.parseInt(st.nextToken());
        return h + m;
    }
}