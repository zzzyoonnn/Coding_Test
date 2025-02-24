package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon2109 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;

    List<int[]> lectures = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int pay = Integer.parseInt(st.nextToken());
      int days = Integer.parseInt(st.nextToken());

      lectures.add(new int[]{pay, days});
    }

    lectures.sort((a, b) -> a[1] - b[1]); // 날짜를 기준으로 오름차순 정렬

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int[] lecture : lectures) {
      pq.offer(lecture[0]);  // 강연비 추가
      if (pq.size() > lecture[1]) {
        pq.poll();  // 가장 작은 강연비 제거
      }
    }

    int maxPay = 0;
    while (!pq.isEmpty()) {
      maxPay += pq.poll();
    }

    System.out.print(maxPay);

  }
}
