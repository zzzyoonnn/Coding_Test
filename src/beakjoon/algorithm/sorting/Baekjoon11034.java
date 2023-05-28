package beakjoon.algorithm.sorting;
/*
문제
- 캥거루 세 마리가 사막에서 놀고 있다. 
  사막에는 수직선이 하나 있고, 캥거루는 서로 다른 한 좌표 위에 있다.
  한 번 움직일 때, 바깥쪽의 두 캥거루 중 한 마리가 다른 두 캥거루 사이의 정수 좌표로 점프한다. 
  한 좌표 위에 있는 캥거루가 두 마리 이상일 수는 없다.
  캥거루는 최대 몇 번 움직일 수 있을까?
입력
- 여러개의 테스트 케이스로 이루어져 있으며, 
  세 캥거루의 초기 위치 A, B, C가 주어진다. (0 < A < B < C < 100)
출력
- 각 테스트에 대해 캥거루가 최대 몇 번 움직일 수 있는지 출력한다.
ex 1)
입력            출력
- 2 3 5         - 1
  3 5 9           3
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11034 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str;

    while ((str = br.readLine()) != null) {
      StringTokenizer st = new StringTokenizer(str);
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      int max = Math.max(b - a, c - b);

      System.out.println(max - 1);    
    }
  }
}
