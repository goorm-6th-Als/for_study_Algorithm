import java.util.*;

class Solution {
	public boolean isPossible(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {
		int n = g.length;
		long total = 0L, totalG = 0L, totalS = 0L;

		for (int i = 0; i < n; i++) {
			long cnt = (time + t[i] - 1) / (2L * t[i]);
			long tmp = Math.min(cnt * w[i], g[i] + s[i]);
			total += tmp;
			totalG += Math.min(tmp, g[i]);
			totalS += Math.min(tmp, s[i]);
		}

		return total >= a + b && totalG >= a && totalS >= b;
	}

	public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
		long hi = 400000000000000L, lo = 0;

		while (lo + 1 < hi) {
			long mid = (lo + hi) / 2;
			if (isPossible(mid, a, b, g, s, w, t)) hi = mid;
			else lo = mid;
		}

		return hi-1;
	}
}