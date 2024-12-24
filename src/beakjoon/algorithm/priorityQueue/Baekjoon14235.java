package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon14235 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());    // 아이들과 거점지를 방문한 횟수

    StringTokenizer st;
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
    for (int input = 1; input <= N; input++) {
      st = new StringTokenizer(br.readLine());

      int gift = Integer.parseInt(st.nextToken());
      if (gift == 0) {
        if (pq.isEmpty()) System.out.println(-1);
        else System.out.println(pq.poll());
      } else {
        for (int index = 0; index < gift; index++) {
          int value = Integer.parseInt(st.nextToken());
          pq.add(value);
        }
      }
    }
  }
}
