package beakjoon.algorithm.implementation;
/*
문제
- 한신이는 대학교에서 "복붙의 달인"으로 유명하다. 
  한신이는 타이핑 속도가 느리기 때문에 대학에서 가능한 모든 일을 복붙으로 해결한다. 
  그는 n개의 문자를 입력하는데 있어서 n초의 시간이 걸리지만 뛰어난 "붙여넣기" 스킬을 이용하면 
  어떠한 개수의 문자도 단 1초만에 타이핑 할 수 있다. 
  만약 한신이가 "bana"를 복사한 상태에서 "banana"를 타이핑한다면, 
  "bana" 붙여넣기 1초, 'n' 입력, 'a' 입력으로 총 3초가 걸린다. 
  한신이가 클립보드에 저장한 p를 알고 있을 때 s를 입력하는데 걸리는 최소 시간을 계산해보자!
입력
- 첫 번째 줄에는 테스트케이스의 개수 T(T ≤ 25)가 입력된다. 
  각 테스트케이스는 한 줄에 2개의 문자열 s와 p가 공백으로 구분되어 입력되며 
  한신이는 p를 복사하여 s를 만들어 내는 것을 목표로 한다. 
  s의 최대 길이는 10,000이고, p의 최대 길이는 100이다.
출력
- 각 테스트 케이스에 맞는 한신이가 p를 이용하여 s를 타이핑할 때 걸리는 최소 시간(초 단위)을 출력하라!
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11008 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    StringTokenizer st;
    String s, p;
    for (int tc = 0; tc < t; tc++) {
      st = new StringTokenizer(br.readLine());

      s = st.nextToken();       // 만들고 싶은 문자열
      p = st.nextToken();       // 복붙할 문자열

      int before = s.length();

      s = s.replace(p, "");

      int after = s.length();

      System.out.println((before - after) / p.length() + after);
    }
  }
}
