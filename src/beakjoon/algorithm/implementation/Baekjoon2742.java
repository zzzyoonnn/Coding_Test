package beakjoon.algorithm.implementation;
/*
문제
- 자연수 N이 주어졌을 때, 1부터 N까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
입력
- 첫째 줄에 100,000보다 작거나 같은 자연수 N이 주어진다.
출력
- 첫째 줄부터 N번째 줄 까지 차례대로 출력한다.
ex 1)
입력		출력
- 5			- 1
			  2
			  3
			  4
			  5
*/
import java.io.*;
import java.util.*;

public class Baekjoon2742 {
	public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= n; i++) {
        	System.out.println(i);
        }
	}
}
