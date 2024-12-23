package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon11286 {
  private static class X implements Comparable<X> {
    int xKey;
    int xValue;

    public X(int xKey, int xValue) {
      this.xKey = xKey;
      this.xValue = xValue;
    }

    @Override
    public int compareTo(X x) {
      if (this.xValue == x.xValue) {
        return this.xKey - x.xKey;
      }
      return this.xValue - x.xValue;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int key, value;
    PriorityQueue<X> pq = new PriorityQueue<>();
    for (int input = 1; input <= N; input++) {
      key = Integer.parseInt(br.readLine());
      value = Math.abs(key);

      if (key == 0) {
        if (pq.isEmpty()) {
          System.out.println(0);
        } else {
          X now = (X) pq.poll();
          System.out.println(now.xKey);
        }
      } else {
        pq.offer(new X(key, value));
      }
    }
  }
}
