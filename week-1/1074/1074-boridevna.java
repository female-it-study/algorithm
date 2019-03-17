import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
		int side = (int)Math.pow(2, N);
		System.out.println(z(0, side, 0, 0, r, c));
	}
    
    public static int z(int base, int side, int i, int j, int r, int c){
    	if (i == r && j == c) return base;
        
        if (side == 2)
        	if (r == i) return base + 1;
        	else if (r > i && c == j) return base + 2;
        	else return base + 3;
        
        int halfSide = side/2;
        
        if (r < i+halfSide)
        	if (c < j+halfSide) 
        		return z(base, halfSide, i, j, r, c);
        	else
        		return z(base + halfSide*halfSide*1, halfSide, i, j+halfSide, r, c);   
        else
        	if (c < j+halfSide)
        		return z(base + halfSide*halfSide*2, halfSide, i+halfSide, j, r, c);
        	else
        		return z(base + halfSide*halfSide*3, halfSide, i+halfSide, j+halfSide, r, c);
    }
}