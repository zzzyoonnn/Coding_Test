package beakjoon.algorithm.dataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Baekjoon11279 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
    for (int line = 1; line <= N; line++) {
      int x = Integer.parseInt(br.readLine());

      if (x == 0) {
        if (pq.isEmpty()) {
          System.out.println(0);
        } else System.out.println(pq.poll());
      } else {
        pq.add(x);
      }
    }
  }
}
