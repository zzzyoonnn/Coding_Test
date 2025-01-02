package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon1715 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int index = 0; index < N; index++) {
      int num = Integer.parseInt(br.readLine());
      pq.add(num);
    }

    int count = 0;
    while (pq.size() > 1) {
      int sum = pq.poll() + pq.poll();
      count += sum;
      pq.offer(sum);
    }

    System.out.print(count);
  }
}
