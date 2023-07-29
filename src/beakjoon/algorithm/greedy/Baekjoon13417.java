package beakjoon.algorithm.greedy;
/*
문제
- N장의 카드가 일렬로 놓여있다. 
  각 카드에는 알파벳이 하나씩 적혀있다. 
  태욱이는 가장 왼쪽에 있는 카드부터 차례대로 한 장씩 가져올 수 있다. 
  가장 처음에 가져온 카드는 자신의 앞에 놓는다. 
  그다음부터는 가져온 카드를 자신의 앞에 놓인 카드들의 가장 왼쪽, 또는 가장 오른쪽에 놓는다. 
  태욱이는 모든 카드를 다 가져온 후에 자신의 앞에 놓인 카드를 순서대로 이어 붙여 카드 문자열을 만들려고 한다.
  예를 들어 3장의 카드가 [M, K, U] 순으로 놓여있다고 하자. 
  태욱이는 먼저 가장 왼쪽에 있는 “M”이 적힌 카드를 가져와서 자신의 앞에 놓는다. 
  다음으로 남은 카드 중 가장 왼쪽에 있는 “K”가 적힌 카드를 가져와서 가장 왼쪽에 두고, 
  이어서 “U”가 적힌 카드를 가져와서 다시 가장 왼쪽에 두면 “UKM”이라는 문자열을 만들 수 있다. 
  만약 “K”가 적힌 카드를 가져와서 가장 왼쪽에 두고, 
  이어서 “U”가 적힌 카드를 가져와서 가장 오른쪽에 두면 “KMU”라는 문자열을 만들 수 있다. 
  이때, 태욱이가 만들 수 있는 문자열 중 사전 순으로 가장 빠른 문자열은 “KMU”이다.
  N장의 카드에 적혀있는 알파벳의 처음 순서가 주어질 때, 
  태욱이가 만들 수 있는 카드 문자열 중 사전 순으로 가장 빠른 문자열을 출력하는 프로그램을 작성하시오.
입력
- 입력 데이터는 표준 입력을 사용한다. 
  입력은 T개의 테스트 데이터로 구성된다. 
  입력의 첫째 줄에 테스트 케이스의 개수를 나타내는 자연수 T가 주어진다. 
  각각의 테스트 케이스의 첫째 줄에 처음에 놓여있는 카드의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 
  두 번째 줄에는 N장의 카드에 적힌 알파벳의 초기 순서가 주어진다. 
  가장 왼쪽에 있는 카드에 적혀있는 알파벳부터 순서대로 N개가 공백으로 구분되어 주어진다. 
  모든 카드에는 한 개씩의 알파벳이 적혀있으며, 모두 대문자이다. 
출력
- 출력은 표준 출력을 사용한다. 입력받은 데이터에 대해, 
  한 줄에 1개씩 태욱이가 만들 수 있는 문자열 중에서 사전 순으로 가장 빠른 문자열을 출력한다.
ex 1)
입력        출력
- 3         - KMU
  3           ASDFG
  M K U       AAABCBC
  5
  A S D F G
  7
  B A C A B A C
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon13417 {

  //static int n; // 테스트 케이스의 개수
  //static int m; // 카드의 개수
  //static String result; // 결과 문자열
  //static char word; // 현재 조합중인 카드

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());  // 테스트 케이스의 개수

    for (int i = 0; i < n; i++) {
      int m = Integer.parseInt(br.readLine());  // 카드의 개수
      StringTokenizer st = new StringTokenizer(br.readLine());

      char word = st.nextToken().charAt(0);  // 현재 조합중인 카드, 첫 번째 카드를 word 변수에 저장
      String result = Character.toString(word);  // 결과 문자열, 첫 번째 카드를 결과 문자열에 저장

      char new_word;
      for (int j = 1; j < m; j++) { // 두 번째 카드부터 마지막 카드까지 반복
        new_word = st.nextToken().charAt(0);    // 새로운 카드를 new_word 변수에 저장
        if (word >= new_word) { // 현재 조합 중인 카드보다 새로운 카드가 작거나 같으면
          word = new_word;  // 새로운 카드를 현재 조합 중인 카드로 설정
          result = Character.toString(new_word) + result;   // 새로운 카드를 결과 문자열의 맨 앞에 추가
        } else {
          result = result + Character.toString(new_word);   // 새로운 카드를 결과 문자열의 맨 뒤에 추가
        }
      }
      System.out.println(result);
    }
  }
}
