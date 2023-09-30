package beakjoon.algorithm.implementation;
/*
문제
- 양말 5개가 주어집니다. 
  각 양말에는 숫자가 하나씩 쓰여있습니다. 
  같은 숫자가 쓰인 양말 두 개를 모으면 양말 한 쌍이 됩니다.
  쌍을 만들 수 있는 양말을 두 개씩 두 쌍 빼면 남는 양말에 쓰인 숫자는 무엇인가요?
입력
- 각 양말에 쓰인 숫자 5개가 한 줄에 하나씩 주어집니다. 
  입력으로 주어지는 모든 숫자는 0 이상 9 이하입니다. 
  항상 양말을 두 개씩 두 쌍 만들 수 있는 입력만 주어집니다.
출력
- 첫 줄에 남는 양말에 쓰인 숫자를 출력하세요.
ex 1)
입력        출력
- 6         - 3
  8
  6
  3
  8
ex 2)
입력        출력
- 9         - 9
  9
  9
  0
  0
 */
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Baekjoon28431 {
  public static void main(String[] agrs) {
    Scanner sc = new Scanner(System.in);
    HashSet<Integer> set = new HashSet<>();

    for (int i = 0; i < 5; i++) {
      int n = sc.nextInt();
      if (set.contains(n)) set.remove(n);
      else set.add(n);
    }

    Iterator iter = set.iterator();
    while(iter.hasNext()) {
      System.out.println(iter.next());
    }
  }
}