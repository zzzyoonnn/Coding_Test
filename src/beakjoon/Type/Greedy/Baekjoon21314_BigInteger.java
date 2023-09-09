package beakjoon.Type.Greedy;
/*
문제
- 민겸이는 로마 숫자를 보고 굉장히 흥미롭다고 생각했다. 
  그래서 민겸이는 새로운 수 체계인 민겸 수를 창조했다.
  민겸 숫자는 0 이상의 정수 N에 대해 10^N 또는 5 × 10^N 꼴의 십진수를 
  대문자 M과 K로 이루어진 문자열로 표기한다. 
  10^N 꼴의 십진수는 N + 1개의 M으로, 
  5 × 10^N 꼴의 십진수는 N개의 M 뒤에 1개의 K를 이어붙인 문자열로 나타낸다. 
  즉, 아래 표처럼 나타낼 수 있다.
    변환 전    변환 후
       1          M
       5          K
       10         MM
       50         MK
       100        MMM
       500        MMK
       1000       MMMM
       5000       MMMK
       ...        ...
  민겸이는 위와 같이 하나의 민겸 수가 다양한 십진수로 변환될 수 있다는 사실을 알았다. 
  문득 민겸이는 변환될 수 있는 십진수 중 가장 큰 값과 가장 작은 값이 궁금해졌다. 
  민겸이를 위해 하나의 민겸 수가 십진수로 변환되었을 때 가질 수 있는 최댓값과 최솟값을 구해주자.
입력
- 민겸 수 하나가 주어진다. 
  민겸 수는 대문자 M과 K로만 이루어진 문자열이며, 길이는 3,000을 넘지 않는다.
출력
- 주어진 민겸 수가 십진수로 변환되었을 때 가질 수 있는 값 중 가장 큰 값과 가장 작은 값을 두 줄로 나누어 출력한다.
ex 1)
입력        출력
- MKM       - 501
              151
ex 2)
입력        출력
- MKKMMK    - 505500
              155105
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Baekjoon21314_BigInteger {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    String max = "";
    String min = "";
    BigInteger m = BigInteger.ZERO;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'M') m = m.add(BigInteger.ONE);
      else if (s.charAt(i) == 'K') {
        if (m.compareTo(BigInteger.ZERO) > 0) {
          max += String.valueOf(BigInteger.TEN.pow(m.intValue()).multiply(BigInteger.valueOf(5)));
          min += String.valueOf(BigInteger.TEN.pow(m.intValue()).add(BigInteger.valueOf(5)));
        } else {
          max += "5";
          min += "5";
        }
        m = BigInteger.ZERO;
      }
    }

    if (m.compareTo(BigInteger.ZERO) > 0) {
      min += String.valueOf(BigInteger.TEN.pow(m.intValue() - 1));
      while (m.compareTo(BigInteger.ZERO) > 0) {
        max += "1";
        m = m.subtract(BigInteger.ONE);
      }
    }
    System.out.println(max);
    System.out.println(min);
  }
}
