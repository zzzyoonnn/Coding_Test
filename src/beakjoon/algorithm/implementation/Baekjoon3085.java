package beakjoon.algorithm.implementation;
/*
문제
- 상근이는 어렸을 적에 "봄보니 (Bomboni)" 게임을 즐겨했다.
  가장 처음에 N×N크기에 사탕을 채워 놓는다. 
  사탕의 색은 모두 같지 않을 수도 있다. 
  상근이는 사탕의 색이 다른 인접한 두 칸을 고른다. 
  그 다음 고른 칸에 들어있는 사탕을 서로 교환한다. 
  이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다.
  사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 보드의 크기 N이 주어진다. (3 ≤ N ≤ 50)
  다음 N개 줄에는 보드에 채워져 있는 사탕의 색상이 주어진다. 
  빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y로 주어진다.
  사탕의 색이 다른 인접한 두 칸이 존재하는 입력만 주어진다.
출력
- 첫째 줄에 상근이가 먹을 수 있는 사탕의 최대 개수를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon3085 {
  static int max = 1;
  static int n;
  static char[][] board;

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    board = new char[n][n];

    String s;
    for (int i = 0; i < n; i++) {
      s = br.readLine();
      for (int j = 0; j < n; j++) {
        board[i][j] = s.charAt(j);
      }
    }

    // 행 변경
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - 1; j++) {
        swap(i, j, i, j + 1);
        search();
        swap(i, j + 1, i, j);
      }
    }

    // 열 변경
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n; j++) {
        swap(i, j, i + 1, j);
        search();
        swap(i + 1, j, i, j);
      }
    }

    System.out.println(max);
    br.close();
  }

  private static void swap(int x1, int y1, int x2, int y2) {
    char temp = board[x1][y1];
    board[x1][y1] = board[x2][y2];
    board[x2][y2] = temp;
  }

  private static void search() {
    // 행 탐색
    for (int i = 0; i < n; i++) {
      int count = 1;

      for (int j = 0; j < n - 1; j++) {
        if (board[i][j] == board[i][j + 1]) {
          count++;
        } else {
          count = 1;
        }
        max = Math.max(count, max);
      }
    }

    // 열 탐색
    for (int i = 0; i < n; i++) {
      int count = 1;

      for (int j = 0; j < n - 1; j++) {
        if (board[j][i] == board[j + 1][i]) {
          count++;
        } else {
          count = 1;
        }
        max = Math.max(count, max);
      }
    }
  }
}
