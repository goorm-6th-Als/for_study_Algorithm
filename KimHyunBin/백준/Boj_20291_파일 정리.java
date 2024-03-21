import java.io.*;
import java.util.*;

public class Main { // Boj_20291_파일 정리

    //확장자 이름, 해당하는 파일 개수 출력
    //확장자가 여러개면 사전순으로 출력하기.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> file = new HashMap<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine(),".");
            st.nextToken();
            String name = st.nextToken();

            file.put(name, file.getOrDefault(name, 0) + 1);
        }
        List<String> keySet = new ArrayList<>(file.keySet());

        Collections.sort(keySet);

        for(String key : keySet){
            sb.append(key).append(" ").append(file.get(key)).append("\n");
        }

        System.out.println(sb.toString());

    }
}