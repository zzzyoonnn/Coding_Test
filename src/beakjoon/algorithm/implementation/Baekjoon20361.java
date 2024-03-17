package beakjoon.algorithm.implementation;
/*
문제
- 전설의 야바위꾼 일우는 Shell Game으로 야바위를 한다. 
  Shell Game은 다음과 같은 절차로 진행된다.
    1. 진행자가 N개의 컵을 일렬로 놓고, 그 중 X번째 컵에 공을 숨겨둔다.
    2. 임의의 서로 다른 두 컵의 위치를 맞바꾼다. 이 항목을 K번 수행한다. 만약, 공을 숨겨둔 컵을 움직인다면 공도 그 컵을 따라서 움직인다.
    3. 참가자는 몇 번째 컵에 공이 숨겨져 있는지 추측한다.
    4. 그 컵에 공이 숨겨져 있다면 참가자가, 그렇지 않다면 진행자가 이긴다.
  수혁이는 Shell Game을 잘하고 싶다. 
  하지만, 일우가 진행자라면 무슨 수를 써도 이길 수 없어 수혁이는 일우의 사기도박을 의심하고 있다. 
  현재 우리는 수혁과 일우가 진행한 Shell Game의 모든 기록을 입수했다. 
  이를 바탕으로, 일우가 사기도박을 하지 않았다면 공이 몇 번째 컵에 있는지 알려주는 프로그램을 작성하자.
입력
- 첫째 줄에 N (3 ≤ N ≤ 200,000), X (1 ≤ X ≤ N), K (1 ≤ K ≤ 100,000)가 공백으로 구분되어 주어진다.
  둘째 줄부터 K개의 줄에는 순서대로 바꾼 두 컵의 위치 Ai, Bi (1 ≤ Ai, Bi ≤ N, Ai ≠ Bi)가 공백으로 구분되어 주어진다.
  주어지는 모든 입력은 정수다.
출력
- 일우가 사기도박을 하지 않았다면, 공이 몇 번째 위치의 컵에 있어야 하는지 정수로 출력하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon20361 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());   // 컵의 개수
    int x = Integer.parseInt(st.nextToken());   // 공 숨길 컵
    int k = Integer.parseInt(st.nextToken());   // 컵 위치 변경 수행 횟수

    boolean[] cup = new boolean[n + 1];
    cup[x] = true;

    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int pick1 = Integer.parseInt(st.nextToken());
      int pick2 = Integer.parseInt(st.nextToken());

      boolean temp = cup[pick1];
      cup[pick1] = cup[pick2];
      cup[pick2] = temp;
    }

    for (int i = 1; i < cup.length; i++) {
      if (cup[i]) System.out.println(i);
    }
  }
}
