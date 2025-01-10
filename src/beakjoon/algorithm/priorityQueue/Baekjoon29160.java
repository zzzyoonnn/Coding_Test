package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon29160 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    ArrayList<PriorityQueue<Integer>> players = new ArrayList<>();
    for (int index = 0; index <= 11; index++) {
      players.add(new PriorityQueue<>(Collections.reverseOrder()));
    }

    for (int index = 0; index < N; index++) {
      st = new StringTokenizer(br.readLine());
      int p = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      players.get(p).offer(w);
    }

    for (int year = 0; year < K; year++) {
      for (int index = 1; index <= 11; index++) {
        PriorityQueue<Integer> pq = players.get(index);
        if (!pq.isEmpty()) {
          int value = pq.poll() - 1;
          value = Math.max(value, 0);
          pq.offer(value);
        }
      }
    }

    int sum = 0;
    for (int index = 1; index <= 11; index++) {
      PriorityQueue<Integer> pq = players.get(index);
      if (!pq.isEmpty()) {
        sum += pq.poll();
      }
    }

    System.out.print(sum);
  }
}
