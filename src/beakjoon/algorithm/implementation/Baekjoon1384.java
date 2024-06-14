package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon1384 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[][] arr;

    int n = 0;          // 각 그룹에 참여한 아이들의 수
    int count = 1;      // 그룹 번호
    String s;
    ArrayList<String> name;     // 아이들의 이름을 저장할 list
    StringBuilder sb;           // 각 그룹별 결과를 저장할 StringBuilder

    while ((n = Integer.parseInt(br.readLine())) != 0) {
      arr = new String[n][n];
      sb = new StringBuilder();

      name = new ArrayList<>();

      boolean check = true;
      sb.append("Group ").append(count).append('\n');

      for (int i = 0; i < n; i++) {
        arr[i] = br.readLine().split(" ");
        name.add(arr[i][0]);
      }

      for (int i = 0; i < n; i++) {
        for (int j = 1; j < n; j++) {
          if (arr[i][j].equals("N")) {
            check = false;
            sb.append(name.get((name.size() - j + i) % n));
            sb.append(" was nasty about ").append(name.get(i)).append('\n');
          }
        }
      }

      if (check) sb.append("Nobody was nasty").append('\n');

      count++;
      System.out.println(sb);
    }
  }
}
