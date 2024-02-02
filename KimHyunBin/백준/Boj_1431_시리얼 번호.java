import java.io.*;
import java.util.*;

public class Main { // Boj_1431_시리얼 번호
	// 정렬 문제. A와 B중 짧은것이 앞으로
	// 같다면 A와 B 숫자 합 비교 작은게 앞
	// 이 둘로도 불가능하면 사전순으로 비교, 숫자 가 알파뱃보다 앞
	public static int N;
	public static List<String> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		list = new ArrayList<>();
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
		}

		Collections.sort(list, new Comparator<String>() {
			// 1. A와 B중 짧은것이 앞으로
			// 2. 같다면 A와 B 숫자 합 비교 작은게 앞
			// 3. 이 둘로도 불가능하면 사전순으로 비교, 숫자 가 알파뱃보다 앞
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if (o1.length() == o2.length()) {// 조건 1
					int n1 = calculator(o1);
					int n2 = calculator(o2);
					
					if (n1 == n2) { // 조건 2 같을때
						return o1.compareTo(o2);
					}else { // 조건 2 다를때
						return n1 - n2;
					}
				} else { // 조건 1 다르다면
					// 짧은게 앞으로
					return o1.length() - o2.length();
				}

			}

			private int calculator(String s) {
				// TODO Auto-generated method stub
				int sum = 0;
				for (int i = 0; i < s.length(); i++) {
					int temp = s.charAt(i) - '0';
					if (temp < 0 || temp > 9)
						continue;
					sum += temp;
				}
				return sum;
			}

		});
		
		for(int i = 0; i<list.size(); i++) {
			sb.append(list.get(i) + "\n");
		}
		
		System.out.println(sb);

	}
}
