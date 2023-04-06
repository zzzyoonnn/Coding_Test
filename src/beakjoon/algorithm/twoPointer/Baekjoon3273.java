package beakjoon.algorithm.twoPointer;
/*
문제
- 0보다 크거나 같은 정수 N이 주어진다. 
  이때, N!을 출력하는 프로그램을 작성하시오.
입력
- 첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.
출력
- 첫째 줄에 N!을 출력한다.
ex 1)
입력		출력
- 10		- 3628800
ex 2)
입력		출력
- 0		- 1
*/
import java.io.*;
import java.util.*;

public class Baekjoon3273 {
	public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int sum = factorial(n);
        System.out.println(sum);
	}
	
	public static int factorial(int n) {
		if(n <= 1) return 1;	// 재귀 종료조건
		return n * factorial(n - 1);
	}
}
