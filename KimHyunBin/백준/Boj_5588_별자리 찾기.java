import java.util.*;
import java.io.*;


public class Main { // Boj_5588_별자리 찾기
    static int m, n;
    static HashSet<Data> stars = new HashSet<>(); // 별자리 저장
    static List<Data> list = new ArrayList<>(); // 별자리 위치
    static boolean chk = false;// 별자리 찾는 플래그

    static public class Data {
        int x;
        int y;

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
        // HashSet 객체 비교 오버라이드
        @Override
        public int hashCode() {
            return (1000000 + 1) * y + x;
        }

        @Override
        public boolean equals(Object obj) {
            Data data = (Data) obj;
            return x == data.x && y == data.y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        m = Integer.parseInt(br.readLine()); // 찾는 별자리
        int x, y;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            list.add(new Data(x, y));
        }

        n = Integer.parseInt(br.readLine()); // 별자리 맵
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            stars.add(new Data(x, y)); //해시에 저장
        }

        Data start = list.get(0); // 기준 점
        int lineX = 0, lineY = 0;

        // 전체 순환
        for (Data data : stars) {
            if (chk) break; // 찾았다면 종료
            lineX = data.x - start.x;
            lineY = data.y - start.y;
            sol(lineX, lineY); // 이동 거리로 별자리 존재하는지
        }
        System.out.println(lineX + " " + lineY);
    }

    private static void sol(int line1, int line2) {
        for (int i = 1; i < m; i++) {
            Data data = list.get(i);
            // 정한 x,y 좌표 거리 이동하면 존재하는지 확인
            if (!stars.contains(new Data(data.x + line1, data.y + line2))) {
                return;
            }
        }
        // 플래그 on => 찾음
        chk = true;

    }
}