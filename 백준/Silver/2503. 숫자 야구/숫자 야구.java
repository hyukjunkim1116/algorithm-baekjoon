import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int answer = 0;
    List<List<Integer>> hintList = new ArrayList<>(); // {}
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      List<Integer> list = new ArrayList<>();
      for (int j = 0; j < 3; j++) {
        list.add(Integer.parseInt(st.nextToken()));
      }
      hintList.add(list);
    }

    for (int a = 1; a < 10; a++) {
      for (int b = 1; b < 10; b++) {
        for (int c = 1; c < 10; c++) {
          int count = 0;
          if (a == b | b == c | c == a) continue;
          for (List<Integer> hint : hintList) {
            int number = hint.get(0); // 123
            int number100 = number / 100;
            int number10 = (number % 100) / 10;
            int number1 = number % 10;
            int strike = hint.get(1);
            int ball = hint.get(2);
            int strikeCount = 0;
            int ballCount = 0;
            if (a == number100) strikeCount++;
            if (b == number10) strikeCount++;
            if (c == number1) strikeCount++;

            if (a == number10 | a == number1) ballCount++;
            if (b == number100 | b == number1) ballCount++;
            if (c == number100 | c == number10) ballCount++;

            if (strikeCount == strike & ballCount == ball) count++;

            if (count == N) {
              answer++;
              count = 0;
            }
          }
        }
      }
    }
    System.out.println(answer);
  }
}