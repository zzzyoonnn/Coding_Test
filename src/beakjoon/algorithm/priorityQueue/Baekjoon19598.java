package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon19598 {
  private static class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    public Meeting(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
      if (this.start == o.start) {    // 시작 시간이 같다면
        return this.end - o.end;    // 종료시간이 작은 것부터
      }

      return this.start - o.start;  // 시작 시간을 기준으로 오름차순 정렬
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Meeting> meetingPq = new PriorityQueue<>();
    PriorityQueue<Integer> roomPq = new PriorityQueue<>();

    StringTokenizer st;
    for (int meeting = 0; meeting < N; meeting++) {
      st = new StringTokenizer(br.readLine());

      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      meetingPq.offer(new Meeting(start, end));
    }

    int max = -1;
    while (!meetingPq.isEmpty()) {
      Meeting cur = meetingPq.poll();

      if (roomPq.isEmpty() || cur.start < roomPq.peek()) {   // 현재 사용중인 회의실이 비어있거나 새로운 회의실이 필요하다면
        roomPq.offer(cur.end);
        max = Math.max(max, roomPq.size());
      } else {    // 기존 회의실을 사용한다면
        roomPq.poll();
        roomPq.offer(cur.end);
      }
    }

    System.out.print(max);
  }
}
