
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  private static int answer = 0;
  private static int N;
  private static int[][] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N][3];
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < 3; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    recur(0, 100);

    System.out.println(answer);
  }

  private static void recur(int hintIdx, int inputNum) {
    if (inputNum == 1000) return;
    if (hintIdx == N) {
      answer++;
      recur(0, inputNum + 1);
      return;
    }
    if (checker(hintIdx, inputNum)) {
      recur(hintIdx + 1, inputNum);
    } else {
      recur(0, inputNum + 1);
    }
  }

  private static Boolean checker(int hintIdx, int inputNum) {
    int hintNum = arr[hintIdx][0];
    int hintStrike = arr[hintIdx][1];
    int hintBall = arr[hintIdx][2];
    int hintNum100 = hintNum / 100;
    int hintNum10 = (hintNum % 100) / 10;
    int hintNum1 = hintNum % 10;
    int inputNum100 = inputNum / 100;
    int inputNum10 = (inputNum % 100) / 10;
    int inputNum1 = inputNum % 10;
    int strikeCount = 0;
    int ballCount = 0;
    if (inputNum100 == inputNum10 || inputNum10 == inputNum1 || inputNum1 == inputNum100)
      return false;

    if (inputNum100 == 0 || inputNum10 == 0 || inputNum1 == 0) return false;

    if (inputNum100 == hintNum100) strikeCount += 1;
    if (inputNum10 == hintNum10) strikeCount += 1;
    if (inputNum1 == hintNum1) strikeCount += 1;

    if (inputNum100 == hintNum10 || inputNum100 == hintNum1) ballCount += 1;

    if (inputNum10 == hintNum100 || inputNum10 == hintNum1) ballCount += 1;
    if (inputNum1 == hintNum10 || inputNum1 == hintNum100) ballCount += 1;

    return strikeCount == hintStrike && ballCount == hintBall;
  }
}
