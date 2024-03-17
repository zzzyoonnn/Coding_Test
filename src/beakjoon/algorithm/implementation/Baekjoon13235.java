package beakjoon.algorithm.implementation;
/*
문제
- 팰린드롬은 앞에서부터 읽을 때와 뒤에서부터 읽을 때가 똑같은 단어를 의미한다. 
  예를 들어, eve, eevee는 팰린드롬이고, eeve는 팰린드롬이 아니다. 
  단어가 주어졌을 때, 팰린드롬인지 아닌지 판단해보자.
입력
- 길이가 20보다 작거나 같은 단어가 주어진다. 
  단어는 알파벳 소문자로 이루어져 있다.
출력
- 입력으로 주어진 단어가 팰린드롬이면 "true", 아니면 "false"를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon13235 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    boolean check = true;

    for (int i = 0; i < s.length() / 2; i++) {
      char left = s.charAt(i);
      char right = s.charAt(s.length() - 1 - i);

      if (left != right) {
        check = false;
        break;
      }
    }

    System.out.println(check);
  }
}
