package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Baekjoon2890 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    TreeMap<Integer, Integer> map = new TreeMap<>();
    int rank = 1;
    char[][] arr = new char[r][c];
    for (int i = 0; i < r; i++) {
      String s = br.readLine();
      for (int j = 1; j < c ; j++) {
        char ch = s.charAt(c - 1 - j);

        if (ch == 'S') break;

        if (ch != '.') {
          map.put(ch - '0', j);
          System.out.println(ch - '0');
          break;
        }
      }
    }

    for (int i : map.keySet()) {
      System.out.println(i + " " + map.get(i));
    }
    System.out.println(map.get(35));
  }
}
