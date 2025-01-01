package beakjoon.algorithm.dataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon15903 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());   // 카드의 개수
    int m = Integer.parseInt(st.nextToken());   // 카드 합체 횟수

    PriorityQueue<Long> pq = new PriorityQueue<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      pq.offer(Long.parseLong(st.nextToken()));
    }

    for (int count = 0; count < m; count++) {
      long result = pq.poll() + pq.poll();

      pq.offer(result);
      pq.offer(result);
    }

    long result = 0;
    while (!pq.isEmpty()) {
      result += pq.poll();
    }

    System.out.print(result);
  }
}
