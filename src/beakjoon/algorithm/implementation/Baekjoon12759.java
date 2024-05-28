package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon12759 {
  static int x, y, winnerNum, totalTikTakToe;
  static boolean check;
  static int[][] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int player = Integer.parseInt(br.readLine());       // O(1)
    check = true;

    if (player == 1) check = true;  // 1번 플레이어
    else check = false;             // 2번 플레이어

    // 틱택토 보드 O(1)
    arr = new int[4][4];
    StringTokenizer st;
    for (int i = 0; i < 9; i++) {
      st = new StringTokenizer(br.readLine());  // O(1)

      // 틱택토 위치 O(1)
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());

      if (check) {      // 1번 플레이어 차례라면 O(1)
        arr[x][y] = 1;
      } else {
        arr[x][y] = 2;
      }

      // 틱택토가 가능한지 확인 O(1)
      if (i >= 4) tiktaktoe(x, y, check);

      check = !check;
    }

    // 승부가 나지 않을 경우(무승부), 0 출력 O(1)
    System.out.println(0);
  }

  public static void tiktaktoe(int x, int y, boolean check) {
    // 가로 틱택토 O(1)
    if (arr[x][1] == arr[x][2] && arr[x][1] == arr[x][3]) {
      winner(check);
    }

    // 세로 틱택토 O(1)
    if (arr[1][y] == arr[2][y] && arr[1][y] == arr[3][y]) {
      winner(check);
    }

    // 대각선 틱택토 O(1)
    if (arr[1][1] == arr[2][2] && arr[1][1] == arr[3][3] && arr[2][2] != 0) {
      winner(check);
    }

    // 대각선 틱택토 O(1)
    if (arr[3][1] == arr[2][2] && arr[3][1] == arr[1][3] && arr[2][2] != 0) {
      winner(check);
    }
  }

  public static void winner(boolean check) {
    if (check) System.out.println(1);   // O(1)
    else System.out.println(2);         // O(1)

    System.exit(0);
  }
}
