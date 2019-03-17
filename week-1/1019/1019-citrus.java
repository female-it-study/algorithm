import java.util.Scanner;

/*문제) 지민이는 N쪽인 책이 한권 있다. 첫 페이지는 1쪽이고, 마지막 페이지는 N쪽이다.
 * 각 숫자가 모두 몇 번이 나오는지 출력하는 프로그램을 작성하시오.
 * 
 *입력) 첫째 줄에 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
 */
public class Main {

	private static int[] numArr = new int[10];	//0~9
	private static int position = 1;	//자리수

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); // 마지막 페이지 N

		int sp = 1; // 시작 페이지
		int ep = n; // 마지막 페이지

		while (sp <= ep) {

			while (sp % 10 != 0 && sp <= ep) {	// % : 나머지, /:몫
				cal(sp);
				sp++; // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
			}

			if (sp > ep)
				break; // 계산 종료

			while (ep % 10 != 9 && sp <= ep) {
				cal(ep);
				ep--; // 36, 35, 34, 33, 32, 31, 30, 29
			}

			sp /= 10; // 10 -> 1
			ep /= 10; // 29 -> 2

			for (int i = 0; i < 10; i++)
				numArr[i] += (ep - sp + 1) * position; // 일의 자리에 0~9가 총 2번씩 등장

			position *= 10; // 자리수 계산
		}

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 10; i++)
			builder.append(numArr[i] + " ");

		System.out.println(builder.toString());
	}

	public static void cal(int num) { // 각 숫자가 몇 번씩 나오는지 더함
		while (num > 0) {
			numArr[num % 10] += position;
			num /= 10;
		}
	}
}
