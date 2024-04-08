import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Integer,String> before = new HashMap<>();
        Map<String,Integer> after = new HashMap<>();

        for(int i=1; i<=N; i++){
            before.put(i, br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            after.put(br.readLine(),i);
        }

        Set<String> passing = new HashSet<>();
        for (int beforeNum = 1; beforeNum < N; beforeNum++) {

            String beforeCarName = before.get(beforeNum); //터널 진입전 차 순서대로 이름 
            int afterOne = after.get(beforeCarName);  // 그 차의 터널후 순서

            for(int afterNum =beforeNum+1; afterNum<=N; afterNum++){
                String afterCarName = before.get(afterNum); // 바로 뒤에 있던 차의 터널 전 이름
                int afterTwo = after.get(afterCarName);  // 그 차의 터널 후 순서

                if(afterOne>afterTwo){
                    passing.add(afterCarName);
                }
            }

        }
        System.out.println(passing.size());

    }
}