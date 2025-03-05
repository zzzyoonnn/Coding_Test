package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Baekjoon12764_1 {
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

  private static class User implements Comparable<User> {
    int index;
    int usage;
    int endTime;

    public User(int index, int usage, int endTime) {
      this.index = index;
      this.usage = usage;
      this.endTime = endTime;
    }

    @Override
    public int compareTo(User o) {
      if (this.endTime == o.endTime) {
        return this.index - o.index;
      }
      return endTime - o.endTime;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st;
    PriorityQueue<Usage> usagePq = new PriorityQueue<>();
    PriorityQueue<User> computerPq = new PriorityQueue<>();
    TreeMap<Integer, Integer> usageCount = new TreeMap<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int P = Integer.parseInt(st.nextToken());
      int Q = Integer.parseInt(st.nextToken());
      usagePq.add(new Usage(P, Q));
    }

    int maxComputer = 0;
    int index = 0;

    while (!usagePq.isEmpty()) {
      Usage now = usagePq.poll();

      if (!computerPq.isEmpty() && computerPq.peek().endTime <= now.startTime) {
        User user = computerPq.poll();
        user.usage++;
        user.endTime = now.endTime;
        computerPq.add(user);
      } else {
        computerPq.add(new User(index, 1, now.endTime));
        index++;
      }
      maxComputer = Math.max(maxComputer, index);

    }

    System.out.println(maxComputer);

    for (int usage : usageCount.values()) {
      System.out.print(usage + " ");
    }
  }
}
