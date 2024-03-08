package beakjoon.algorithm.implementation;
/*
문제
- 문자열 s가 있을 때, f(s)는 s를 무한번 붙인 문자열로 정의한다. 
  예를 들어, s = "abc" 인 경우에 f(s) = "abcabcabcabc..."가 된다.
  다른 문자열 s와 t가 있을 때, f(s)와 f(t)가 같은 문자열인 경우가 있다. 
  예를 들어서, s = "abc", t = "abcabc"인 경우에 f(s)와 f(t)는 같은 문자열을 만든다.
  s와 t가 주어졌을 때, f(s)와 f(t)가 같은 문자열을 만드는지 아닌지 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 s, 둘째 줄에 t가 주어진다. 
  두 문자열 s와 t의 길이는 50보다 작거나 같은 자연수이고, 알파벳 소문자로만 이루어져 있다. 
출력
- 첫째 줄에 f(s)와 f(t)가 같으면 1을, 다르면 0을 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon12871 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    String t = br.readLine();

    int sl = s.length();
    int tl = t.length();

    int n = lcm(sl, tl);

    String fs = s;
    String ft = t;

    for (int i = 1; i < n / sl; i++) {
      fs += s;
    }

    for (int i = 1; i < n / tl; i++) {
      ft += t;
    }

    if (fs.equals(ft)) System.out.println(1);
    else System.out.println(0);
  }

  public static int gcd (int a, int b) {
    if (a % b == 0) return b;
    return gcd (b, a % b);
  }

  public static int lcm (int a, int b) {
    return a * b / gcd(a, b);
  }
}
