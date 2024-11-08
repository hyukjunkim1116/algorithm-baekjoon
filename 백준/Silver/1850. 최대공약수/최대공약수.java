import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static long gcd(long a, long b) {
		if(a%b == 0)
			return b;
		return gcd(b, a%b);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder str = new StringBuilder();
	
		long A = Long.parseLong(st.nextToken());

		long B = Long.parseLong(st.nextToken());
		
		for (long i = 0; i < gcd(Math.max(A, B), Math.min(A, B)); i++)
			str.append("1");
		
		System.out.println(str);
		br.close();
	}
}
