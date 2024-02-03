package beakjoon.algorithm.implementation;
/*
문제
- 서울사이버대학을 다니고 나의 성공 시대 시작됐다
  서울사이버대학을 다니고 나를 찾는 회사 많아졌다
  서울사이버대학을 다니고 내 인생이 달라졌다
  미래를 바꾸는 전략
  서울사이버대학교
  서울사이버대학교 로고송은 중독성 강한 멜로디로 매우 매우 유명하다. 
  빅데이터·AI센터에서 데이터 분석을 하던 노교수와 천교수는 어디선가 들려오는 로고송을 듣고 
  가장 많이 사용된 글자가 몇 번이나 등장하는지 궁금해졌다.
  멜로디에 중독된 두 교수를 대신해서 가장 많이 사용된 글자가 몇 번 등장하는지를 출력하자.
입력
- 첫 번째 줄에 로고송의 길이 N이 주어진다. (1 <= N <= 10^5) 
  두 번째 줄에 로고송이 한 줄의 문자열로 주어진다. 
  문자열은 서울사이버대학교 로고송의 영문 번역이 반복되는 형태로 주어지며, 
  알파벳 소문자와 띄어쓰기, 쉼표, 마침표로만 구성되어 있다. 
  줄이 띄어쓰기로 끝나는 경우는 주어지지 않는다.
출력
- 첫 번째 줄에 가장 많이 등장한 알파벳의 등장 횟수를 출력한다. (띄어쓰기, 쉼표, 마침표는 세지 않는다.)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon30958 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String s = br.readLine();
    int[] arr = new int[26];

    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      if (c == ' ' || c == ',' || c == '.') continue;
      arr[c - 'a']++;
    }

    Arrays.sort(arr);
    System.out.println(arr[25]);
  }
}
