import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int count = 0;
		
		while (N > 0) {
			if (0 <= r && r <= pow2(N - 1) - 1 && 0 <= c && c <= pow2(N - 1) - 1) {
				// a
			} else if (0 <= r && r <= pow2(N - 1) - 1 && pow2(N - 1) <= c && c <= pow2(N) - 1) {
				// b
				c -= pow2(N - 1);
				count += pow2(2 * N - 2);
			} else if (pow2(N - 1) <= r && r <= pow2(N) - 1 && 0 <= c && c <= pow2(N - 1) - 1) {
				// c
				r -= pow2(N - 1);
				count += pow2(2 * N - 2) * 2;
			} else {
				// d
				c -= pow2(N - 1);
				r -= pow2(N - 1);
				count += pow2(2 * N - 2) * 3;
			}
			N--;
		}
		
		System.out.println(count);
	}

	public static int pow2(int n) {
		return (int) Math.pow(2, n);
	}
}