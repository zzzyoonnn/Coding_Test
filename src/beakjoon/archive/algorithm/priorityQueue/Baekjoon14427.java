package beakjoon.archive.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon14427 {
  private static class Data implements Comparable<Data> {
    int index;
    int value;

    public Data(int index, int value) {
      this.index = index;
      this.value = value;
    }

    @Override
    public int compareTo(Data o) {
      return this.value - o.value;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    PriorityQueue<Data> pq = new PriorityQueue<>();
    int[] data = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      int value = Integer.parseInt(st.nextToken());
      data[i] = value;
      pq.offer(new Data(i, value));
    }

    StringBuilder sb = new StringBuilder();
    int loop = Integer.parseInt(br.readLine());
    for (int l = 0; l < loop; l++) {
      st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());

      if (n == 2) sb.append(pq.peek().index).append("\n");
      else {
        int i = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        data[i] = v;
      }
    }
    System.out.print(sb.toString());
  }
}
