package beakjoon.algorithm.implementation;
/*
문제
- 욱제는 귀여운 수~ε٩(๑> ₃ <)۶з를 좋아한다. 
  귀여운 수~ε٩(๑> ₃ <)۶з는 수를 이루는 각 자릿수가 등차수열[*]을 이루는 수이다. 
  당신은 욱제한테 귀여운 수~ε٩(๑> ₃ <)۶з 하나를 선물해주고 싶다. 
  수 하나가 주어졌을 때 이 수가 귀여운지 판단하는 프로그램을 짜 보자.
  [*] 등차수열을 이루는 숫자들은, 
  왼쪽에서 오른쪽으로 가면서 일정한 크기(0일 수도 있음)만큼 커지거나 일정한 크기만큼 작아진다. 
  뭔지 모르겠으면 예제를 보고 알아보자. ㅋㅋ!
입력
- 정수 k(1 ≤ k ≤ 10^18)가 주어진다. 
  입력은 0으로 시작하지 않는다.
출력
- 수가 귀여우면 "◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!"를, 귀엽지 않으면 "흥칫뿡!! <(￣ ﹌ ￣)>"를 따옴표 없이 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Baekjoon17294 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long k = Long.parseLong(br.readLine());
    LinkedList<Integer> list = new LinkedList<>();
    boolean check = true;

    while (k > 0) {
      list.add((int) (k % 10));     // LinkedList에 한 글자씩 삽입
      k /= 10;
    }

    if (list.size() > 1) {
      int temp = list.get(1) - list.get(0);     // 등차수열 확인용

      for (int i = 1; i < list.size(); i++) {       // 등차수열 확인
        if (list.get(i) - list.get(i - 1) != temp) check = false;   // 등차수열이 아니면 check = false;
      }
    }

    if (check) System.out.println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
    else System.out.println("흥칫뿡!! <(￣ ﹌ ￣)>");
  }
}
