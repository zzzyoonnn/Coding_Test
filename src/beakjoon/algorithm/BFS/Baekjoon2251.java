package beakjoon.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2251 {
  private static class Water {
    int a;
    int b;
    int c;

    public Water(int a, int b, int c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    ArrayList<Integer> result = new ArrayList<>();
    boolean[][][] visited = new boolean[201][201][201];

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    Queue<Water> q = new LinkedList<>();
    q.offer(new Water(0, 0, c));

    while (!q.isEmpty()) {
      Water now = q.poll();

      if (visited[now.a][now.b][now.c]) continue;
//      System.out.println(now.a + " " + now.b + " " + now.c);

      visited[now.a][now.b][now.c] = true;
      if (now.a == 0) {
//        System.out.println("결과 추가 : " + now.a + " " + now.b + " " + now.c);
        result.add(now.c);
      }

      // Case 1: A, B
      if(now.a + now.b > a) q.offer(new Water(a, now.a + now.b - a , now.c));
      else q.offer(new Water(now.a + now.b, 0, now.c));

      if (now.a + now.b > b) q.offer(new Water(now.a + now.b - b, b, now.c));
      else q.offer(new Water(0, now.a + now.b, now.c));

      // Case 2: B, C
      if (now.b + now.c > b) q.offer(new Water(now.a, b, now.b + now.c - b));
      else q.offer(new Water(now.a, now.b + now.c, 0));

      if (now.b + now.c > c) q.offer(new Water(now.a, now.b + now.c - c, c));
      else q.offer(new Water(now.a, 0, now.b + now.c));

      // Case 3: C, A
      if (now.c + now.a > c) q.offer(new Water(now.c + now.a - c, now.b, c));
      else q.offer(new Water(0, now.b, now.c + now.a));

      if (now.c + now.a > a) q.offer(new Water(a, now.b, now.c + now.a - a));
      else q.offer(new Water(now.c + now.a, now.b, 0));

    }

    Collections.sort(result);
//    System.out.print("출력: ");
    for (int i = 0; i < result.size(); i++) {
      System.out.print(result.get(i) + " ");
    }

  }
}
