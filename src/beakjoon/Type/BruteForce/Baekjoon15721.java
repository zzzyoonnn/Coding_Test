package beakjoon.Type.BruteForce;
/*
문제
- 중앙대학교 소프트웨어학부에 새로 입학한 19학번 새내기 일구는 
  새내기 새로 배움터에 가서 술게임을 여러 가지 배웠다. 
  그 중 가장 재미있었던 게임은 바로 번데기 게임이었다.
  번데기 게임의 규칙은 다음과 같다. 
  ‘뻔 – 데기 – 뻔 – 데기 – 뻔 – 뻔 – 데기 – 데기’ 를 1회차 문장이라고 하자. 
  2회차 문장은 ‘뻔 – 데기 – 뻔 - 데기 – 뻔 – 뻔 – 뻔 – 데기 – 데기 – 데기’가 된다. 
  즉 n-1회차 문장일 때는 ‘뻔 – 데기 – 뻔 – 데기 – 뻔(x n번) – 데기(x n번)’이 된다. 
  하이픈 사이를 지날 때마다 순서는 다음 사람으로 넘어간다. 
  원을 돌아 다시 일구 차례가 와도 게임은 계속 진행된다.
  일구와 동기들, 그리고 선배들을 포함한 사람 A명이 다음과 같이 원으로 앉아 있다고 가정하자. 
  일구가 0번째이고, 반 시계 방향으로 번데기 게임을 진행한다. 
  T번째 ‘뻔’ 또는 ‘데기’를 외치는 사람은 위 원에서 몇 번 사람인지를 구하여라. 
  (새내기는 10000번째가 되는 순간 시체방에 가기 때문에 T는 10000이하의 임의의 자연수이다.)
입력
- 첫째 줄에 게임을 진행하는 사람 A명이 주어진다. 
  A는 2,000보다 작거나 같은 자연수이다.
  둘째 줄에는 구하고자 하는 번째 T가 주어진다. (T ≤ 10000)
  셋째 줄에는 구하고자 하는 구호가 “뻔”이면 0, “데기”면 1로 주어진다. 
출력
- 첫째 줄에 구하고자 하는 사람이 원탁에서 몇 번째에 있는지 정수로 출력한다.
ex 1)
입력        출력
- 8         - 2
  2
  0
ex 2)
입력        출력
- 4         - 3
  6
  1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon15721 {
  static int a, t, k;
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    a = Integer.parseInt(br.readLine());    // 게임을 진행하는 사람 수
    t = Integer.parseInt(br.readLine());    // 구하고자 하는 번째
    k = Integer.parseInt(br.readLine());    // "뻔"이면 0, "데기"면 1

    System.out.println(solution());
  }

  static int solution() {
    int count = 2;
    int bbun = 0;
    int degi = 0;

    while (true) {
      // 처음 뻔-데기-뻔-데기 count
      for (int i = 0; i < 4; i++) {
        if (i % 2 == 0) bbun++;
        else degi++;

        // 총 인원은 a명이지만, 0번부터 count하기 때문에
        // 뻔이 나온 횟수와 데기가 나온 횟수는
        // 더한 값에 -1을 해준 전체 인원수로 나눈 값을 return
        if (bbun == t && k == 0)
          return (bbun + degi - 1) % a;     // 순환구조로 구현하기 위해 % a
        if (degi == t && k == 1)
          return (bbun + degi - 1) % a;     // 순환구조로 구현하기 위해 % a
      }

      // 이후 count만큼 반복되는 (뻔 * n) - (데기 * n) count 
      for (int i = 0; i < count; i++) {
        bbun++;
        if (bbun == t && k == 0)
          return (bbun + degi - 1) % a;
      }

      for (int i = 0; i < count; i++) {
        degi++;
        if (degi == t && k == 1)
          return (bbun + degi - 1) % a;
      }
      count++;
    }
  }
}
