package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Baekjoon27440 {
  private static class Num implements Comparable<Num> {
    long num;
    int cnt;

    public Num(long num, int cnt) {
      this.num = num;
      this.cnt = cnt;
    }

    @Override
    public int compareTo(Num o) {
      return this.cnt - o.cnt;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long X = Long.parseLong(br.readLine());
    System.out.print(dijkstra(X));
  }

  private static int dijkstra(long X) {
    HashSet<Long> set = new HashSet<>();

    PriorityQueue<Num> pq = new PriorityQueue<>();
    pq.add(new Num(X, 0));

    while (true) {
      Num cur = pq.poll();
      long now = cur.num;

      if (now == 1) {
        return cur.cnt;
      }

      set.add(now);

      if (now % 3 == 0 && !set.contains(now / 3)) {
        set.add(now / 3);
        pq.add(new Num(now / 3, cur.cnt + 1));
      }

      if (now % 2 == 0 && !set.contains(now / 2)) {
        set.add(now / 2);
        pq.add(new Num(now / 2, cur.cnt + 1));
      }

      if (!set.contains(now - 1)) {
        set.add(now - 1);
        pq.add(new Num(now - 1, cur.cnt + 1));
      }
    }
  }
}
