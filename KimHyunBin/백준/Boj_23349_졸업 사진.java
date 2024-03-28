import java.io.*;
import java.util.*;

public class Main { // Boj_23349_졸업 사진
    static class PlaceTime implements Comparable<PlaceTime> {
        String place;
        int start;

        PlaceTime(String place, int start) {
            this.place = place;
            this.start = start;
        }

        @Override
        public int compareTo(PlaceTime o) {
            if (!this.place.equals(o.place)) {
                return this.place.compareTo(o.place); // 알파뱃 정렬
            }
            return Integer.compare(this.start, o.start); // 가장 빠른 시간
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Map<String, int[]> map = new HashMap<>();
        Set<String> nameSet = new HashSet<>();
        int max = -1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String place = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (nameSet.contains(name)) continue;
            nameSet.add(name);
            int[] counts = map.computeIfAbsent(place, k -> new int[50001]);
            for (int idx = start; idx < end; idx++) {
                counts[idx]++;
                max = Math.max(max, counts[idx]);
            }
        }

        List<PlaceTime> haveMax_List = new ArrayList<>();
        for (String place : map.keySet()) {
            int[] counts = map.get(place);
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] == max) {
                    haveMax_List.add(new PlaceTime(place, i));
                    break;
                }
            }
        }

        Collections.sort(haveMax_List);
        PlaceTime now_Place = haveMax_List.get(0);
        int end = (findEnd(map.get(now_Place.place), now_Place.start, max));
        System.out.println(now_Place.place + " " + now_Place.start + " " + end);
    }

    private static int findEnd(int[] counts, int start, int max) {
        int end = start;
        while (end < counts.length && counts[end] == max) {
            end++;
        }
        return end;
    }
}
