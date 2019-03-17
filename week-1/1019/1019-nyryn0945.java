import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int d = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < 10; i++) {
			System.out.print(count(d, i));
			System.out.print(" ");
		}
	}
	
	// n1 = 1 ~ n1
	// n2 = 찾는 숫자(0...9)
	public static int count(int n1, int n2) {
		int n = n1;
		int cnt = 0;
		int times = 1;
		
		while (n >= 10) {
			// xx5 -> x5x -> 5xx 순으로 찾는다
			int r = n % 10; // 현재 자리수
			n /= 10;
			cnt += (n + (r > n2 ? 1 : 0) - (n2 == 0 ? 1 : 0)) * times + (r == n2 ? n1 % times + 1 : 0);
			times *= 10;
		}
		
		if (n2 > 0) {
			if (n > n2) {
				cnt += times;
			} else if (n == n2) {
				cnt += n1 % times + 1;
			}
		}
		
		return cnt;
	}

}