
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());
    a -= 1;
    long tmpA = a;
    long tmpB = b;
    for (int i = 1; i <50; i++) {
      tmpA+= (long) ((long)(a/(Math.pow(2,i)))*(Math.pow(2,i)-Math.pow(2,i-1)));
    }
    for (int i = 1; i <50; i++) {
      tmpB+= (long) ((long)(b/(Math.pow(2,i)))*(Math.pow(2,i)-Math.pow(2,i-1)));
    }
    System.out.println(tmpB-tmpA);
  }
}