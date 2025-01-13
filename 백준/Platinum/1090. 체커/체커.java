import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    // 초기화
    ArrayList<int[]> checkers = new ArrayList<>();
    int[] checkerX = new int[N];
    int[] checkerY = new int[N];
    for (int i = 0; i< N; i++){
      st = new StringTokenizer(br.readLine()," ");
      while (st.hasMoreTokens()){
        int x =Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        checkerX[i] = x;
        checkerY[i] = y;
        int[] tmp = new int[2];
        tmp[0] = x;
        tmp[1] = y;
        checkers.add(tmp);
      }
    }
    ArrayList<Integer> answer = new ArrayList<>();
    for (int i = 0; i < N; i++){
      answer.add(-1);
    }
    for (int x: checkerX){
      for (int y: checkerY){
        ArrayList<Integer> distance = new ArrayList<>();
        for (int[] checker : checkers) {
          int d = Math.abs(x-checker[0]) + Math.abs(y-checker[1]);
          distance.add(d);
        }
        distance.sort(null);

        int tmp = 0;
        for (int i=0; i< distance.size(); i++){
         int d = distance.get(i);
         tmp += d;
         if (answer.get(i) == -1) {
           answer.set(i,tmp);
         } else {
           answer.set(i, Math.min(tmp,answer.get(i)));
         }
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i =0; i< answer.size(); i++){
      if (i == answer.size()-1){
        sb.append(answer.get(i));
      } else{
        sb.append(answer.get(i)).append(" ");
      }
    }
    System.out.println(sb);
  }
}