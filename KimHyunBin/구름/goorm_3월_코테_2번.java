import java.io.*;
import java.util.*;
class Main { // goorm_코테_2번
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        Map<Integer, Integer> color = new HashMap<>();
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                int now = Integer.parseInt(st.nextToken());
                sum += now;
                color.put(now, color.getOrDefault(now, 0) + 1);
            }
        }
        boolean chk = false;
        for(int key : color.keySet()){
            if(color.get(key) > (double)N * N/2){
                System.out.println(key);
                chk = true;
                break;
            }
        }
        if (!chk) {
            System.out.println(sum / (N * N));
        }
    }
}