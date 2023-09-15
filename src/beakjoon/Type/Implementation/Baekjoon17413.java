package beakjoon.Type.Implementation;
/*
문제
- 문자열 S가 주어졌을 때, 이 문자열에서 단어만 뒤집으려고 한다.
  먼저, 문자열 S는 아래와과 같은 규칙을 지킨다.
    1. 알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
    2. 문자열의 시작과 끝은 공백이 아니다.
    3. '<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다. 또, 두 문자의 개수는 같다.
  태그는 '<'로 시작해서 '>'로 끝나는 길이가 3 이상인 부분 문자열이고, 
  '<'와 '>' 사이에는 알파벳 소문자와 공백만 있다. 
  단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다. 
  태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다.
입력
- 첫째 줄에 문자열 S가 주어진다. 
  S의 길이는 100,000 이하이다.
출력
- 첫째 줄에 문자열 S의 단어를 뒤집어서 출력한다.
ex 1)
입력
- baekjoon online judge 
출력
- noojkeab enilno egduj
ex 2)
입력
- <open>tag<close>
출력
- <open>gat<close>
ex 3)
입력
- <ab cd>ef gh<ij kl>
출력
- <ab cd>fe hg<ij kl>
ex 4)
입력
- one1 two2 three3 4fourr 5five 6six
출력
- 1eno 2owt 3eerht rruof4 evif5 xis6
ex 5)
입력
- <int><max>2147483647<long long><max>9223372036854775807
출력
- <int><max>7463847412<long long><max>7085774586302733229
ex 6)
입력
- <problem>17413<is hardest>problem ever<end>
출력
- <problem>31471<is hardest>melborp reve<end>
ex 7)
입력
- <   space   >space space space<    spa   c e>
출력
- <   space   >ecaps ecaps ecaps<    spa   c e>
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon17413 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    StringBuilder sb = new StringBuilder();
    boolean check = false;

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '<') {
        while (!stack.isEmpty()) {
          sb.append(stack.pop());   // 스택에 저장된 문자들을 빌더에 역순으로 추가
        }
        check = true;
      } else if (s.charAt(i) == '>') {
        check = false;
        sb.append(s.charAt(i));
        continue;
      }

      if (check) {
        sb.append(s.charAt(i));     // < 태그 내부에 있는 문자로 간주하여 빌더에 추가
      } else {
        if (s.charAt(i) == ' ') {
          while (!stack.isEmpty()) {
            sb.append(stack.pop());     
          }
          sb.append(' ');   // 공백 문자를 추가하여 원래 단어 간 공백 유지
          continue;
        } else {
          stack.push(s.charAt(i));      // < 태그 외부에 있는 문자로 간주하여 스택에 추가
        }
      }

      if (i == s.length() - 1) {    // 루프 종료 후 스택에 남은 문자 처리
        while (!stack.isEmpty()) {
          sb.append(stack.pop());
        }
      }
    }
    System.out.println(sb);
  }
}
