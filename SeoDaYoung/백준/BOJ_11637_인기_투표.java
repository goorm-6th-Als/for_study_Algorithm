import java.io.*;

public class BOJ_11637_인기_투표 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       int T = Integer.parseInt(br.readLine());
       int n, cnt, winner, total, max;
       int arr[]; 

       while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            cnt = 0; 
            winner = 0;
            total = 0;
            max = 0;
            arr = new int[n];

        for (int j=0; j<n; j++) {
            arr[j] = Integer.parseInt(br.readLine());
            max = Math.max(arr[j], max);
            total += arr[j];
        }
        for (int j=0; j<n; j++) { 
            if (arr[j] == max) {
                cnt++;
                winner = j;
            }
        }
        winner++;

        if (cnt > 1) // 최다 득표자가 없을 때
        bw.append("no winner\n");
        else if (total - max < max) // 최다 득표자가 과반수 득표를 했을 때
        bw.append("majority winner "+winner+"\n");
        else // 최다 득표자가 절반 이하의 득표를 했을 때
        bw.append("minority winner "+winner+"\n");
        } 
        bw.flush();
        bw.close();
        br.close();
    }
}
