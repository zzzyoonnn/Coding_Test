package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
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

    ArrayList<ArrayList<Player>> list = new ArrayList<>();
    //PriorityQueue<Player> players = new PriorityQueue<>();

    for (int i = 0; i <= 11; i++) {
      list.add(new ArrayList<>());
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int p = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      list.get(p).add(new Player(p, w));
    }

    int size;
    int[] selection = new int[12];
    while (K-- > 0) {
      Arrays.fill(selection, 0);

      for (int index = 1; index <= 11; index++) {
        Player player = list.get(index).get(0);

        list.remove(index).get(0);

        list.get(index).add(player)
      }
    }

    int sum = Arrays.stream(selection).sum();

    System.out.print(sum);
  }
}
