import java.io.*;
import java.util.StringTokenizer;

public class Main { // Boj_2343_기타 레슨
    public static int[] arr;
    public static int N,M, answer, low, high, mid;

    // X = 게임 횟수 -> 이긴 게임 + 진게임
    // Y = 이긴 게임, Z -> Y/X 소수점은 버린다.
    // Z 가 변할 수 있는 최소한의 게임 수, 모든 게임은 이긴다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        answer = -1;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        low = 0;
        for(int tc = 0 ; tc < N; tc ++){
            int input = Integer.parseInt(st.nextToken());
            max += input;
            arr[tc] = input;
            // 블루레이가 M 개라면 input 중 큰 값이 필요.
            low = Math.max(low,arr[tc]);
        }
        // 범위는 극단적인 경우로 총 합이 들어 갈 수 있어야함.
        high = max;
        mid = 0;
        // 블루레이 크기로 탐색
        while(low <= high){
            int sum = 0;
            int cnt = 1; // 블루레이 개수
            mid = (low + high)/2;
            // 모든 경우로 담아보고, cnt 개수가 M 이랑 맞는지 확인
            for(int i = 0; i<N; i++){
                sum += arr[i]; // 한 칸에 담아주기
                if(sum > mid){ // 탐색 범위보다 크다면
                    sum = arr[i]; // sum 초기화
                    cnt += 1; // 꽉 찼으므로 개수 추가.
                }
            }
            // M 보다 개수가 같거나 적다면 범위를 위에서 줄이고
            if( cnt <= M){
                high = mid -1;
                // M보다 개수를 많이 썼다면 아래서 줄인다.
            }else{
                low = mid + 1;
            }
        }
        //찾은 최소값을 출력.
        System.out.println(low);

    }
}