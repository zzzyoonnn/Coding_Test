package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon1379 {
  private static class Lecture implements Comparable<Lecture> {
    int num;
    int start;
    int end;

    public Lecture(int num, int start, int end) {
      this.num = num;
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Lecture o) {
      if (start == o.start) {
        return end - o.end;
      }
      return start - o.start;
    }
  }

  private static class Room implements Comparable<Room> {
    int num;
    int end;

    public Room(int num, int end) {
      this.num = num;
      this.end = end;
    }

    @Override
    public int compareTo(Room o) {
      return end - o.end;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    
    PriorityQueue<Lecture> pq = new PriorityQueue<>();

    StringTokenizer st;
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      pq.offer(new Lecture(num, start, end));
    }

    int maxLoom = 0;
    int[] roomNum = new int[N + 1];
    PriorityQueue<Room> roomPq = new PriorityQueue<>();

    while (!pq.isEmpty()) {
      Lecture now = pq.poll();

      if (roomPq.isEmpty()) {
        roomPq.offer(new Room(1, now.end));
        roomNum[now.num] = 1;
      } else {
        if (roomPq.peek().end <= now.start) {
          roomNum[now.num] = roomPq.peek().num;
          roomPq.poll();
        } else {
          roomNum[now.num] = roomPq.size() + 1;
        }
        roomPq.offer(new Room(roomNum[now.num], now.end));
      }

      maxLoom = Math.max(maxLoom, roomPq.size());
    }

    System.out.println(roomPq.size());

    for (int i = 1; i <= N; i++) {
      System.out.println(roomNum[i]);
    }
  }
}
