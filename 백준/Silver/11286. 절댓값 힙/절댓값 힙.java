import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    //음수(-1, -2, ...): o1이 o2보다 "작다"고 간주됩니다. 즉, o1이 o2보다 앞에 와야 한다는 뜻입니다.
                    //양수(+1, +2, ...): o1이 o2보다 "크다"고 간주됩니다. 즉, o1이 o2보다 뒤에 와야 한다는 뜻입니다.
                    //0: o1과 o2가 "같다"고 간주됩니다. 두 객체의 순서는 동일하며, 순서상 어떤 위치에 놓아도 상관없습니다.
                    public int compare(Integer o1, Integer o2) {
                        // 둘의 절댓값이 같으면 o1-o2 반환 -> - 이면 o1은 마이너스, o2는 플러스 ->  o1이 o2보다 앞에 와야함(우선순위 더 높음)
                        // + 라면 반대, 0이면 순서 상관 없음
                        if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;
                        
                        // 리턴값이 -이면 o1이 우선순위 더 높다는 뜻. 결국 o1앞에 오게되고 poll()메서드 실행시 먼저 빠짐
                        else return Math.abs(o1) - Math.abs(o2);
                    }
                }
        );

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                int out = queue.isEmpty() ? 0 : queue.poll();
                System.out.println(out);
            } else {
                queue.offer(x);
            }
        }
    }
}