

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    if (N != 1){
      prime_factorization(N);
    }
  }

  private static int prime_factorization(int n) {
    for(int i = 2; i < n+1; i++) {
      if (n%i == 0) {
        System.out.println(i);
        return prime_factorization(n /i);
      }
    }
      return n;
  }
}
