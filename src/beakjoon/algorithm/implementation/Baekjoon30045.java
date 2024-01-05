package beakjoon.algorithm.implementation;
/*
문제
- 2023년 9월, 여섯 번째로 개최된 ZOAC의 오프닝을 또 맡은 성우는 영과일의 마스코트인 영일이를 이용해 대회를 홍보하기로 했다.
  성우는 홍보 글이 주어질 때 각 문장에 01 또는 OI가 포함되어 있다면 문장 끝에 한 개의 영일이 이모티콘을 넣기로 했다. 
  이때, 홍보 글에 영일이 이모티콘을 총 몇 번 넣어야 하는지 구하여라.
입력
- 첫 번째 줄에 홍보 글의 문장 수 N이 주어진다. (1 <= N <= 500)
  두 번째 줄부터 N개의 줄에 걸쳐 문장 S가 주어진다. 
  S는 공백없이 영문 알파벳과 숫자만으로 이루어짐이 보장된다. (1 <= |S| <= 500) 
출력
- 홍보 글에 영일이 이모티콘을 넣은 횟수를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon30045 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int count = 0;

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      if (s.contains("01") || s.contains("OI")) count++;
    }
    System.out.println(count);
  }
}
