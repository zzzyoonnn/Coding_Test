package beakjoon.algorithm.implementation;
/*
문제
- 올 골드 럭비 클럽의 회원들은 성인부 또는 청소년부로 분류된다.
  나이가 17세보다 많거나, 몸무게가 80kg 이상이면 성인부이다. 
  그 밖에는 모두 청소년부이다. 
  클럽 회원들을 올바르게 분류하라.
입력
- 각 줄은 이름과 두 자연수로 이루어진다. 
  두 자연수는 순서대로 나이와 몸무게를 나타낸다. 
  입력의 마지막 줄은 # 0 0 이다. 
  이 입력은 처리하지 않는다.
  이름은 알파벳 대/소문자로만 이루어져 있고, 길이는 10을 넘지 않는다.
출력
- 입력 받은 각 회원에 대해 이름과 분류를 출력한다. 
  성인부 회원이면 'Senior', 청소년부 회원이면 'Junior'를 출력한다.
ex 1)
입력            출력
- Joe 16 34     - Joe Junior
  Bill 18 65      Bill Senior
  Billy 17 65     Billy Junior
  Sam 17 85       Sam Senior
  # 0 0
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2083 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    boolean check;

    while (true) {
      st = new StringTokenizer(br.readLine());
      check = true;
      String name = st.nextToken();
      int age = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      if (name.equals("#") && age == 0 && weight == 0) break;

      if (age > 17) check = false;
      if (weight >= 80) check = false;

      if (check) System.out.println(name + " Junior");
      else System.out.println(name + " Senior");

    }
  }
}
