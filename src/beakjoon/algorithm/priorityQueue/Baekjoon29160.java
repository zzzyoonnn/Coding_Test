package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon29160 {
  private static class Player implements Comparable<Player> {
    int position;
    int value;

    public Player(int position, int value) {
      this.position = position;
      this.value = value;
    }

    @Override
    public int compareTo(Player o) {
      return o.value - this.value;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    ArrayList<ArrayList<Player>> list = new ArrayList<ArrayList<Player>>();
    for (int i = 0; i <= N; i++) {
      list.add(new ArrayList<>());
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int p = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      list.get(p).add(new Player(p, w));
    }

    K *= 2;
    int result = 0;
    while (K-- > 0) {
      for (int i = 1; i <= N; i++) {
        list.get(i).o
      }
    }
  }
}
