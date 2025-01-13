import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int candy = Integer.parseInt(br.readLine());
    int answer = 0;
    for (int a = 1; a < candy + 1; a++) {
      for (int b = 1; b < candy + 1; b++) {
        for (int c = 1; c < candy + 1; c++) {
          if (a+b+c == candy){
            if (c >= b+2){
              if (a % 2 == 0){
                answer++;
              }
            }
          }
        }
      }
    }
    System.out.println(answer);
  }
}