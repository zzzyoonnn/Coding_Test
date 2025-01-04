package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon23843 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());    // 전자기기의 개수
    int M = Integer.parseInt(st.nextToken());    // 콘센트의 개수

    st = new StringTokenizer(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int index = 0; index < M; index++) {
      pq.offer(Integer.parseInt(st.nextToken()));
    }

    while (!pq.isEmpty()) {

    }
  }
}
