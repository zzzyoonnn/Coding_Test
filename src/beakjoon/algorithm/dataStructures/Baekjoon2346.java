package beakjoon.algorithm.dataStructures;

import jdk.jshell.execution.JdiExecutionControlProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2346 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Deque<int[]> deque = new ArrayDeque<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) deque.add(new int[] {i + 1, Integer.parseInt(st.nextToken())});

    StringBuilder sb = new StringBuilder();

    while (!deque.isEmpty()) {
      int num = deque.peek()[1];
      sb.append(deque.pollFirst()[0]).append(" ");

      System.out.println(num);
      deque.removeFirst();

      if (num > 0) {
        for (int i = 0; i < num; i++) {
          deque.offerLast(deque.pollFirst());
        }
      } else {
        for (int i = 0; i < Math.abs(num); i++) {
          deque.addFirst(deque.pollLast());
        }
      }

      sb.append(deque.poll()[0]).append(" ");

    }

    System.out.println(sb);

  }
}
