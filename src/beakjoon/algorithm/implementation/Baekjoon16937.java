package beakjoon.algorithm.implementation;
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
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16937 {
  static int h, w, n;
  static int[][] sticker;
  static int max_area = 0;

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());    // 모눈 종이의 크기
    h = Integer.parseInt(st.nextToken());   // 모눈 종이 h
    w = Integer.parseInt(st.nextToken());   // 모눈 종이 w

    n = Integer.parseInt(br.readLine());    // 스티커 갯수

    sticker = new int[n][3];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      sticker[i][0] = Integer.parseInt(st.nextToken());     // i번째 스티커 가로 길이
      sticker[i][1] = Integer.parseInt(st.nextToken());     // i번째 스티커 세로 길이
      sticker[i][2] = sticker[i][0] * sticker[i][1];        // i번째 스티커 넓이
    }

    calcMaxArea();

    System.out.println(max_area);
  }

  private static int calcMaxArea() {
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (attachSticker(sticker[i], sticker[j])) {    // 스티커 두 개를 붙일 수 있다면...
          max_area = Math.max(max_area, sticker[i][2] + sticker[j][2]);
        }
      }
    }
    return max_area;
  }

  private static boolean attachSticker(int[] i, int[] j) {  // 스티커 두 개 붙일 수 있는지 확인
    for (int a = 0; a < 2; a++) {
      for (int b = 0; b < 2; b++) {
        // 스티커 i와 j를 세로로 붙였을 때
        if (i[a] + j[b] <= h && Math.max(i[(a + 1) % 2], j[(b + 1) % 2]) <= w) return true;

        // 스티커 i와 j를 가로로 붙였을 때
        if (i[a] + j[b] <= w && Math.max(i[(a + 1) % 2], j[(b + 1) % 2]) <= h) return true;
      }
    }
    return false;
  }
}
