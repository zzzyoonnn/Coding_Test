package beakjoon.algorithm.mathematics;
/*
문제
- 과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 
  주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.
입력
- 입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다. 
  각 테스트케이스는 모두 30,000보다 작은 양의 정수로 주어지며, 각 입력은 변의 길이를 의미한다.
출력
- 각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력한다.
ex 1)
입력            출력
- 6 8 10        - right
  25 52 60        wrong
  5 12 13         right
  0 0 0
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon4153 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      if (a == 0 && b == 0 && c == 0) break;

      if ((a * a + b * b) == c * c) System.out.println("right");
      else if ((b * b + c * c) == a * a) System.out.println("right");
      else if ((a * a + c * c) == b * b) System.out.println("right");
      else System.out.println("wrong");
    }
  }
}
