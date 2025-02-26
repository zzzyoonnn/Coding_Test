package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2109 {
  private static class Lecture implements Comparable<Lecture> {
    int pay;
    int days;

    public Lecture(int pay, int days) {
      this.pay = pay;
      this.days = days;
    }

    @Override
    public int compareTo(Lecture o) {
      return this.days - o.days;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;

    List<Lecture> lectures = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int pay = Integer.parseInt(st.nextToken());
      int days = Integer.parseInt(st.nextToken());

      lectures.add(new Lecture(pay, days));
    }
    Collections.sort(lectures);

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (Lecture l : lectures) {
      pq.offer(l.pay);
      if (pq.size() > l.days) {
        pq.poll();
      }
    }

    int maxPay = 0;
    while (!pq.isEmpty()) {
      maxPay += pq.poll();
    }

    System.out.print(maxPay);

  }
}
