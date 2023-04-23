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
import java.io.*;
import java.util.*;

public class Baekjoon1212 {
	public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스 갯수
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(),",");
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	System.out.println(a + b);
        }
	}
}
