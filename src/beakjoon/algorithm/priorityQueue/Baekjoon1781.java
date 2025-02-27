package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon1781 {
  private static class Question implements Comparable<Question> {
    int deadLine;
    int reward;

    public Question(int deadLine, int reward) {
      this.deadLine = deadLine;
      this.reward = reward;
    }

    @Override
    public int compareTo(Question o) {
      return this.deadLine - o.deadLine;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    ArrayList<Question> questions = new ArrayList<>();

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int d = Integer.parseInt(st.nextToken());
      int r = Integer.parseInt(st.nextToken());

      questions.add(new Question(d, r));
    }

    Collections.sort(questions);

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (Question q : questions) {
      pq.add(q.reward);

      if (pq.size() > q.deadLine) {
        pq.poll();
      }
    }

    int maxReward = 0;
    while (!pq.isEmpty()) {
      maxReward += pq.poll();
    }

    System.out.print(maxReward);
  }
}
