package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1966 {
  static class Print {
    int order;
    int priority;

    Print(int order, int priority) {
      this.order = order;
      this.priority = priority;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    int n, m;
    Queue<Print> queue;
    LinkedList<Integer> list;
    StringTokenizer st;
    for (int tc = 0; tc < t; tc++) {
      st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());

      queue = new LinkedList<>();
      list = new LinkedList<>();

      int count = 0;
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        int priority = Integer.parseInt(st.nextToken());
        queue.add(new Print(i, priority));
        list.add(priority);
      }

      list.sort(Collections.reverseOrder());

      while (!queue.isEmpty()) {
        Print now = queue.poll();

        if (now.priority == list.getFirst()) {    // 현재 문서가 중요도가 가장 높은 문서라면
          count++;
          list.removeFirst();

          if (now.order == m) {   // 해당 문서가 알고 싶은 문서라면
            break;
          }
        } else {    // 현재 문서가 중요도가 가장 높은 문서가 아니라면
          queue.add(now);
        }
      }

      System.out.println(count);
    }
  }
}
