package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon23757 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static PriorityQueue<Integer> pq;

  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine());

    priorityQueue();

    System.out.print(solve());
  }

  private static int solve() throws IOException {
    st = new StringTokenizer(br.readLine());
    while (st.hasMoreTokens()) {
      int present = Integer.parseInt(st.nextToken());
      int now = pq.poll();

      if (now < present) return 0;
      else {
        pq.add(now - present);
      }
    }

    return 1;
  }

  private static void priorityQueue() throws IOException {
    pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
    st = new StringTokenizer(br.readLine());
    while (st.hasMoreTokens()) {
      pq.add(Integer.parseInt(st.nextToken()));
    }
  }
}
