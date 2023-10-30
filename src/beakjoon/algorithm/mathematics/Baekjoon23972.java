package beakjoon.algorithm.mathematics;
/*
문제
- 어느 날, 민주는 꿈에서 악마를 만나게 되었다. 
  악마는 자신에게 K원을 지불하면, 지불하고 남은 금액을 N배로 만들어준다고 한다.
  민주는 자신이 최소 몇 원을 가지고 있어야 악마에게 K원을 지불했을 때 손해를 보지 않는지 알고 싶다.
  악마가 제안한 K와 N이 주어졌을 때, 민주가 손해 보지 않기 위해 가지고 있어야 하는 최소 금액 X를 구해주자. 
  단, 금액은 정수여야 한다.
입력
- 첫째 줄에 악마가 제안한 정수 K와 N이 공백을 사이에 두고 주어진다. (1 ≤ K, N ≤ 200,000,000)
출력
- 민주가 손해 보지 않기 위해 가지고 있어야 하는 최소 금액 X를 출력한다.
  항상 민주가 손해를 보게 된다면 -1을 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon23972 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long k = Long.parseLong(st.nextToken());
    long n = Long.parseLong(st.nextToken());

    long result = -1l;
    if (n != 1l) {
      result = k * n / (n - 1l);
      if (k * n % (n - 1) != 0l) result++;
    }
    System.out.println(result);
  }
}
