package beakjoon.algorithm.implementation;
/*
문제
- 1루수가 누구인지 밝혀내는 과정에서, 2루수가 거짓말을 하고 있다는 사실이 드러났다!
  이에 극대노한 선수들은 2루수를 찾아내어 혼내주려고 한다. 
  그런데 이번에는 2루수의 이름을 모른다! 
  하지만 감독님은 무엇인가 알고 계신 듯하다.
    "1루수가 누구야 2루수 이름이 뭐야 3루수는 몰라"
  야구팀의 선수 리스트를 보고, 뭐가 있는지 찾아보자.
  2루수 이름이 뭐야
입력
- 첫째 줄에 야구팀의 멤버 수 N(1 ≤ N ≤ 1,000)이 주어진다.
  둘째 줄부터 N개의 줄에 걸쳐 선수의 이름이 한 줄에 하나씩 주어진다. 
  한글로 주면 코딩하기 귀찮으므로 한/영키를 누르고 타이핑한 이름이 주어진다. 
  이름은 1글자 이상 99글자 이하이고, 영어 소문자들과 대문자 'Q', 'W', 'E', 'R', 'T', 'O', 'P'로 이루어져 있다.
출력
- 선수들 중 뭐(anj)라는 이름을 가진 사람이 있으면 "뭐야;"를, 없으면 "뭐야?"를 출력한다.
ex 1)
입력      출력
- 3       - 뭐야;
  snrn
  anj
  ahffk
ex 2)
입력      출력
- 4       - 뭐야?
  aptl
  molamolamolamola
  dlqmfkglahqlcl
  QWERTOP
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon17350 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    boolean check = false;

    for (int i = 0; i < n; i++) {
      if (br.readLine().equals("anj")) {
        check = true;
      }
    }

    if (check) System.out.println("뭐야;");
    else System.out.println("뭐야?");
  }
}