package beakjoon.algorithm.implementation;
/*
문제
- 두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.
입력
- 첫째 줄에 A와 B가 주어진다. A와 B는 공백 한 칸으로 구분되어져 있다.
출력
- 첫째 줄에 다음 세 가지 중 하나를 출력한다.
  A가 B보다 큰 경우에는 '>'를 출력한다.
  A가 B보다 작은 경우에는 '<'를 출력한다.
  A와 B가 같은 경우에는 '=='를 출력한다.
제한
- -10,000 ≤ A, B ≤ 10,000
ex 1)
입력		출력
- 1 2		- <
ex 2)
입력		출력
- 10 2		- >
ex 1)
입력		출력
- 5 5		- =
*/
import java.io.*;
import java.util.*;

public class Baekjoon1330 {
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		if (a > b) System.out.println(">");
		else if (a < b) System.out.println("<");
		else System.out.println("==");
	}
}
