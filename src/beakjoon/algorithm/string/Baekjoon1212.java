package beakjoon.algorithm.string;
/*
문제
- 8진수가 주어졌을 때, 2진수로 변환하는 프로그램을 작성하시오.
입력
- 첫째 줄에 8진수가 주어진다. 주어지는 수의 길이는 333,334을 넘지 않는다.
출력
- 첫째 줄에 주어진 수를 2진수로 변환하여 출력한다. 
  수가 0인 경우를 제외하고는 반드시 1로 시작해야 한다.
ex 1)
입력		출력
- 314		- 11001100
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1212 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      switch (c) {
        case '0' : sb.append("000"); break;
        case '1' : sb.append("001"); break;
        case '2' : sb.append("010"); break;
        case '3' : sb.append("011"); break;
        case '4' : sb.append("100"); break;
        case '5' : sb.append("101"); break;
        case '6' : sb.append("110"); break;
        case '7' : sb.append("111"); break;
      }
    }
    if (sb.charAt(0) == '0') sb.deleteCharAt(0);
    if (sb.charAt(0) == '0') sb.deleteCharAt(0);
    System.out.println(sb);
  }
}
