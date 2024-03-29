package beakjoon.algorithm.implementation;
/*
문제
- 엑셀의 첫 번째 열은 A이고, 두 번째 열은 B이고, 26번째 열은 Z이다. 
  26번째 열 다음 열부터는 2글자를 이용한다. 
  예를 들어, 27번째 열은 AA이고, 28번째 열은 AB, 52번째 열은 AZ이다. 
  그 다음 53번째 열은 BA이며, 이와 같이 계속 열의 이름을 붙인다.
  ZZ열 다음 열은 AAA가 되고, 그 다음은 AAB가 된다.
  엑셀에서 행은 그냥 행 번호를 사용하면 된다.
  엑셀 스프레드시트에서 각 칸은 위에서 설명한 열과 행을 합쳐서 이름을 만들 수 있다. 
  가장 왼쪽 위에 있는 칸은 A1이 되고, 55열 23행에 있는 칸은 BC23이 된다.
  열과 행이 주어졌을 때, 그 칸의 엑셀 스프레드시트 상에서 이름을 출력하는 프로그램을 작성하시오.
입력
- 입력은 여러 줄이며, RnCm형태이다. 
  n은 행 번호 (1 <= n <= 300000000), m은 열 번호 (1 <= m <= 300000000) 이다. 
  입력의 마지막은 n과 m이 모두 0이며, 이때는 출력하지 않고 프로그램을 종료하면 된다.
출력
- 각 입력을 순서대로 한 줄에 하나씩 엑셀 스프레드시트 상에서의 이름을 출력하면 된다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2757 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s;
    while (true) {
      s = br.readLine();

      int r = Integer.parseInt(s.substring(1, s.indexOf('C')));
      int c = Integer.parseInt(s.substring(s.indexOf('C') + 1, s.length()));

      if (r == 0 && c == 0) break;

      String column = "";

      while (c > 0) {
        column += (char)((c % 26) - 1 + 'A');
        System.out.println(column);

        c /= 26;
      }

      System.out.println(r + " " + c);
    }

  }
}
