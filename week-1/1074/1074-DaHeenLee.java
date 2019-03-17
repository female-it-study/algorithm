import java.util.Scanner;

public class Main {
	private int n = 0;
	private int r = 0;
	private int c = 0;
	private int count = 0;

	public Main(int n, int r, int c) {
		this.n = n;
		this.r = r;
		this.c = c;
	}

	public void visitInZ(int x, int y, int length) {
//		System.out.println(x + " " + y + " " + length + " " + count);
		if(length == 1) {
			if(x == r && y == c) {
				System.out.println(count);
			}
			count++;
			return;
		} else {
			if(r >= x && r < x + length && c >= y && c < y + length) {
				int nextLength = length/2;
				visitInZ(x, y, nextLength);
				visitInZ(x, y + nextLength, nextLength);
				visitInZ(x + nextLength, y, nextLength);
				visitInZ(x + nextLength, y + nextLength, nextLength);
			} else {
				count += length * length;
				return;
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int r = scan.nextInt();
		int c = scan.nextInt();
		
		int length = (int)Math.pow(2, n);
		
		Main s = new Main(n, r, c);
		s.visitInZ(0, 0, length); 
		
	}

}
