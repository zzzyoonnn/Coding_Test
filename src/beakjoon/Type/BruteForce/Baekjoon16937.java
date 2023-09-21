package beakjoon.Type.BruteForce;
import java.io.BufferedReader;
/*
문제
- 크기가 H×W인 모눈종이와 스티커 N개가 있다. 
  i번째 스티커의 크기는 Ri×Ci이다. 
  모눈종이는 크기가 1×1인 칸으로 나누어져 있으며, 간격 1을 두고 선이 그어져 있다.
  오늘은 모눈종이에 스티커 2개를 붙이려고 한다. 
  스티커의 변은 격자의 선과 일치하게 붙여야 하고, 두 스티커가 서로 겹치면 안 된다. 
  단, 스티커가 접하는 것은 가능하다. 
  스티커를 90도 회전시키는 것은 가능하다. 
  스티커가 모눈종이를 벗어나는 것은 불가능하다.
  두 스티커가 붙여진 넓이의 최댓값을 구해보자.
입력
- 첫째 줄에 모눈종이의 크기 H, W, 둘째 줄에 스티커의 수 N이 주어진다. 
  다음 N개의 줄에는 스티커의 크기 Ri, Ci가 주어진다.
출력
- 첫째 줄에 두 스티커가 붙여진 넓이의 최댓값을 출력한다. 
  두 스티커를 붙일 수 없는 경우에는 0을 출력한다.
ex 1)
입력        출력
- 2 2       - 4
  2
  1 2
  2 1
ex 2)
입력        출력
- 10 9      - 56
  4
  2 3
  1 1
  5 10
  9 11
ex 3)
입력        출력
- 10 10     - 0
  3
  6 6
  7 7
  20 5
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16937 {
  static int h, w, n;
  static int[][] sticker;
  static int max_area;

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());   // 세로
    w = Integer.parseInt(st.nextToken());   // 가로
    n = Integer.parseInt(br.readLine());    // 스티커 수
    sticker = new int[n][3];

    for (int i = 0; i < n; i++) {   // 스티커 정보
      st = new StringTokenizer(br.readLine());
      sticker[i][0] = Integer.parseInt(st.nextToken());     // 스티커 가로
      sticker[i][1] = Integer.parseInt(st.nextToken());     // 스티커 세로
      sticker[i][2] = sticker[i][0] * sticker[i][1];    // 스티커 넓이
    }

    max_area = 0;

    calcMaxArea();

    System.out.println(max_area);
  }

  private static int calcMaxArea() {
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (attachSticker(sticker[i], sticker[j])) {
          max_area = Math.max(max_area, sticker[i][2] + sticker[j][2]);
        }
      }
    }
    return max_area;
  }

  private static boolean attachSticker(int[] a, int[] b) {
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        if (a[i] + b[j] <= h && Math.max(a[(i + 1) % 2], b[(i + 1) % 2]) <= w) return true;
        if (a[i] + b[j] <= w && Math.max(a[(i + 1) % 2], b[(i + 1) % 2]) <= h) return true;
      }
    }
    return false;
  }
}
