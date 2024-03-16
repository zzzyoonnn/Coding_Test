package beakjoon.algorithm.implementation;
/*
문제
- 친구가 적은 성민이는 수업에 결석해도 시험이나 과제에 대한 정보를 제대로 얻을 수 없었다. 
  F 학점을 받을 위기까지 아슬아슬하게 결석일 수를 유지하던 성민이는, 어느 날 갑자기 영문도 모른 채 쪽지시험을 보게 되었다!
  갑작스러운 쪽지 시험으로 마음이 급해진 성민이는 매직아이를 사용해 벼락치기를 하기로 한다.
  성민이가 듣는 과목의 교과서는, 알파벳 소문자(a-z)와 알파벳 대문자(A-Z)로만 이루어져 있다. 
  성민이가 교과서에서 찾고자 하는 키워드도 역시 알파벳 소문자와 대문자로만 이루어져 있다. 
  하지만, 성민이에겐 큰 문제가 생겼다. 
  결석한 날의 수업 내용을 친구에게 빌려 필기를 하던 중, 교과서에 숫자(0-9)를 적어버린 것이다.
  키워드를 찾기 힘들어 패닉에 빠진 성민이는 몇 안 되는 친구인 당신에게 도움을 요청했다. 
  성민이를 도와, 교과서에서 성민이가 찾고자 하는 키워드의 존재 여부를 알려주자.
입력
- 첫 번째 줄에는 알파벳 소문자, 대문자, 숫자로 이루어진 문자열 S가 주어진다. (1 ≤ |S| ≤ 200,000) 
  두 번째 줄에는 성민이가 찾고자 하는 알파벳 소문자, 대문자로만 이루어진 키워드 문자열 K가 주어진다. (1 ≤ |K| ≤ 200,000)
  단, 입력으로 들어오는 키워드 문자열 K의 길이는, 교과서의 문자열 S보다 짧거나 같다.
출력
- 첫 번째 줄에 성민이가 찾고자 하는 키워드가 교과서 내에 존재하면 1, 존재하지 않으면 0을 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon16172 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    String k = br.readLine();

    s = s.replaceAll("[0-9]", "");      // 문자열 s에서 숫자 제거

    System.out.println(kmp(s, k) ? 1 : 0);
  }

  // KMP 알고리즘을 구현한 메서드
  static boolean kmp(String s, String k) {
    int[] arr = makeArr(k);     // k의 패턴을 이용한 배열 생성

    int sl = s.length();
    int kl = k.length();

    int index = 0;
    for (int i = 0; i < sl; i++) {
      // 패턴이 일치하지 않으면 인덱스 이동
      while (index > 0 && s.charAt(i) != k.charAt(index)) {
        index = arr[index - 1];
      }

      if (s.charAt(i) == k.charAt(index)) {
        if (index == kl - 1) {      // 패턴이 끝에 도달한 경우
          index = arr[index];
          return true;
        } else {
          index++;
        }
      }
    }
    return false;
  }

  // 패턴을 이용하여 배열을 만드는 메서드
  static int[] makeArr(String k) {
    int n = k.length();
    int[] arr = new int[n];

    int index = 0;
    for (int i = 1; i < n; i++) {
      // 패턴이 일치하지 않으면 인덱스를 조정하여 이동
      while (index > 0 && k.charAt(i) != k.charAt(index)) {
        index = arr[index - 1];
      }

      if (k.charAt(i) == k.charAt(index)) {     // 패턴이 일치하는 경우
        index++;
        arr[i] = index;
      }
    }
    return arr;
  }
}
