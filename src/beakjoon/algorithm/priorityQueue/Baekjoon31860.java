package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon31860 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int work = 0; work < N; work++) {
      pq.offer(Integer.parseInt(br.readLine()));
    }

    int pre = 0;
    int days = 0;
    StringBuffer sb = new StringBuffer();
    while (!pq.isEmpty()) {
      int work = pq.poll();

      if (work <= K) continue;
      days++;

      int importance = (pre / 2) + work;
      sb.append(importance).append('\n');

      pre = importance;
      pq.offer(work - M);
    }

    System.out.println(days);
    System.out.print(sb.toString());
  }
}
