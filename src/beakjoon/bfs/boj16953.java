package beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16953 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    long result = bfs(a, b);
    System.out.print(result);
  }

  private static long bfs(int a, int b) {
    Queue<long[]> queue = new LinkedList<>();
    queue.add(new long[]{a, 1});

    while (!queue.isEmpty()) {
      long[] cur = queue.poll();
      long position = cur[0];
      long count = cur[1];

      if (position == b) return count;

      if (position * 2 <= b) {
        queue.add(new long[]{position * 2, count + 1});
      }

      String s = position + "1";
      long l = Long.parseLong(s);
      if (l <= b) {
        queue.add(new long[]{l, count + 1});
      }
    }

    return -1;
  }
}
