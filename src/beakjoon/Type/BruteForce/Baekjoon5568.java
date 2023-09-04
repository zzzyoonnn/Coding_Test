package beakjoon.Type.BruteForce;
/*
문제
- 상근이는 카드 n(4 ≤ n ≤ 10)장을 바닥에 나란히 놓고 놀고있다. 
  각 카드에는 1이상 99이하의 정수가 적혀져 있다. 
  상근이는 이 카드 중에서 k(2 ≤ k ≤ 4)장을 선택하고, 가로로 나란히 정수를 만들기로 했다. 
  상근이가 만들 수 있는 정수는 모두 몇 가지일까?
  예를 들어, 카드가 5장 있고, 카드에 쓰여 있는 수가 1, 2, 3, 13, 21라고 하자. 
  여기서 3장을 선택해서 정수를 만들려고 한다. 
  2, 1, 13을 순서대로 나열하면 정수 2113을 만들 수 있다. 
  또, 21, 1, 3을 순서대로 나열하면 2113을 만들 수 있다. 
  이렇게 한 정수를 만드는 조합이 여러 가지 일 수 있다.
  n장의 카드에 적힌 숫자가 주어졌을 때, 
  그 중에서 k개를 선택해서 만들 수 있는 정수의 개수를 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 n이, 둘째 줄에 k가 주어진다. 
  셋째 줄부터 n개 줄에는 카드에 적혀있는 수가 주어진다.
출력
- 첫째 줄에 상근이가 만들 수 있는 정수의 개수를 출력한다.
ex 1)
입력    출력
- 4     - 7
  2
  1
  2
  12
  1
ex 2)
입력    출력
- 6     - 68
  3
  72
  2
  12
  7
  2
  1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Baekjoon5568 {
  static int n;     // 주어진 카드의 개수
  static int k;     // 선택할 카드의 장수
  static int card[];
  static boolean used[];
  static Set<Integer> setNum;   // 중복 정수의 저장을 막기 위해 Set 자료형 사용

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    k = Integer.parseInt(br.readLine());

    used = new boolean[11];     // 카드 숫자의 범위가 10까지이기 때문
    card = new int[n];
    setNum = new HashSet<Integer>();    // card배열과 중복된 숫자를 저장할 setNum 초기화

    for (int i = 0; i < n; i++)
      card[i] = Integer.parseInt(br.readLine());

    process(0, 0);  // process 메서드 호출
    System.out.println(setNum.size());
  }

  public static void process(int count, int num) {	// num : 현재까지 조합된 숫자
    if (count == k) {
      setNum.add(num);
      return;
    }

    // 선택한 카드로 가능한 모든 숫자 조합을 만들고 중복 제거
    for (int i = 0; i < n; i++) {
      if (used[i]) continue;    // 이미 사용된 카드라면 pass

      // 사용되지 않았다면 사용해보자
      used[i] = true;

      int temp; // 조합된 숫자 업데이트

      // 카드가 두 자리 숫자라면
      if (card[i] > 9) temp = num * 100 + card[i];
      // 한 자리 숫자라면
      else temp = num * 10 + card[i];

      process(count + 1, temp);

      // 카드 사용 X
      used[i] = false;
    }
  }
}