package beakjoon.algorithm.implementation;
/*
문제
- 평면상에 세 개의 점이 주어지면, 그 세 점으로 이루어지는 삼각형은 유일하게 결정된다. 
  또는, 삼각형이 이루어지지 않기도 한다. 
  세 점의 좌표가 주어졌을 때 다음에 따라 이 삼각형의 종류를 판단하는 프로그램을 작성하시오.
    1. 세 점이 일직선 위에 있으면 - ‘삼각형이 아님’  출력할 때는 X
    2. 세 변의 길이가 같으면 - ‘정삼각형’ 출력할 때는 JungTriangle
    3. 두 변의 길이가 같으면
      1. 가장 큰 각이 90°보다 크면 - ‘둔각이등변삼각형’ 출력할 때는 Dunkak2Triangle
      2. 가장 큰 각이 90°이면 - ‘직각이등변삼각형’ 출력할 때는 Jikkak2Triangle
      3. 가장 큰 각이 90°보다 작으면 - ‘예각이등변삼각형’ 출력할 때는 Yeahkak2Triangle
    4. 세 변의 길이가 모두 다르면
      1. 가장 큰 각이 90°보다 크면 - ‘둔각삼각형’ 출혁할 때는 DunkakTriangle
      2. 가장 큰 각이 90°이면 - ‘직각삼각형’ 출력할 때는 JikkakTriangle
      3. 가장 큰 각이 90°보다 작으면 - ‘예각삼각형’ 출력할 때는 YeahkakTriangle
입력
- 첫째 줄부터 셋째 줄까지 삼각형을 이루는 점의 x좌표와 y좌표가 빈칸을 사이에 두고 주어진다. 
  입력되는 수는 절댓값이 10,000을 넘지 않는 정수이다. 
  입력으로 주어지는 세 좌표는 중복되지 않는다.
출력
- 위의 경우에 따라 삼각형의 종류가 무엇인지 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1925 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[][] spot = new int[3][2];

    for (int i = 0; i < 3; i++) {   // i = 0 → a, i = 1 → b, i = 2 → c

    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    int ax = Integer.parseInt(st.nextToken());  // 점 a의 x좌표
    int ay = Integer.parseInt(st.nextToken());  // 점 a의 y좌표

    st = new StringTokenizer(br.readLine());
    int bx = Integer.parseInt(st.nextToken());  // 점 b의 x좌표
    int by = Integer.parseInt(st.nextToken());  // 점 b의 y좌표

    st = new StringTokenizer(br.readLine());
    int cx = Integer.parseInt(st.nextToken());  // 점 c의 x좌표
    int cy = Integer.parseInt(st.nextToken());  // 점 c의 y좌표

    if ((ay - by) * (bx - cx) == (by - cy) * (ax - bx)) {   // 기울기 구하는 공식을 분수가 아닌 곱셈으로 구하여 비교
      System.out.println("X");
      System.exit(0);
    }


    double A = calcLength(bx, by, cx, cy);
    double B = calcLength(ax, ay, cx, cy);
    double C = calcLength(ax, ay, bx, by);

    findTriangle(A, B, C);
  }

  static double calcLength(int ix, int iy, int jx, int jy) {    // 변의 길이 구하는 메서드
    return Math.pow(ix - jx, 2) + Math.pow(iy - jy, 2);     // 변의 길이 구하기
  }

  static void findTriangle(double A, double B, double C) {
    if (A == B && A == C) {
      System.out.println("JungTriangle");   // 세 변의 길이가 같다면

    } else if (A == B || A == C || B == C) {   // 두 변의 길이가 같다면
      if (A >= B && A >= C) check2(A, B, C);        // A변의 길이가 가장 길다면
      else if (B >= A && B >= C) check2(B, A, C);   // B변의 길이가 가장 길다면
      else if (C >= A && C >= B) check2(C, A, B);   // C변의 길이가 가장 길다면

    } else {    // 세 변의 길이가 모두 다르다면
      if (A >= B && A >= C) check(A, B, C);        // A변의 길이가 가장 길다면
      else if (B >= A && B >= C) check(B, A, C);   // B변의 길이가 가장 길다면
      else if (C >= A && C >= B) check(C, A, B);   // C변의 길이가 가장 길다면
    }
  }

  static void check2(double max, double i, double j) {  // 두 변의 길이가 같다면
    if (i + j == max) System.out.println("Jikkak2Triangle");
    else if (i + j < max) System.out.println("Dunkak2Triangle");
    else System.out.println("Yeahkak2Triangle");
  }

  static void check(double max, double i, double j) {  // 세 변의 길이가 모두 다르다면
    if (i + j == max) System.out.println("JikkakTriangle");
    else if (i + j < max) System.out.println("DunkakTriangle");
    else System.out.println("YeahkakTriangle");
  }
}
