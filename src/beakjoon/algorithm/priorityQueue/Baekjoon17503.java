package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon17503 {
  private static class Beer implements Comparable<Beer> {
    int preference;
    int level;

    public Beer(int preference, int level) {
      this.preference = preference;
      this.level = level;
    }

    @Override
    public int compareTo(Beer o) {
      return this.level - o.level;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());   // 축제가 열리는 기간
    int M = Integer.parseInt(st.nextToken());   // 채워야 하는 선호도 합
    int K = Integer.parseInt(st.nextToken());   // 마실 수 있는 맥주 종류의 수

    PriorityQueue<Beer> pq = new PriorityQueue<Beer>();
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int preference = Integer.parseInt(st.nextToken());
      int level = Integer.parseInt(st.nextToken());

      pq.add(new Beer(preference, level));
    }

    int min = Integer.MAX_VALUE / 2;
    int total = 0;
    while(!pq.isEmpty()) {
      Beer beer = pq.poll();

      total += beer.preference;
      min = Integer.max(min, beer.level);
    }


  }
}
