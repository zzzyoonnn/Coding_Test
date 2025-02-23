package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon1374 {
  private static class Lecture implements Comparable<Lecture> {
    int startTime;
    int endTime;

    public Lecture(int startTime, int endTime) {
      this.startTime = startTime;
      this.endTime = endTime;
    }

    @Override
    public int compareTo(Lecture l) {
      if (this.startTime == l.startTime) {
        return this.endTime - l.endTime;
      }
      return this.startTime - l.startTime;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st;

    PriorityQueue<Lecture> lectures = new PriorityQueue<>();
    PriorityQueue<Integer> room = new PriorityQueue<>();

    for (int info = 0; info < N; info++) {
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      lectures.offer(new Lecture(start, end));
    }

    int max = -1;
    while (!lectures.isEmpty()) {
      Lecture now = lectures.poll();

      if (room.isEmpty() || now.startTime < room.peek()) {
        room.offer(now.endTime);
        max = Math.max(max, room.size());
      } else {
        room.poll();
        room.offer(now.endTime);
      }
    }

    System.out.print(max);


  }
}
