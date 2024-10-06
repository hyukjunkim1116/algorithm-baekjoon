import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        Queue<Integer> cards = new ArrayDeque<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer count = Integer.parseInt(br.readLine());

        for (int i = 1; i <= count; i++) {
            cards.offer(i);
        }

        while (cards.size() != 1) {
            cards.poll();
            Integer secondEl = cards.poll();
            cards.offer(secondEl);
        }
        System.out.println(cards.peek());
    }
}