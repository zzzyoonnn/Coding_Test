package beakjoon.Type.BruteForce;
/*
문제
- 곧 졸업을 앞둔 민호는 대학교 생활 동안 
  구매만 해놓고 한 번도 펴보지 않은 전공책에 먼지가 쌓여 있는 것을 보고는, 
  이 책들을 어떻게 처리해야 할지 고민 중이다. 
  열심히 고민한 끝에 민호는 결국 전공책을 모두 버리기로 마음먹었다. 
  하지만 그냥 버리기엔 심심한 민호는 
  전공책 제목에 있는 글자들을 오려서 단어 만들기 놀이를 하려고 한다. 
  단어 만들기 놀이는 아래 예시와 같다.
    1번 책 : COMPUTERARCHITECTURE (35,000원)
    2번 책 : ALGORITHM (47,000원)
    3번 책 : NETWORK (43,000원)
    4번 책 : OPERATINGSYSTEM (40,000원)
  만약 민호가 만들고 싶은 단어가 ALMIGHTY라고 하면, 
  위 4개의 책 중, 1번 책에서 A를, 
  2번 책에서 L, M, I, G, H, T를, 
  4번 책에서 Y를 오려내어 원하는 단어를 만들 수 있다. 
  이때 드는 비용은 1번, 2번, 4번 책 가격의 합인 122,000원이다.
  만약 ANT라는 단어를 만들고 싶다고 하면, 
  2번 책에서 A를, 3번 책에서 N, T를 오려내어 원하는 단어를 만들 수 있다. 
  이때 드는 비용은 2번과 3번 책 가격을 합하여 90,000원이다. 
  그런데, ANT라는 단어에서 A를 2번 책에서 오려내지 않고, 4번 책에 있는 A를 오려낼 수도 있다. 
  만약 4번 책에서 A를 오려냈을 때 드는 비용은 
  3번과 4번 책 가격을 합하여 83,000원으로 2번과 3번 책을 고른 비용보다 작다. 
  하지만, 4번 책에는 ANT가 모두 포함되어 있으므로, 
  4번 책만 선택했을 때 드는 비용이 40,000원이다. 
  이는 ANT라는 단어를 만들기 위해서 가장 적은 비용이다.
  민호는 여러 개의 전공책들을 나열해 놓고는, 
  심각한 고민 끝에 전공책 제목에 있는 글자를 오려내어 
  자신이 원하는 단어를 만들기 위해서는 여러 가지 경우가 있다는 것을 깨달았다. 
  매우 심심했던 민호는 가장 적은 비용으로 
  자신이 원하는 단어를 만들려면 어떤 전공책들을 선택해야 하는지 궁금했다. 
  하지만 일일이 가능한 조합을 만들어 보는 것은 매우 시간 낭비라고 생각한 민호는 
  컴퓨터공학과답게 프로그램을 만들려고 한다.
  민호를 도와 각 전공책의 가격과 제목이 주어졌을 때, 
  가장 적은 비용으로 민호가 원하는 단어를 만들기 위해서 어떤 전공책을 선택해야 하는지 알아보자.
입력
- 첫 번째 줄에는 민호가 만들고자 하는 단어를 의미하는 문자열 T (1 ≤ |T| ≤ 10)가 주어진다. 
  T는 항상 대문자이며, |T|는 문자열 T의 길이를 의미한다.
  두 번째 줄에는 민호가 가진 전공책의 개수를 의미하는 정수 N (1 ≤ N ≤ 16)이 주어진다.
  다음 N개의 각 줄에는 전공책 가격을 의미하는 정수 Ci (10,000 ≤ Ci ≤ 100,000)와 
  제목을 의미하는 문자열 Wi (1 ≤ |Wi| ≤ 50)가 주어진다. 
  Wi는 항상 대문자이다.
출력
- 민호가 원하는 단어 T를 만들기 위해서 선택해야 하는 전공책의 가장 적은 가격의 합을 출력한다. 
만약 단어를 만들 수 없다면 -1을 출력한다.
ex 1)
입력        출력
- ANT       - 40000
  4
  35000 COMPUTERARCHITECTURE
  47000 ALGORITHM
  43000 NETWORK
  40000 OPERATINGSYSTEM
ex 2)
입력            출력
- ALMIGHTY      - 87000
  4
  35000 COMPUTERARCHITECTURE
  47000 ALGORITHM
  43000 NETWORK
  40000 OPERATINGSYSTEM
ex 3)
입력            출력
- BAKEJOON      - 65000
  3
  25000 JAVA
  10000 OOP
  30000 BINARYCHECK
ex 4)
입력        출력
- JAVA      - -1
  2
  30000 CPLUSPLUS
  25000 PYTHON
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Book {
  int price;
  String title;

  Book(int price, String title) {
    this.price = price;
    this.title = title;
  }
}

public class Baekjoon16508 {
  static ArrayList<Book> arr = new ArrayList<>();   // Book 객체의 ArrayList
  static String s;
  static int[] count = new int[26];
  static int[] select = new int[26];
  static int n, min = Integer.MAX_VALUE;

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    s = br.readLine();
    n = Integer.parseInt(br.readLine());

    for (int i = 0; i < s.length(); i++) count[s.charAt(i) - 'A']++;

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int price = Integer.parseInt(st.nextToken());
      String title = st.nextToken();

      arr.add(new Book(price, title));
    }

    dfs(0, 0);
    System.out.println(min == Integer.MAX_VALUE ? -1 : min);
  }

  static void dfs(int depth, int total) {
    if (depth == n) {
      if (check()) min = Math.min(total, min);
      return;
    }

    // depth번째 책을 선택 하느냐 선택하지 않느냐 두가지 방법 존재

    // 현재 책의 제목 문자들의 빈도수를 증가시킴
    for (int i = 0; i < arr.get(depth).title.length(); i++) {
      select[arr.get(depth).title.charAt(i) - 'A']++;
      // arr.get(depth) : 현재 처리중인 깊이(depth)에 해당하는 책 가져옴
    }
    // 현재 책을 선택하고 다음 깊이로 이동
    dfs(depth + 1, total + arr.get(depth).price);

    // 현재 책의 제목 문자들의 빈도수를 감소시킴 (이전 상태로 되돌림)
    for (int i = 0; i < arr.get(depth).title.length(); i++) {
      select[arr.get(depth).title.charAt(i) - 'A']--;
    }

    // 현재 책을 선택하지 않고 다음 깊이로 이동
    dfs(depth + 1, total);
  }

  static boolean check() {
    for (int i = 0; i < 26; i++) {
      if (count[i] > select[i]) return false;
    }
    return true;
  }
}
