package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon28215 {
  static int n, k;
  static ArrayList<pos> position = new ArrayList<>();
  static ArrayList<int[]> list = new ArrayList<>();
  static boolean visited[];

  // 키보드에서 문자의 위치를 저장하기 위한 pos클래스 정의
  private static class pos {
    int x;
    int y;

    public pos(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());   // 집 수
    k = Integer.parseInt(st.nextToken());   // 대피소 수

    visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      position.add(new pos(x, y));
    }

    dfs(0, 0, new int[k]);
    int answer = Integer.MAX_VALUE;
    for(int comb[] : list) {
      int rest[] = new int[n - k];
      boolean check[] = new boolean[n];

      for(int choice : comb) {
        check[choice] = true;
      }

      int index = 0;
      for(int i = 0; i < n; i++) {
        if(!check[i]) {
          rest[index] = i;
          index++;
        }
      }

      int max = Integer.MIN_VALUE;
      for(int i = 0; i < rest.length; i++) {
        pos n1 = position.get(rest[i]);
        int gap = 0;
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < comb.length; j++) {
          pos n2 = position.get(comb[j]);
          gap = Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y);
          min = Math.min(min, gap);
        }
        max = Math.max(max, min);
      }
      answer = Math.min(answer, max);
    }
    System.out.println(answer);
  }

  public static void dfs(int depth, int start, int[] arr) {
    if(depth == k) {
      list.add(arr.clone());
      return;
    }

    for(int i = start; i < n; i++) {
      if(!visited[i]) {
        visited[i] = true;
        arr[depth] = i;
        dfs(depth + 1, i + 1, arr);
        visited[i] = false;
      }
    }
  }
}
