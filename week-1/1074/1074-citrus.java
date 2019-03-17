import java.util.Scanner;

/*
 * Z 문제) 2차원 배열 (항상 2^N * 2^N 크기이다)을 Z모양으로 탐색하려고 한다 N이 주어졌을 때, (r, c)를 몇 번째로
 * 방문하는지 출력하는 프로그램을 작성하시오. 배열을 4등분 한 후에 (크기가 같은 2^(N-1)로) 재귀적으로 순서대로 방문한다.
 * 
 * 입력) 첫째 줄에 N r c가 주어진다. N은 15보다 작거나 같은 자연수이고, r과 c는 0보다 크거나 같고, 2^N-1보다
 * 작거나 같은 정수이다
 */
// 0<n<16, 0<r,c<2^N-1

public class Main {

	static int cnt = 0;
	static int num = 0; // 순번
	static boolean flag = true;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int r = scan.nextInt();
		int c = scan.nextInt();
		System.out.println("n = " + n);
		System.out.println("r = " + r);
		System.out.println("c = " + c);

		// 크기
		int size = (int) Math.pow(2, n);
		System.out.println("size = " + size);

		// 시작 좌표
		int x = 0; // 행
		int y = 0; // 열

		go(size, r, c, x, y);
		System.out.println(num);
	}

	private static void go(int size, int r, int c, int x, int y) {
		
		System.out.println(size+","+r+","+c+","+x+","+y);

		if (size == 1 || r == 0 || c == 0) {
			System.out.println("값을 계산할 수 없습니다.");
			return;
		}

		if (!flag)
			return;

		if (size == 2) { // 제일 작은 크기
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (y + i == r && x + j == c) {

						System.out.println("num = " + num);
						System.out.println("cnt = " + cnt);

						num = cnt;
						flag = false;
						break;

					} else {
						cnt++;
						System.out.println("cnt = " + cnt);
					}
				}
			}
		}
		else {
			int modSize = size / 2; // 크기가 2보다 클 경우 2로 나눠줌
			System.out.println("modSize =" + modSize);
			for (int i = 0; i < size; i = i + modSize) {
				for (int j = 0; j < size; j = j + modSize) {
					go(modSize, r, c, x + j, y + i);
				}
			}
		}
	}
}
