package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon23254 {
  private static class Subject implements Comparable<Subject> {
    int id;
    int increasingScore;

    public Subject(int id, int increasingScore) {
      this.id = id;
      this.increasingScore = increasingScore;
    }

    @Override
    public int compareTo(Subject o) {
      return o.increasingScore - this.increasingScore;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] basic = new int[M];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      basic[i] = Integer.parseInt(st.nextToken());
    }

    PriorityQueue<Subject> pq = new PriorityQueue<>();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int increasingScore = Integer.parseInt(st.nextToken());

      pq.add(new Subject(i, increasingScore));
    }

    int time = 24 * N;
    while (time > 0 && !pq.isEmpty()) {
      Subject now = pq.poll();
      int temp = (100 - basic[now.id]) / now.increasingScore;
      int studyTime = Math.min(temp, time);

      time -= studyTime;
      basic[now.id] += studyTime * now.increasingScore;

      if (basic[now.id] != 100) {
        pq.offer(new Subject(now.id, (100 - basic[now.id])));
      }
    }

    int result = 0;
    for (int score : basic) {
      result += score;
    }

    System.out.print(result);
  }
}
