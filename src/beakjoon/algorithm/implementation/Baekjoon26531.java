package beakjoon.algorithm.implementation;
/*
문제
- You have hired someone to help you with inventory on the farm. 
  Unfortunately, the new cowhand has very limited math skills, and they are having trouble summing two numbers. 
  Write a program to determine if the cowhand is adding these numbers correctly.
입력
- The first and only line of input contains a string of the form:
  a + b = c
  It is guaranteed that a, b, and c are single-digit integers. 
  The input line will have exactly 9 characters, formatted exactly as shown, 
  with a single space separating each number and arithmetic operator.
출력
- Print on a single line, YES if the sum is correct; otherwise, print NO.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon26531 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    String p = st.nextToken();
    int b = Integer.parseInt(st.nextToken());
    String e = st.nextToken();
    int c = Integer.parseInt(st.nextToken());

    if (c == (a + b)) System.out.println("YES");
    else System.out.println("NO");
  }
}
