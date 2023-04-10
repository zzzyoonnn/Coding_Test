package beakjoon.algorithm.implementation;
/*
문제
- 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
입력
- 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
출력
- 첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
ex 1)
입력		출력
- 5			- *
			  **
			  ***
			  ****
			  *****
*/
import java.io.*;
import java.util.*;

public class Baekjoon2438 {
	public static void main(String[] agrs) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       
       for (int i = 1; i <= n; i++) {
    	   for (int j = 1; j <= i; j++) {
    		   System.out.print("*");
    	   }
    	   System.out.println();
       }
	}
}
