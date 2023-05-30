package beakjoon.algorithm.greedy;
/*
문제
- 상근이는 2863번에서 표를 너무 열심히 돌린 나머지 5와 6을 헷갈리기 시작했다.
  상근이가 숫자 5를 볼 때, 5로 볼 때도 있지만, 
  6으로 잘못 볼 수도 있고, 6을 볼 때는, 6으로 볼 때도 있지만, 5로 잘못 볼 수도 있다.
  두 수 A와 B가 주어졌을 때, 상근이는 이 두 수를 더하려고 한다. 
  이때, 상근이가 구할 수 있는 두 수의 가능한 합 중, 
  최솟값과 최댓값을 구해 출력하는 프로그램을 작성하시오.
입력
- 첫째 줄에 두 정수 A와 B가 주어진다. (1 <= A,B <= 1,000,000)
출력
- 첫째 줄에 상근이가 구할 수 있는 두 수의 합 중 최솟값과 최댓값을 출력한다.
ex 1)
입력      출력
- 11 25   - 36 37
ex 2)
입력            출력
- 1430 4862     - 6282 6292
ex 3)
입력            출력
- 16796 58786   - 74580 85582
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2864 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    String a = st.nextToken();
    String b = st.nextToken();

    StringBuilder minA = new StringBuilder();
    StringBuilder maxA = new StringBuilder();
    StringBuilder minB = new StringBuilder();
    StringBuilder maxB = new StringBuilder();

    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) == '5') {
        maxA.append("6");
      } else {
        maxA.append(a.charAt(i));
      }
      if (a.charAt(i) == '6') {
        minA.append("5");
      } else {
        minA.append(a.charAt(i));
      }
    }

    for (int i = 0; i < b.length(); i++) {
      if (b.charAt(i) == '5') {
        maxB.append("6");
      } else {
        maxB.append(b.charAt(i));
      }
      if (b.charAt(i) == '6') {
        minB.append("5");
      } else {
        minB.append(b.charAt(i));
      }
    }

    int min = Integer.parseInt(minA.toString()) + Integer.parseInt(minB.toString());
    int max = Integer.parseInt(maxA.toString()) + Integer.parseInt(maxB.toString());

    System.out.println(min + " " + max);
  }
}
