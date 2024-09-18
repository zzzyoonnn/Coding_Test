package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon9517 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Queue<Integer> q = new LinkedList<Integer>();
    for (int i = 1; i <= 8; i++) q.add(i);

    int player = Integer.parseInt(br.readLine());
    while (player != q.peek()) q.add(q.poll());

    int question = Integer.parseInt(br.readLine());
    int total = 210;

    StringTokenizer st;
    for (int i = 0; i < question - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int time = Integer.parseInt(st.nextToken());
      String answer = st.nextToken();

      total -= time;
      if (total <= 0) break;

      switch (answer) {
        case "T":
          q.add(q.poll());
          break;
        default:
          break;
      }
    }

    System.out.println(q.peek());
  }
}
