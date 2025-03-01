package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon14698 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    for (int tc = 0; tc < T; tc++) {
      int N = Integer.parseInt(br.readLine());

      PriorityQueue<BigInteger> pq = new PriorityQueue<>();
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        pq.offer(new BigInteger(st.nextToken()));
      }

      BigInteger result = BigInteger.ONE;
      while (!pq.isEmpty()) {
        BigInteger bg = pq.poll();
        if (!pq.isEmpty()) {
          bg = bg.multiply(pq.poll());
          result = result.multiply(bg);
        }
        if (!pq.isEmpty()) pq.offer(bg);
      }

      if (result.equals(BigInteger.ONE)) sb.append(1);
      else sb.append(result.remainder(new BigInteger("1000000007")));
      sb.append("\n");
    }
    System.out.print(sb);
  }
}
