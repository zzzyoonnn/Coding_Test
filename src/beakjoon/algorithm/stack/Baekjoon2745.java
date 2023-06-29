package beakjoon.algorithm.stack;
/*
문제
- 어떤 사람의 C언어 성적이 주어졌을 때, 평점은 몇 점인지 출력하는 프로그램을 작성하시오.
  A+: 4.3, A0: 4.0, A-: 3.7
  B+: 3.3, B0: 3.0, B-: 2.7 
  C+: 2.3, C0: 2.0, C-: 1.7
  D+: 1.3, D0: 1.0, D-: 0.7
  F: 0.0
입력
- 첫째 줄에 C언어 성적이 주어진다. 
  성적은 문제에서 설명한 13가지 중 하나이다.
출력
- 첫째 줄에 C언어 평점을 출력한다.
ex 1)
입력		출력
- A0        - 4.0
 */
import java.io.IOException;
import java.util.Scanner;

public class Baekjoon2745 {
  public static void main(String[] agrs) {
    Scanner sc = new Scanner(System.in);
    String input = sc.next(); 

    if (input.equals("A+")) System.out.println(4.3);
    else if (input.equals("A0")) System.out.println(4.0);
    else if (input.equals("A-")) System.out.println(3.7);
    else if (input.equals("B+")) System.out.println(3.3);
    else if (input.equals("B0")) System.out.println(3.0);
    else if (input.equals("B-")) System.out.println(2.7);
    else if (input.equals("C+")) System.out.println(2.3);
    else if (input.equals("C0")) System.out.println(2.0);
    else if (input.equals("C-")) System.out.println(1.7);
    else if (input.equals("D+")) System.out.println(1.3);
    else if (input.equals("D0")) System.out.println(1.0);
    else if (input.equals("D-")) System.out.println(0.7);
    else System.out.println(0.0);
  }
}
