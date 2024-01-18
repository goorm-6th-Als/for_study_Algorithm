import java.io.*;

public class BOJ_2670_연속부분최대곱 {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    double[] arr = new double[n+1];

    double max = 0;

    for (int i =1; i <=n; i++) {
        arr[i] = Double.parseDouble(br.readLine());

        arr[i] = Math.max(arr[i], arr[i-1] * arr[i]); // 값을 비교해 더 큰 수 반환
        max = Math.max(max, arr[i]); // max값 갱신
    }
    System.out.println(String.format("%.3f", max)); // 실수형 숫자 소수점 이하 3자까지 표기
    }
}
