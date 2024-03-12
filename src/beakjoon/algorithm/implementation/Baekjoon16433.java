package beakjoon.algorithm.implementation;
/*
문제
- 주디는 오랜만에 부모님이 살고 계시는 농장을 방문하여 일손을 돕기로 하였습니다.
  주디가 할 일은 N × N 격자 모양의 밭에 당근을 심는 일입니다. 
  각 칸에는 최대 하나의 당근을 심을 수 있는데 어떤 칸에 당근이 심겨 있으면 
  그 칸의 변을 공유하는 칸들에는 당근을 심을 수 없습니다.
  주디는 이미 위치가 (R, C) 인 칸에 당근을 하나 심었고 나머지 칸에도 당근을 심으려고 합니다. 
  주디가 최대한 많은 당근을 심었을 때 밭이 어떤 모양일지 알려주세요. 
  주디는 심을 당근을 무한히 가지고 있다고 가정합니다.
입력
- 첫 번째 줄에 N, R, C (2 ≤ N ≤ 99, 1 ≤ R, C ≤ N) 가 주어집니다.
출력
- 첫 번째 줄부터 N번째 줄까지 각 줄에 길이가 N인 문자열을 출력합니다.
  i행 j열에 당근이 심어졌다면 i번째 줄 j번째 문자를 'v' 로 표시하며 심어지지 않았다면 '.' 로 표시합니다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16433 {
  static int n;

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());   // 밭 크기
    int r = Integer.parseInt(st.nextToken());   // 당근 위치
    int c = Integer.parseInt(st.nextToken());   // 당근 위치

    if ((r + c) % 2 == 0) {
      for (int i = 0; i < n; i++) {
        if (i % 2 == 0) {
          carrot();
        } else {
          dot();
        }
      }
    } else {
      for (int i = 0; i < n; i++) {
        if (i % 2 == 0) {
          dot();
        } else {
          carrot();
        }
      }
    }
  }

  private static void dot() {
    for (int i = 0; i < n; i++) {
      if (i % 2 == 0) System.out.print(".");
      else System.out.print("v");
    }
    System.out.println();
  }

  private static void carrot() {
    for (int i = 0; i < n; i++) {
      if (i % 2 == 0) System.out.print("v");
      else System.out.print(".");
    }
    System.out.println();
  }
}
