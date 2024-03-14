package beakjoon.algorithm.implementation;
/*
문제
- 임한수와 임문빈은 서로 사랑하는 사이이다.
  임한수는 세상에서 팰린드롬인 문자열을 너무 좋아하기 때문에, 
  둘의 백일을 기념해서 임문빈은 팰린드롬을 선물해주려고 한다.
  임문빈은 임한수의 영어 이름으로 팰린드롬을 만들려고 하는데, 
  임한수의 영어 이름의 알파벳 순서를 적절히 바꿔서 팰린드롬을 만들려고 한다.
  임문빈을 도와 임한수의 영어 이름을 팰린드롬으로 바꾸는 프로그램을 작성하시오.
입력
- 첫째 줄에 임한수의 영어 이름이 있다. 
  알파벳 대문자로만 된 최대 50글자이다.
출력
- 첫째 줄에 문제의 정답을 출력한다. 
  만약 불가능할 때는 "I'm Sorry Hansoo"를 출력한다. 
  정답이 여러 개일 경우에는 사전순으로 앞서는 것을 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Baekjoon1213 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    TreeMap<Character, Integer> map = new TreeMap<>();  // 정답이 여러 개일 경우 사전순으로 출력

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (map.containsKey(c)) map.replace(c, map.get(c) + 1);
      else map.put(c, 1);
    }

    StringBuilder sb = new StringBuilder();
    int check = 0;      // 글자수가 홀수인 문자의 갯수 확인용
    // 홀수번 나타난 문자가 2개 이상이라면 펠린드롬 불가능(1개일 시, 중앙에 위치 가능)

    for (char c : map.keySet()) {

      for (int j = 0; j < map.get(c) / 2; j++) {    // 절반의 앞부분 출력
        sb.append(c);
      }

      if (map.get(c) % 2 != 0) check++;     // 홀수번 나타난 문자가 있다면 check++
    }

    if (check > 1) {    // 홀수번 나타난 문자가 2개 이상이라면 펠린드롬 불가능
      System.out.println("I'm Sorry Hansoo");
      System.exit(0);
    }

    String Sb = sb.toString();      // StringBuilder 문자열로 변경

    for (char c : map.keySet()) {
      if (map.get(c) % 2 != 0) Sb += c;     // 펠린드롬이 가능하고 홀수번 나타난 문자가 있다면 문자열 중앙에 위치
    }

    String reverseSb = sb.reverse().toString(); // 문자열의 시작부터 중앙까지 reverse하여 반대로 뒤집음
    // StringBuilder를 뒤집는 것이기에 홀수번 나타난 문자가 있어도 포함 X

    System.out.println(Sb + reverseSb);
  }
}
