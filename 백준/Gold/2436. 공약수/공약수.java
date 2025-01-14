

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long divide = (long) b / a;
        long minSum = Long.MAX_VALUE;
        long answer = 0;
        long answer2=0;

        for(long i = 1; i < ((long) (Math.sqrt(divide)))+1; i++) {
            long j = (long) divide/i;

            if (divide % i == 0 & gcd(i,j)==1){
                if (j-i < minSum){
                    minSum = j-i;
                    answer = i*a;
                    answer2 = j*a;
                }
            }
        }
        System.out.printf("%d %d%n",answer,answer2);
    
    }

    private static Long gcd(Long a, Long b) {
        while (a % b !=0) {
            Long tmp = a%b;
            a = b;
            b = tmp;
        }
        return b;
    }
}