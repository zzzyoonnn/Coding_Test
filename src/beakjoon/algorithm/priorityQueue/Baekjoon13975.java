package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon13975 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    int K;
    StringTokenizer st;
    PriorityQueue<Long> pq;
    for (int tc = 0; tc < T; tc++) {
      K = Integer.parseInt(br.readLine());

      pq = new PriorityQueue<>();
      st = new StringTokenizer(br.readLine());

      while (st.hasMoreTokens()) {
        pq.offer(Long.parseLong(st.nextToken()));
      }

      long size = 0;
      while (pq.size() > 1) {
        long temp = pq.poll();

        if (pq.size() > 0) temp += pq.poll();
        size += temp;
        pq.offer(temp);
      }

      System.out.println(size);
    }
  }
}
