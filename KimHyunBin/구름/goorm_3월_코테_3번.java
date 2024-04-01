import java.io.*;
import java.util.*;

class Main { // goorm_코테_2번

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 길이
        int M = Integer.parseInt(st.nextToken()); // 교환 횟수

        List<String> A = new ArrayList<>();
        List<String> B = new ArrayList<>();
        Map<String, Integer> positionsA = new HashMap<>();
        Map<String, Integer> positionsB = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = st.nextToken();
            A.add(s);
            positionsA.put(s, i);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = st.nextToken();
            B.add(s);
            positionsB.put(s, i);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String s_1 = st.nextToken();
            String s_2 = st.nextToken();
            String initialA = null;
            String initialB = null;

            if(A.contains(s_1) && B.contains(s_2)) {
                initialA = s_1;
                initialB = s_2;
            }

            // 각자 문자가 각각의 리스트에 존재하면 swap
            if(positionsA.containsKey(initialA) && positionsB.containsKey(initialB)) {
                int indexA = positionsA.get(initialA);
                int indexB = positionsB.get(initialB);

                A.set(indexA, initialB);
                B.set(indexB, initialA);

                positionsA.put(initialB, indexA);
                positionsB.put(initialA, indexB);
            }
            System.out.println();
            System.out.println(A);
            System.out.println(B);

        }
        Collections.sort(A); // 단순히 알파뱃 순서로 정렬 출력이었구나..
        StringBuilder sb = new StringBuilder();
        for(String temp : A){
            sb.append(temp).append(" ");
        }

        System.out.println(sb);
    }
}
