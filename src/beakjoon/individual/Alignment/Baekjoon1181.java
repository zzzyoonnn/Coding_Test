package beakjoon.individual.Alignment;
/*
문제
- 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
    1. 길이가 짧은 것부터
    2. 길이가 같으면 사전 순으로
  단, 중복된 단어는 하나만 남기고 제거해야 한다.
입력
- 첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 
  둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 
  주어지는 문자열의 길이는 50을 넘지 않는다.
출력
- 조건에 따라 정렬하여 단어들을 출력한다.
ex 1)
입력              출력
- 13            - i
  but             im
  i               it
  wont            no
  hesitate        but
  no			  more
  more			  wait
  no		      wont
  more			  yours
  it			  cannot
  cannot		  hesitate
  wait
  im
  yours
*/
import java.io.*;
import java.util.*;

public class Baekjoon1181 {
  public static void main(String[] agrs) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] word = new String[n];
    for (int i = 0; i < n; i++) word[i] = sc.next();
    
    Arrays.sort(word, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        if (s1.length() == s2.length()) return s1.compareTo(s2);
        else return s1.length() - s2.length();
      }
    });
    
    StringBuilder sb = new StringBuilder();
    sb.append(word[0]).append('\n');
		
    for (int i = 1; i < word.length; i++) {
      if (!word[i].equals(word[i - 1])) sb.append(word[i]).append('\n');
      else continue;
    }
    System.out.println(sb);
  }
}