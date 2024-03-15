package beakjoon.algorithm.implementation;
/*
문제
- 가위 바위 보는 두 명이서 하는 게임이다. 
  보통 미리 정해놓은 수 만큼 게임을 하고, 많은 게임을 이긴 사람이 최종 승자가 된다.
  가위 바위 보를 한 횟수와 매번 두 명이 무엇을 냈는지가 주어졌을 때, 최종 승자를 출력하는 프로그램을 작성하시오.
    바위는 가위를 이긴다.
    가위는 보를 이긴다.
    보는 바위를 이긴다.
입력
- 첫째 줄에는 테스트 케이스의 개수 t(0 < t < 1000)가 주어진다. 
  각 테스트 케이스의 첫째 줄에는 가위 바위 보를 한 횟수 n(0 < n < 100)이 주어진다. 
  다음 n개의 줄에는 R, P, S가 공백으로 구분되어 주어진다. 
  R, P, S는 순서대로 바위, 보, 가위이고 첫 번째 문자는 Player 1의 선택, 두 번째 문자는 Player 2의 선택이다.
출력
- 각 테스트 케이스에 대해서 승자를 출력한다. (Player 1 또는 Player 2) 
  만약, 비겼을 경우에는 TIE를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon4493 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());    // 테스트 케이스의 개수
    int n;
    StringTokenizer st;

    for (int tc = 0; tc < t; tc++) {
      n = Integer.parseInt(br.readLine());      // 가위 바위 보를 한 횟수

      int win1 = 0;
      int win2 = 0;

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        String p1 = st.nextToken();
        String p2 = st.nextToken();

        if (p1.equals("R")) {
          if (p2.equals("S")) win1++;
          else if (p2.equals("P")) win2++;

        } else if (p1.equals("S")) {
          if (p2.equals("P")) win1++;
          else if (p2.equals("R")) win2++;

        } else if (p1.equals("P")) {
          if (p2.equals("R")) win1++;
          else if (p2.equals("S")) win2++;
        }
      }

      if (win1 > win2) System.out.println("Player 1");
      else if (win1 == win2) System.out.println("TIE");
      else if (win1 < win2) System.out.println("Player 2");
    }
  }
}
