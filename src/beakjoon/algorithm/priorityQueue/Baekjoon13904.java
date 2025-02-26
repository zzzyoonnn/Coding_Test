package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon13904 {
  private static class Task implements Comparable<Task> {
    int deadLine;
    int score;

    public Task(int deadLine, int score) {
      this.deadLine = deadLine;
      this.score = score;
    }

    @Override
    public int compareTo(Task o) {
      return deadLine - o.deadLine;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    ArrayList<Task> tasks = new ArrayList<>();

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int d = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      tasks.add(new Task(d, w));
    }

    Collections.sort(tasks);

    PriorityQueue<Integer> works = new PriorityQueue<>();
    for (Task t : tasks) {
      works.offer(t.score);

      if (t.deadLine < works.size()) {
        works.poll();
      }
    }

    int totalScore = 0;
    while (!works.isEmpty()) {
      totalScore += works.poll();
    }

    System.out.print(totalScore);
  }
}
