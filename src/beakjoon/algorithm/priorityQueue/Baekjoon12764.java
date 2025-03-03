package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon12764 {
  private static class Usage implements Comparable<Usage> {
    int startTime;
    int endTime;

    public Usage(int startTime, int endTime) {
      this.startTime = startTime;
      this.endTime = endTime;
    }

    @Override
    public int compareTo(Usage o) {
      if (this.startTime == o.startTime) {
        return this.endTime - o.endTime;
      }
      return this.startTime - o.startTime;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st;
    PriorityQueue<Usage> usagePq = new PriorityQueue<>();
    PriorityQueue<Integer> computerPq = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      int P = Integer.parseInt(st.nextToken());
      int Q = Integer.parseInt(st.nextToken());

      usagePq.add(new Usage(P, Q));
    }

    int maxComputer = -1;
    int size = 0;
    StringBuilder sb = new StringBuilder();
    HashMap<Integer, Integer> map = new HashMap<>();
    while (!usagePq.isEmpty()) {
      Usage now = usagePq.poll();

      if (computerPq.isEmpty() || now.startTime < computerPq.peek()) {
        sb.append(size).append(' ');
        size = 0;
        computerPq.add(now.endTime);
        maxComputer = Math.max(maxComputer, computerPq.size());

        map.put(now.endTime, 1);
      } else {
        computerPq.poll();
        computerPq.add(now.endTime);
        size++;
      }
    }

    System.out.println(maxComputer);
    for (int i : map.keySet()) {
      System.out.print(i + " ");
    }
  }
}
