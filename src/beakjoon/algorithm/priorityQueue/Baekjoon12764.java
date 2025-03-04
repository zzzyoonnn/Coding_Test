package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
      return endTime - o.endTime;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st;
    PriorityQueue<Usage> usagePq = new PriorityQueue<>();
    PriorityQueue<User> computerPq = new PriorityQueue<>();

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

      if (computerPq.isEmpty() || now.startTime < computerPq.peek().endTime) {
        computerPq.add(new User(index, 1, now.endTime));
        maxComputer = Math.max(maxComputer, computerPq.size());
        index++;
      } else {
        User user = computerPq.poll();
        computerPq.add(new User(user.index, ++user.usage, now.endTime));
      }
    }

    System.out.println(maxComputer);

    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    while (!computerPq.isEmpty()) {
      User user = computerPq.poll();
      System.out.println(user.index + " " + user.usage);
      treeMap.put(user.index, user.usage);
    }

    for (int usage : treeMap.values()) {
      System.out.print(usage + " ");
    }
  }
}
