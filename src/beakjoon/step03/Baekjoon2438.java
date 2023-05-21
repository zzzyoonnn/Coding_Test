package beakjoon.step03;
/*
문제
- 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
입력
- 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
출력
- 첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
ex 1)
입력
- 5
출력
- *
  **
  ***
  ****
  *****
*/
import java.io.*;
import java.util.*;

public class Baekjoon2438 {
	public static void main(String[] args) throws IOException {
        int a;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        a = Integer.parseInt(br.readLine());
        
        br.close();
        
        for(int i = 1; i <= a; i++) {
        	for (int j = 1; j <= i; j++) {
        		System.out.printf("*");
        	}
        	System.out.println();
        }
    }
}
