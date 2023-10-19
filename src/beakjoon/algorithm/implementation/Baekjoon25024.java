package beakjoon.algorithm.implementation;
/*
문제
- 어느 날 시계를 본 경근이는 시간이 8시 14분인 것을 보고 놀랐다. 
  왜냐하면 그의 생일은 8월 14일이기 때문이다. 
  그리고 이 경험을 바탕으로 다음과 같은 문제를 만들었다
   : 두 정수 x, y가 주어질 때, 
     x시 y분으로 읽는 것이 가능한지의 여부를 판단하면서, 
     x월 y일로 읽는 것이 가능한지의 여부를 판단하는 프로그램을 작성하라.
  시는 0시에서 23시까지, 분은 0분에서 59분까지가 유효하며, 월은 1월에서 12월까지가 유효하다. 
  1월, 3월, 5월, 7월, 8월, 10월, 12월은 1일에서 31일까지가 유효하고, 
  4월, 6월, 9월, 11월은 1일에서 30일까지가 유효하며, 2월은 1일에서 29일까지가 유효하다.
입력
- 첫 번째 줄에 테스트 케이스의 개수 T (1 ≤ T ≤ 10^4)가 주어진다.
  각 테스트 케이스는 한 줄로 구성되어, 두 정수 x, y (0 ≤ x, y ≤ 99)가 공백 하나로 구분되어 주어진다.
출력
- 각 테스트케이스 마다 두 문자열을 공백 하나로 구분하여 출력한다. 
  첫 번째 문자열은 두 정수 x, y를 x시 y분으로 읽는 것이 가능하면 “Yes”, 가능하지 않으면 “No”여야 한다. 
  두 번째 문자열은 두 정수 x, y를 x월 y일로 읽는 것이 가능하면 “Yes”, 가능하지 않으면 “No”여야 하다.
  따옴표는 제외하고 출력되어야 하며, 정답과 맞지 않더라도 두 문자열이 모두 출력되어야 제대로 된 채점이 가능하다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon25024 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st;
    StringBuilder sb;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      sb = new StringBuilder();
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      if (x >= 0 && x < 24 && y >= 0 && y < 60) sb.append("Yes ");
      else sb.append("No ");
      int[] arr = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      if (x >= 1 && x <= 12 && y >= 1 && y <= arr[x]) sb.append("Yes");
      else sb.append("No");
      System.out.println(sb);
    }
  }
}
