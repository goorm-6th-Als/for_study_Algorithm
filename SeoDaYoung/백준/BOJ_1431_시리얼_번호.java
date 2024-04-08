import java.io.*;
import java.util.*;

public class BOJ_1431_시리얼_번호 {
    static int n;
    static String[] serial;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        serial = new String[n];

        for (int i = 0; i < n; i++) {
            serial[i] = br.readLine();
        }

        Arrays.sort(serial, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if (o1.length() < o2.length()) // 기준값이 비교값보다 작으면 -1 리턴
                    return -1;

                else if (o1.length() == o2.length()) { // 기준값과 비교값이 같으면
                    if (sum(o1) == sum(o2)) {
                        return o1.compareTo(o2); // 둘을 비교해 사전순으로 정렬
                    } else {
                        return Integer.compare(sum(o1), sum(o2)); // 오름차순 정렬
                    }
                } else // 기준값이 비교값보다 크면 1 리턴
                    return 1;
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(serial[i]);
        }
    }

    // 시리얼 번호에서 숫자로 이루어진 경우
    public static int sum(String str) {
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                sum += str.charAt(i) - '0';
        }
        return sum;
    }
}
