package 백준;
import java.util.*;
import java.io.*;

public class Boj_1181_단어정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashSet<String> set = new HashSet<>();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		int size = set.size();
		String[] arr = new String[size];
		set.toArray(arr);

		// sorting 길이를 비교하기 위해 Override
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else {
					return o1.length() - o2.length();
				}
			}
		});
		
		for (String s : arr) {
			sb.append(s);
			sb.append("\n");
		}
		System.out.println(sb);

	}
}
