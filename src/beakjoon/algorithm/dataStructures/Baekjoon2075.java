package beakjoon.algorithm.dataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon2075 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st;
    PriorityQueue pq = new PriorityQueue(Collections.reverseOrder());
    for (int line = 1; line <= N; line++) {
      st = new StringTokenizer(br.readLine());
      for (int index = 1; index <= N; index++) {
        pq.offer(Integer.parseInt(st.nextToken()));
      }
    }

    int index = 0;
    while (!pq.isEmpty()) {
      index++;
      if (index == N) {
        System.out.print(pq.poll());
        break;
      }

      pq.poll();
    }
  }
}
