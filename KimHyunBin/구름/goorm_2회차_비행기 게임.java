import java.io.*;
import java.util.*;

public class Main { // 구름_비행기 게임
    public static final String crush = "CRASHED";
    public static final String range_over = "OUT";
    public static int [] dx = {-1,1,0,0};
    public static int [] dy = {0,0,1,-1};
    public static char [] command = {'L','R','U','D'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        Long N = Long.parseLong(st.nextToken()); // 장애물 수
        Long M = Long.parseLong(st.nextToken()); // 가로 길이
        Long L = Long.parseLong(st.nextToken()); // 세로 높이
        Long [] arr = new Long[(int) (N+1)];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){ // 장애물 입력
            Long H = Long.parseLong(st.nextToken());
            arr[i]= H;
        }

        //현재 좌표 입력
        st = new StringTokenizer(br.readLine());
        Long X = Long.parseLong(st.nextToken());
        Long Y = Long.parseLong(st.nextToken());

        String cmd = br.readLine();
        // 명령어 처리
        for(int i = 0; i<cmd.length(); i++){
            char now_cmd = cmd.charAt(i);
            for(int j = 0; j<4; j++){
                if(now_cmd == command[j]){
                    Long n_X = X + dx[j];
                    Long n_Y = Y + dy[j];
                    if(n_X > N || n_X < 1 || n_Y > L || n_Y < 0 ){
                        System.out.println(range_over);
                        return;
                    }

                    if(arr[Math.toIntExact(n_X)] > n_Y){
                        System.out.println(crush);
                        return;
                    }

                    X = n_X;
                    Y = n_Y;
                    break;
                }
            }
        }
        System.out.println(X + " " + Y);
    }

}