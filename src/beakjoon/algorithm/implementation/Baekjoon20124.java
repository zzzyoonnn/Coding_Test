package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon20124 {
  static class ScoreEntry {
    int score;
    String name;

    ScoreEntry(int score, String name) {
      this.score = score;
      this.name = name;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String s;
    ArrayList<ScoreEntry> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      s = br.readLine();
      String name = s.split(" ")[0];
      int score = Integer.parseInt(s.split(" ")[1]);

      list.add(new ScoreEntry(score, name));
    }

    Collections.sort(list, new Comparator<ScoreEntry>() {
      @Override
      public int compare(ScoreEntry o1, ScoreEntry o2) {
        if (o1.score != o2.score) {
          return Integer.compare(o2.score, o1.score);
        } else {
          return o1.name.compareTo(o2.name);
        }
      }
    });

    System.out.println(list.get(0).name);
  }
}
