package beakjoon.algorithm.implementation;
/*
문제
- 2021년 5월 8일 SMUPC 대회의 첫 개최에 신이 난 화은이는 SMUPC를 기념하기 위해 
  "SMUPC"를 예술적으로 출력하는 프로그램을 작성하고자 했다. 
  화은이는 각 알파벳에 해당하는 아스키코드 값을 10진법으로 나타내었을 때, 
  각 자릿수의 합만큼 출력하도록 하는 프로그램을 만들고자 한다. 
  하지만 화은이는 지금 문제를 출제해야 해서 정신이 없다. 
  문제 출제로 정신이 없는 화은이를 위해 화은이가 만들고자 하는 프로그램을 대신 만들어 보자.
입력
- 첫 줄에 알파벳 소문자로만 이루어진 단어 S가 주어진다. 
  이때, 입력되는 S의 길이는 10을 넘지 않는다.
출력
- 단어 S의 각 문자에 대한 프로그램의 출력값을 각 줄별로 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon21734 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String s = br.readLine();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int n = c;

      int count = 0;
      while (n != 0) {
        count += n % 10;
        n /= 10;
      }

      while (count-- > 0) {
        sb.append(c);
      }

      sb.append('\n');
    }
    System.out.println(sb);
  }
}
