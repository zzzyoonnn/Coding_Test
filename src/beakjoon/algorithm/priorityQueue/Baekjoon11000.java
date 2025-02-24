package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon11000 {
  private static class Lecture implements Comparable<Lecture> {
    int startTime;
    int endTime;

    public Lecture(int startTime, int endTime) {
      this.startTime = startTime;
      this.endTime = endTime;
    }

    @Override
    public int compareTo(Lecture o) {
      if (startTime == o.startTime) {
        return endTime - o.endTime;
      }

      return startTime - o.startTime;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Lecture> lecturePq = new PriorityQueue<>();
    PriorityQueue<Integer> roomPq = new PriorityQueue<>();

    StringTokenizer st;
    for (int loop = 0; loop < N; loop++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      lecturePq.offer(new Lecture(start, end));
    }

    int count = -1;
    while (!lecturePq.isEmpty()) {
      Lecture lecture = lecturePq.poll();

      if (roomPq.isEmpty() || lecture.startTime < roomPq.peek()) {
        roomPq.offer(lecture.endTime);
        count = Math.max(count, roomPq.size());
      } else {
        roomPq.poll();
        roomPq.offer(lecture.endTime);
      }
    }

    System.out.print(count);
  }
}
